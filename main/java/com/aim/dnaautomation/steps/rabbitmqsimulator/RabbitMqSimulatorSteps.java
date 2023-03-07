package com.aim.dnaautomation.steps.rabbitmqsimulator;

import com.aim.automation.helpers.CustomFilterableRequestSpecification;
import com.aim.automation.helpers.EnvironmentHelper;
import com.aim.automation.helpers.RequestOperationsHelper;
import com.aim.automation.helpers.enums.DomainEnum;
import com.aim.dnaautomation.dtos.rabbitmqsimulator.PayloadV3DTO;
import com.aim.dnaautomation.dtos.sendattachmenttodna.CaseSaveEventRequestDTO;
import com.aim.dnaautomation.enums.ExchangeEnum;
import com.aim.dnaautomation.enums.RoutingKeyEnum;
import com.aim.dnaautomation.factories.rabbitmqsimulator.CaseSaveEventRequestDTOFactory;
import com.aim.dnaautomation.factories.rabbitmqsimulator.PayloadV3DTOFactory;
import com.aim.dnaautomation.helpers.constants.BasePathConstants;
import com.aim.dnaautomation.helpers.rabbitmqconstants.Constants;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.List;

public class RabbitMqSimulatorSteps {

    private CustomFilterableRequestSpecification requestSpecification;

    public RabbitMqSimulatorSteps(CustomFilterableRequestSpecification requestSpecification) {
        this.requestSpecification = new CustomFilterableRequestSpecification(requestSpecification);
        this.requestSpecification.addBasePath(BasePathConstants.SIMULATOR_PATH);
        this.requestSpecification.addBaseURI(new EnvironmentHelper().constructBaseURIForDomain(DomainEnum.CLINICAL));

    }

    public Response addEventToRabbitMQThroughSimulator(Object requestBody, HashMap<String, String> additionalHeaders,
                                                       String routingKey, String exchangeType, String messageType) {

        PayloadV3DTO simulatorRequestBody = new PayloadV3DTOFactory().createPayloadV3DTO(additionalHeaders, requestBody);
        requestSpecification.addCustomHeader("routing-key", routingKey);
        requestSpecification.addCustomHeader("exchange-type", exchangeType);
        requestSpecification.addCustomHeader("message-type", messageType);
        requestSpecification.addBodyToRequest(simulatorRequestBody);

        return new RequestOperationsHelper().sendPostRequest(requestSpecification.getFilterableRequestSpecification());

    }

    public void createCaseSavedEventRequestPayload(String caseId, List<String> attachmentIds) {

        CaseSaveEventRequestDTO eventRequestDTO = new CaseSaveEventRequestDTOFactory().
                createCaseSaveEventRequestDTOFactory(caseId, attachmentIds);

        // Create Additional Headers
        HashMap<String, String> additionalHeaders = new HashMap<>();
        additionalHeaders.put("bus-correlation-id", Constants.BUS_CORRELATION_ID);
        additionalHeaders.put("correlation-id", Constants.CORRELATION_ID);
        additionalHeaders.put("request-id", Constants.REQUEST_ID);
        additionalHeaders.put("service-consumer", Constants.SERVICE_CONSUMER);
        additionalHeaders.put("type", Constants.MESSAGE_TYPE);

        Response response = addEventToRabbitMQThroughSimulator(eventRequestDTO, additionalHeaders,
                RoutingKeyEnum.rbm_Case_Save_Event.getRoutingKey(),
                ExchangeEnum.exchange_stream.getExchange(), Constants.MESSAGE_TYPE);
        response.then().statusCode(HttpStatus.SC_ACCEPTED);


    }

}
