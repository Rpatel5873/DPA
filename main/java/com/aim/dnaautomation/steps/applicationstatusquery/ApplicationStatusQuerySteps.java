package com.aim.dnaautomation.steps.applicationstatusquery;

import com.aim.automation.helpers.CustomFilterableRequestSpecification;
import com.aim.automation.helpers.RequestOperationsHelper;
import com.aim.automation.helpers.constants.BasePathConstants;
import com.aim.dnaautomation.dtos.applicationstatusquery.DnaApplicationEventStatusResponseDTO;
import com.aim.dnaautomation.factories.applicationstatusquery.ApplicationStatusQueryRequestDTOFactory;
//import com.aim.dnaautomation.helpers.constants.BasePathConstants;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;



import java.util.Arrays;
import java.util.List;

import static com.aim.automation.helpers.constants.BasePathConstants.*;
import static com.aim.dnaautomation.helpers.constants.BasePathConstants.APPLICATION_STATUS_QUERY;

public class ApplicationStatusQuerySteps {

    private CustomFilterableRequestSpecification requestSpecification;
    private RequestOperationsHelper requestOperationsHelper;

    /**
     * Constructor is accepting pre-populated {@link CustomFilterableRequestSpecification} object
     *
     * @param requestSpecification
     */

    public ApplicationStatusQuerySteps(CustomFilterableRequestSpecification requestSpecification) {

        this.requestSpecification = new CustomFilterableRequestSpecification(requestSpecification);
        this.requestOperationsHelper = new RequestOperationsHelper();
        Headers headers = this.requestSpecification.getFilterableRequestSpecification().getHeaders();
        this.requestSpecification.setContentType(ContentType.JSON);
        this.requestSpecification.addHeaders(headers);
        this.requestSpecification.addBasePath(APPLICATION_STATUS_QUERY);

    }

//    /**
//     * Constructor which accepts PlatformContext and Headers as arguments
//     *
//     * @param platformContext platformContext to be added to Request
//     * @param headers         Headers to be added to the request
//     */
//
//    public void ApplicationStatusQuerySteps(String platformContext, Headers headers) {
//
//        this.requestSpecification = new CustomFilterableRequestSpecification(requestSpecification);
//        this.requestOperationsHelper = new RequestOperationsHelper();
//        this.requestSpecification.addHeaders(headers);
//        this.requestSpecification.addBasePath(BasePathConstants.APPLICATION_STATUS_QUERY);
//        this.requestSpecification.addPlatformContextToRequest(platformContext);
//
//    }

    public List<DnaApplicationEventStatusResponseDTO> constructApplicationStatusQueryServiceRequest(String caseId, String attachmentId, String transactionId, String treatmentCode) {

        ApplicationStatusQueryRequestDTOFactory requestDTOFactory = new ApplicationStatusQueryRequestDTOFactory();
        Object body = requestDTOFactory.createApplicationStatusQueryRequestDTOFactory
                (caseId, attachmentId, transactionId, treatmentCode);
        this.requestSpecification.addBodyToRequest(body);
        Response response = this.requestOperationsHelper.sendPostRequest(requestSpecification.getFilterableRequestSpecification());
        response.then().statusCode(HttpStatus.SC_OK);
        return Arrays.asList(response.as(DnaApplicationEventStatusResponseDTO[].class));

    }


}
