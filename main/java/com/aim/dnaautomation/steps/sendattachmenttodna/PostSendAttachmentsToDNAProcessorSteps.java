package com.aim.dnaautomation.steps.sendattachmenttodna;

import com.aim.automation.helpers.CustomFilterableRequestSpecification;
import com.aim.automation.helpers.RequestOperationsHelper;
import com.aim.dnaautomation.dtos.sendattachmenttodna.SendAttachmentsToDnaProcessorResponseDTO;
import com.aim.dnaautomation.factories.sendattachmenttodna.SendAttachmentsToDnaProcessorRequestDTOFactory;
import com.aim.dnaautomation.helpers.constants.BasePathConstants;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import java.util.List;

public class PostSendAttachmentsToDNAProcessorSteps {
    private CustomFilterableRequestSpecification requestSpecification;
    private RequestOperationsHelper requestOperationsHelper;

    /**
     * Constructor is accepting pre-populated {@link CustomFilterableRequestSpecification} object
     *
     * @param requestSpecification
     */

    public PostSendAttachmentsToDNAProcessorSteps(CustomFilterableRequestSpecification requestSpecification) {

        this.requestSpecification = new CustomFilterableRequestSpecification(requestSpecification);
        this.requestOperationsHelper = new RequestOperationsHelper();
        Headers headers = this.requestSpecification.getFilterableRequestSpecification().getHeaders();
        this.requestSpecification.setContentType(ContentType.JSON);
        this.requestSpecification.addHeaders(headers);
        this.requestSpecification.addBasePath(BasePathConstants.SEND_ATTACHMENTS_TO_DNA_PROCESSOR);

    }

    /**
     * Constructor which accepts PlatformContext and Headers as arguments
     *
     * @param platformContext platformContext to be added to Request
     * @param headers         Headers to be added to the request
     */

    public void postSendAttachmentsToDnaProcessorSteps(String platformContext, Headers headers) {

        this.requestSpecification = new CustomFilterableRequestSpecification(requestSpecification);
        this.requestOperationsHelper = new RequestOperationsHelper();
        this.requestSpecification.addHeaders(headers);
        this.requestSpecification.addBasePath(BasePathConstants.SEND_ATTACHMENTS_TO_DNA_PROCESSOR);
        this.requestSpecification.addPlatformContextToRequest(platformContext);

    }

    public SendAttachmentsToDnaProcessorResponseDTO[] createPostSendAttachmentsToDNAProcessorSteps(List<String> attachmentId, String caseId) {

        SendAttachmentsToDnaProcessorRequestDTOFactory requestDTOFactory = new SendAttachmentsToDnaProcessorRequestDTOFactory();
        Object body = requestDTOFactory.createSendAttachmentsToDnaProcessorRequestDTOFactory(attachmentId, caseId);
        this.requestSpecification.addBodyToRequest(body);
        Response response = createPostSendAttachmentsToDNAProcessorStep(requestSpecification);
        response.then().statusCode(HttpStatus.SC_OK);
        return response.as(SendAttachmentsToDnaProcessorResponseDTO[].class);
    }

    public Response createPostSendAttachmentsToDNAProcessorStep(CustomFilterableRequestSpecification requestSpecification) {

        return this.requestOperationsHelper.sendPostRequest(requestSpecification.getFilterableRequestSpecification());

    }
}
