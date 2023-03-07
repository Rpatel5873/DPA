package com.aim.dnaautomation.steps.dnapolicyconfiguration;

import com.aim.automation.helpers.CustomFilterableRequestSpecification;
import com.aim.automation.helpers.RequestOperationsHelper;
import com.aim.dnaautomation.dtos.dnapolicyconfiguration.DnaPolicyConfigurationResponseDTO;
import com.aim.dnaautomation.factories.dnapolicyconfiguration.DnaPolicyConfigurationDTOFactory;
import com.aim.dnaautomation.helpers.constants.BasePathConstants;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

public class DnaPolicyConfigurationSteps {
    private final CustomFilterableRequestSpecification requestSpecification;
    private final RequestOperationsHelper requestOperationsHelper;

    /**
     * Constructor is accepting pre-populated {@link CustomFilterableRequestSpecification} object
     *
     * @param requestSpecification
     */

    public DnaPolicyConfigurationSteps(CustomFilterableRequestSpecification requestSpecification) {

        this.requestSpecification = new CustomFilterableRequestSpecification(requestSpecification);
        this.requestOperationsHelper = new RequestOperationsHelper();
        Headers headers = this.requestSpecification.getFilterableRequestSpecification().getHeaders();
        this.requestSpecification.setContentType(ContentType.JSON);
        this.requestSpecification.addHeaders(headers);
        this.requestSpecification.addBasePath(BasePathConstants.DNA_POLICY_CONFIGURATION);
    }
    public List<DnaPolicyConfigurationResponseDTO> constructDnaPolicyConfigurationRequest(String clientId, String solutionId, List<String> treatmentCodes) {

        DnaPolicyConfigurationDTOFactory requestDTOFactory = new DnaPolicyConfigurationDTOFactory();
        Object body = requestDTOFactory.CreateDnaPolicyConfigurationDTOFactory
                (clientId, solutionId, treatmentCodes);
        this.requestSpecification.addBodyToRequest(body);
        Response response = this.requestOperationsHelper.sendPostRequest(requestSpecification.getFilterableRequestSpecification());
        response.then().statusCode(HttpStatus.SC_OK);
        return Arrays.asList(response.as(DnaPolicyConfigurationResponseDTO[].class));

    }
}
