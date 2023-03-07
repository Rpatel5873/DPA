package com.aim.dnaautomation.steps.capabilitiesconfigwrapper;

import com.aim.automation.helpers.CustomFilterableRequestSpecification;
import com.aim.automation.helpers.RequestOperationsHelper;
import com.aim.automation.helpers.convert.GenericConvertHelper;
import com.aim.dnaautomation.dtos.configwrapperdto.InitiatePortalAppealsEnabledDTO;
import com.aim.dnaautomation.factories.capabilitiesconfigwrapper.InitiatePortalAppealsEnabledDTOFactory;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;


public class CapabilitiesConfigWrapperSteps {

    private RequestOperationsHelper requestOperationsHelper ;
    private GenericConvertHelper converter = new GenericConvertHelper();
    private CustomFilterableRequestSpecification requestSpecification;
    private boolean isPortalInitiationApprealsEnabaled;
    private String basePathInitiatePortalAppealsEnabled = "/config-wrapper/v1/initiatePortalAppealsEnabled";

    public CapabilitiesConfigWrapperSteps (String platformContextHeaders,Headers headers){

        requestOperationsHelper = new RequestOperationsHelper();
        requestSpecification = new CustomFilterableRequestSpecification();
        requestSpecification.addBasePath(basePathInitiatePortalAppealsEnabled);
        requestSpecification.addPlatformContextToRequest(platformContextHeaders);
        requestSpecification.setContentType(ContentType.JSON);
        requestSpecification.addHeaders(headers);
    }
    public boolean initiatePortalAppealEnabledResponse(String userRoleCode,String outcome, String caseStatus, String id, String outcomeCode, String reasonCode, Integer sequenceNumber) {

        InitiatePortalAppealsEnabledDTOFactory  requestDTOFactory = new InitiatePortalAppealsEnabledDTOFactory();
        InitiatePortalAppealsEnabledDTO body = requestDTOFactory.createInitiateAppealDTOFactory(outcome,caseStatus,userRoleCode,id,outcomeCode,reasonCode,sequenceNumber);
        requestSpecification.addBodyToRequest(body);

        Response response = this.requestOperationsHelper.sendPostRequest(requestSpecification.getFilterableRequestSpecification());
        response.then().statusCode(HttpStatus.SC_OK);
        return isPortalInitiationApprealsEnabaled;
    }

    public boolean initiateMultiplePortalAppealEnabledResponse(String userRoleCode, String outcome, String caseStatus, String id, String outcomeCode, String reasonCode, Integer sequenceNumber) {


        InitiatePortalAppealsEnabledDTOFactory  requestDTOFactory = new InitiatePortalAppealsEnabledDTOFactory();
        InitiatePortalAppealsEnabledDTO body = requestDTOFactory.createMultipleInitiateAppealDTOFactory(outcome,caseStatus,userRoleCode,id,outcomeCode,reasonCode,sequenceNumber);
        requestSpecification.addBodyToRequest(body);

        Response response = this.requestOperationsHelper.sendPostRequest(requestSpecification.getFilterableRequestSpecification());
        response.then().statusCode(HttpStatus.SC_OK);
        return isPortalInitiationApprealsEnabaled;
    }
}
