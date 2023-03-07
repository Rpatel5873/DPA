package com.aim.dnaautomation.steps.sendattachmenttodna;

import com.aim.automation.helpers.CustomFilterableRequestSpecification;
import com.aim.automation.helpers.RequestOperationsHelper;
import com.aim.dnaautomation.factories.sendattachmenttodna.SendAttachmentToDnaProcessorRequestDTOFactory;
import com.aim.dnaautomation.helpers.constants.BasePathConstants;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

public class PostSendAttachmentToDNAProcessorSteps {

    private CustomFilterableRequestSpecification requestSpecification;
    private RequestOperationsHelper requestOperationsHelper;

    /**
     * Constructor is accepting pre-populated {@link CustomFilterableRequestSpecification} object
     *
     * @param requestSpecification
     */

    public PostSendAttachmentToDNAProcessorSteps(CustomFilterableRequestSpecification requestSpecification) {

        this.requestSpecification = new CustomFilterableRequestSpecification(requestSpecification);
        this.requestOperationsHelper = new RequestOperationsHelper();
        Headers headers = this.requestSpecification.getFilterableRequestSpecification().getHeaders();
        this.requestSpecification.setContentType(ContentType.JSON);
        this.requestSpecification.addHeaders(headers);
        this.requestSpecification.addBasePath(BasePathConstants.SEND_ATTACHMENT_TO_DNA_PROCESSOR);

    }

    /**
     * Constructor which accepts PlatformContext and Headers as arguments
     *
     * @param platformContext platformContext to be added to Request
     * @param headers         Headers to be added to the request
     */

    public void postSendAttachmentToDnaProcessorSteps(String platformContext, Headers headers) {

        this.requestSpecification = new CustomFilterableRequestSpecification(requestSpecification);
        this.requestOperationsHelper = new RequestOperationsHelper();
        this.requestSpecification.addHeaders(headers);
        this.requestSpecification.addBasePath(BasePathConstants.SEND_ATTACHMENT_TO_DNA_PROCESSOR);
        this.requestSpecification.addPlatformContextToRequest(platformContext);

    }

    public String createPostSendAttachmentToDNAProcessorSteps(String attachmentId, String caseId) {

        SendAttachmentToDnaProcessorRequestDTOFactory requestDTOFactory = new SendAttachmentToDnaProcessorRequestDTOFactory();
        Object body = requestDTOFactory.createSendAttachmentToDnaProcessorRequestDTOFactory(attachmentId, caseId);
        this.requestSpecification.addBodyToRequest(body);
        Response response = createPostSendAttachmentToDNAProcessorSteps(requestSpecification);
        response.then().statusCode(HttpStatus.SC_OK);
        return response.body().path("transactionId");

    }

    public Response createPostSendAttachmentToDNAProcessorSteps(CustomFilterableRequestSpecification requestSpecification) {

        return this.requestOperationsHelper.sendPostRequest(requestSpecification.getFilterableRequestSpecification());

    }
}
