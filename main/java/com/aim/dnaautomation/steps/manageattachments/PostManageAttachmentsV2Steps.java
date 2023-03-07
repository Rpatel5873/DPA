package com.aim.dnaautomation.steps.manageattachments;

import com.aim.automation.helpers.CustomFilterableRequestSpecification;
import com.aim.automation.helpers.EnvironmentHelper;
import com.aim.automation.helpers.RequestOperationsHelper;
import com.aim.automation.helpers.enums.DomainEnum;
import com.aim.dnaautomation.helpers.constants.BasePathConstants;
import com.aim.dnaautomation.helpers.rabbitmqconstants.Constants;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import java.io.InputStream;
import java.util.HashMap;

/**
 * Created By BharathRam on 01/03/2022
 */

public class PostManageAttachmentsV2Steps {


    private CustomFilterableRequestSpecification requestSpecification;
    private RequestOperationsHelper requestOperationsHelper;

    public PostManageAttachmentsV2Steps(CustomFilterableRequestSpecification requestSpecification) {

        this.requestSpecification = new CustomFilterableRequestSpecification(requestSpecification);
        this.requestOperationsHelper = new RequestOperationsHelper();
        Headers headers = this.requestSpecification.getFilterableRequestSpecification().getHeaders();
        this.requestSpecification.addHeaders(headers);
        this.requestSpecification.addCustomHeader("Content-Type", "multipart/form-data");
        this.requestSpecification.addBaseURI(new EnvironmentHelper().constructBaseURIForDomain(DomainEnum.COMMUNICATIONS));
        this.requestSpecification.addBasePath(BasePathConstants.MANAGE_ATTACHMENT_IDS);

    }


    public String PostAttachment(InputStream uploadFile,
                                 String uploadFileName, String fileType) {

        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("displayName", Constants.DISPLAY_NAME_PARAMETER);
        queryParams.put("category", "Email");
        this.requestSpecification.addQueryParams(queryParams);
        this.requestSpecification.setMultiPart("file", uploadFileName, uploadFile, fileType);
        Response response = this.requestOperationsHelper.sendPostRequest(requestSpecification.getFilterableRequestSpecification());
        response.then().statusCode(HttpStatus.SC_ACCEPTED);

        return response.asString();


    }
}
