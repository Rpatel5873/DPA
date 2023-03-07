package com.aim.dnaautomation.steps.getdocumentstatus;

import com.aim.automation.helpers.CustomFilterableRequestSpecification;
import com.aim.automation.helpers.RequestOperationsHelper;
import com.aim.dnaautomation.dtos.getdocumentstatus.DnaStatusDTO;
import com.aim.dnaautomation.helpers.constants.BasePathConstants;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import java.util.Collections;

/**
 * Created by BharathRam on 02/24/2022
 */

public class GetDocumentStatusSteps {

    private final CustomFilterableRequestSpecification requestSpecification;
    private final RequestOperationsHelper requestOperationsHelper;

    /**
     * Constructor is accepting pre-populated {@link CustomFilterableRequestSpecification} object
     *
     * @param requestSpecification
     */

    public GetDocumentStatusSteps(CustomFilterableRequestSpecification requestSpecification) {

        this.requestSpecification = new CustomFilterableRequestSpecification(requestSpecification);
        this.requestOperationsHelper = new RequestOperationsHelper();
        Headers headers = this.requestSpecification.getFilterableRequestSpecification().getHeaders();
        this.requestSpecification.setContentType(ContentType.JSON);
        this.requestSpecification.addHeaders(headers);
        this.requestSpecification.addBasePath(BasePathConstants.GET_DOCUMENT_STATUS);

    }

//    /**
//     * Constructor which accepts PlatformContext and Headers as arguments
//     *
//     * @param platformContext platformContext to be added to Request
//     * @param headers         Headers to be added to the request
//     */
//
////    public void GetDocumentStatusSteps(String platformContext, Headers headers) {
////
////        this.requestSpecification = new CustomFilterableRequestSpecification(requestSpecification);
////        this.requestOperationsHelper = new RequestOperationsHelper();
////        this.requestSpecification.addHeaders(headers);
////        this.requestSpecification.addBasePath(BasePathConstants.GET_DOCUMENT_STATUS);
////        this.requestSpecification.addPlatformContextToRequest(platformContext);
////
////    }

    public DnaStatusDTO createGetDocumentStatusFromDNAProcessorSteps(String transactionId) {

        requestSpecification.addQueryParams(Collections.singletonMap("transactionId", transactionId));
        Response response = createGetDocumentStatusFromDNAProcessorSteps(requestSpecification);
        response.then().statusCode(HttpStatus.SC_OK);
        return response.as(DnaStatusDTO.class);


    }

    public void houseAccountMemberCase(String transactionId) {

        requestSpecification.addQueryParams(Collections.singletonMap("transactionId", transactionId));
        Response response = createGetDocumentStatusFromDNAProcessorSteps(requestSpecification);
        response.then().statusCode(HttpStatus.SC_BAD_REQUEST);


    }

    public Response createGetDocumentStatusFromDNAProcessorSteps(CustomFilterableRequestSpecification requestSpecification) {

        return this.requestOperationsHelper.sendGetRequest(requestSpecification.getFilterableRequestSpecification());

    }


}
