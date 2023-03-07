package com.aim.dnaautomation.steps.capabilitiesconfigwrapper;

import com.aim.automation.helpers.CustomFilterableRequestSpecification;
import com.aim.automation.helpers.RequestOperationsHelper;
import com.aim.automation.helpers.convert.GenericConvertHelper;
import com.aim.automation.helpers.enums.platformcontext.PlatformContextVersionEnum;
import com.aim.dnaautomation.dtos.configwrapperdto.InitiatePortalAppealsOptionsDTO;
import com.aim.dnaautomation.factories.capabilitiesconfigwrapper.InitiatePortalAppealsOptionsDTOFactory;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

public class InitiateAppealsOptionsSteps {
    private RequestOperationsHelper requestOperationsHelper;
    private GenericConvertHelper converter = new GenericConvertHelper();
    private CustomFilterableRequestSpecification requestSpecification;
    private PlatformContextVersionEnum platformContextVersion = PlatformContextVersionEnum.PC_V1;

    private String basePathInitiatePortalAppealsOptions = "/config-wrapper/v1/getInitiatePortalAppealOptions";

    public InitiateAppealsOptionsSteps(String platformContextHeaders, Headers headers){

        requestOperationsHelper = new RequestOperationsHelper();
        requestSpecification = new CustomFilterableRequestSpecification();

        requestSpecification.addBasePath(basePathInitiatePortalAppealsOptions);
        requestSpecification.addPlatformContextToRequest(String.valueOf(platformContextHeaders));
        requestSpecification.setContentType(ContentType.JSON);
        requestSpecification.addHeaders(headers);
    }

        public String initiatePortalAppealOptionsResponse(String userRole, String appealType, String appealRequestedBy){
        InitiatePortalAppealsOptionsDTOFactory requestDTOFactory = new InitiatePortalAppealsOptionsDTOFactory();
        InitiatePortalAppealsOptionsDTO  body= requestDTOFactory.createInitiateAppealOptionsDTOFactory(userRole, appealType, appealRequestedBy);
        requestSpecification.addBodyToRequest(body);
        Response response = this.requestOperationsHelper.sendPostRequest(requestSpecification.getFilterableRequestSpecification());
        response.then().statusCode(HttpStatus.SC_OK);
        return response.asString();
    }

}
