package com.aim.dnaautomation.helpers.attachmentutilities;

import com.aim.automation.helpers.CustomFilterableRequestSpecification;
import com.aim.automation.helpers.EnvironmentHelper;
import com.aim.automation.helpers.PropertiesUtils;
import com.aim.automation.helpers.enums.DomainEnum;
import com.aim.automation.tests.base.BaseTest;
import com.aim.dnaautomation.helpers.rabbitmqconstants.Constants;
import com.aim.dnaautomation.steps.manageattachments.PostManageAttachmentsV2Steps;
import com.aim.dnaautomation.steps.rabbitmqsimulator.RabbitMqSimulatorSteps;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import io.restassured.http.Headers;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

public class PostManageAttachmentUtility extends BaseTest {

    private final String attachmentLocation = Constants.ATTACHMENT_FOLDER;
    private UUID uuid;
    private String file;
    private String size;
    private InputStream uploadFile;
    private String attachmentId;
    private String displayName;
    private String fileType;
    private String CONFIG = "config.properties";
    private CustomFilterableRequestSpecification requestSpecification;


    public PostManageAttachmentUtility(CustomFilterableRequestSpecification requestSpecification) {

        this.requestSpecification = new CustomFilterableRequestSpecification(requestSpecification);
        this.requestSpecification.addBaseURI(new EnvironmentHelper().constructBaseURIForDomain(DomainEnum.COMMUNICATIONS));
        Headers headers = this.requestSpecification.getFilterableRequestSpecification().getHeaders();
        this.requestSpecification.addHeaders(headers);
        uuid = UUID.randomUUID();
        displayName = Constants.DISPLAY_NAME_PARAMETER;
        uploadFileName = uuid + ".pdf";

    }

    private static void doWork(String task) throws InterruptedException {
        for (char ch : task.toCharArray()) {
            if (ch == '.') {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException _ignored) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public String createAttachmentIdFromManageAttachmentsV2AndReturnAttachmentId() throws IOException {

        file = Constants.TEST_PNG_FILE;
        fileType = Constants.PNG_ATTACHMENT_TYPE;
        uploadFileName = uuid + ".png";
        uploadFile = ReadContentResourceFiles.readContentResourceFile(attachmentLocation, file);
        size = String.valueOf(uploadFile.available());
        String attachmentId = new PostManageAttachmentsV2Steps(requestSpecification).PostAttachment(
                uploadFile, uploadFileName, fileType);

        return attachmentId;

    }

    public List<String> rabbitMQReceiver(String listenerQueue, String caseId, List<String> attachmentIds,
                                         String exchange, String routingKey, String routingKeys) throws IOException, TimeoutException, InterruptedException {

        // Read RabbitMQ configuration from config.properties file
        Properties properties = new PropertiesUtils().loadProps(CONFIG);
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(properties.getProperty("rabbitMQHost"));
        factory.setPort(Integer.parseInt(properties.getProperty("rabbitMQPort")));
        factory.setUsername(properties.getProperty("rabbitMQUserName"));
        factory.setPassword(properties.getProperty("rabbitMQPassword"));
        factory.setVirtualHost(properties.getProperty("rabbitMQVirtualHost"));
        final Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();

        // Create Rabbit Queue on fly
        channel.queueDeclare(listenerQueue, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, null);
        channel.queueBind(listenerQueue, exchange, routingKey);
        channel.queueBind(listenerQueue, exchange, routingKeys);
        Thread.sleep(10000);

        // Trigger RBM Case Saved Event Through Rabbit Simulator API
        new RabbitMqSimulatorSteps(requestSpecification).createCaseSavedEventRequestPayload
                (caseId, attachmentIds);

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        channel.basicQos(1);

        List<String> response = new ArrayList<>();
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
            response.add(message);
            try {
                doWork(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(" [x] Done");
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
            }
        };
        channel.basicConsume(listenerQueue, false, deliverCallback, consumerTag -> {
        });
        while (response.isEmpty()) {
            Thread.sleep(1000);
        }
        // Delete The Rabbit Queue and return the Payload
        channel.queueDelete(listenerQueue);
        return response;

    }


}
