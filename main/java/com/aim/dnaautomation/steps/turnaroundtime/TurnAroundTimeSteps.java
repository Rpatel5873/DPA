package com.aim.dnaautomation.steps.turnaroundtime;

import com.aim.automation.helpers.CustomFilterableRequestSpecification;
import com.aim.automation.helpers.RequestOperationsHelper;
import com.aim.dnaautomation.dtos.turnaroundtime.ClientConfigTestCaseDTO;
import com.aim.dnaautomation.dtos.turnaroundtime.TATResponseDTO;
import com.aim.dnaautomation.dtos.turnaroundtime.TurnAroundTimeParticipation;
import com.aim.dnaautomation.helpers.constants.BasePathConstants;
import com.aim.dnaautomation.helpers.rabbitmqconstants.Constants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TurnAroundTimeSteps {
    private RequestOperationsHelper requestOperationsHelper;

    public TurnAroundTimeSteps(CustomFilterableRequestSpecification requestSpecification) {

        this.requestOperationsHelper = new RequestOperationsHelper();
        requestSpecification.addBasePath(BasePathConstants.TURNARONDTIME);
        Headers headers = requestSpecification.getFilterableRequestSpecification().getHeaders();
        requestSpecification.setContentType(ContentType.JSON);
        requestSpecification.addHeaders(headers);

    }

    public TATResponseDTO CalculateTurnAroundTimeSteps(CustomFilterableRequestSpecification requestSpecification, ClientConfigTestCaseDTO node) {
        this.requestOperationsHelper = new RequestOperationsHelper();
        requestSpecification.addBasePath(BasePathConstants.TURNARONDTIME);
        Headers headers = requestSpecification.getFilterableRequestSpecification().getHeaders();
        requestSpecification.addQueryParams(Collections.singletonMap("configurationId", node.getConfigurationId()));
        requestSpecification.addBodyToRequest(node.getRequestDto());
        requestSpecification.setContentType(ContentType.JSON);
        requestSpecification.addHeaders(headers);
        Response response = TurnAroundTimeStepsResponse(requestSpecification);
        response.then().statusCode(HttpStatus.SC_OK);
        return response.as(TATResponseDTO.class);

    }

    public TATResponseDTO CalculateTurnAroundTimeStepsWithSystemDate(CustomFilterableRequestSpecification requestSpecification, ClientConfigTestCaseDTO node) throws JsonProcessingException {
        this.requestOperationsHelper = new RequestOperationsHelper();
        requestSpecification.addBasePath(BasePathConstants.TURNARONDTIME);
        Headers headers = requestSpecification.getFilterableRequestSpecification().getHeaders();
        requestSpecification.addQueryParams(Collections.singletonMap("configurationId", node.getConfigurationId()));
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(objectMapper.writeValueAsString(node.getRequestDto().getRequestDto()));
        List<String> ls = new ArrayList<>();
        jsonNode.fields().forEachRemaining(x -> ls.add(x.getKey()));
        ((ObjectNode) jsonNode).put(ls.get(ls.size() - 1), Constants.LOCAL_DATE_TIME.toString().concat("Z"));
        node.getRequestDto().setRequestDto(jsonNode);
        requestSpecification.addBodyToRequest(node.getRequestDto());
        requestSpecification.setContentType(ContentType.JSON);
        requestSpecification.addHeaders(headers);
        Response response = TurnAroundTimeStepsResponse(requestSpecification);
        response.then().statusCode(HttpStatus.SC_OK);
        return response.as(TATResponseDTO.class);

    }

    public TurnAroundTimeParticipation TurnAroundTimeRouterConfiguration(CustomFilterableRequestSpecification requestSpecification) {
        this.requestOperationsHelper = new RequestOperationsHelper();
        requestSpecification.addBasePath(BasePathConstants.TURNAROUNDTIMEROUTERCONFIGURATION);
        Headers headers = requestSpecification.getFilterableRequestSpecification().getHeaders();
        requestSpecification.setContentType(ContentType.JSON);
        requestSpecification.addHeaders(headers);
        Response response = TurnAroundTimeStepsResponse(requestSpecification);
        response.then().statusCode(HttpStatus.SC_OK);
        return response.as(TurnAroundTimeParticipation.class);

    }

    public TATResponseDTO CalculateTurnAroundTimeStepsForPRODTATCalculation(CustomFilterableRequestSpecification requestSpecification, ClientConfigTestCaseDTO node, TurnAroundTimeParticipation routerresponse, String scenario) {
        this.requestOperationsHelper = new RequestOperationsHelper();
        requestSpecification.addBasePath(BasePathConstants.TURNARONDTIME);
        routerresponse.getTurnAroundTimeParticipations().forEach(responseDTO -> {
            if (responseDTO.getScenario().equalsIgnoreCase(scenario)) {
                requestSpecification.addQueryParams(Collections.singletonMap("configurationId", responseDTO.getConfigurationId()));
            }
        });
        Headers headers = requestSpecification.getFilterableRequestSpecification().getHeaders();
        requestSpecification.addBodyToRequest(node.getRequestDto());
        requestSpecification.setContentType(ContentType.JSON);
        requestSpecification.addHeaders(headers);
        Response response = TurnAroundTimeStepsResponse(requestSpecification);
        response.then().statusCode(HttpStatus.SC_OK);
        return response.as(TATResponseDTO.class);
    }

    public TATResponseDTO TurnAroundTimeExceptionHandlingSteps(CustomFilterableRequestSpecification requestSpecification, ClientConfigTestCaseDTO node) {
        this.requestOperationsHelper = new RequestOperationsHelper();
        requestSpecification.addBasePath(BasePathConstants.TURNARONDTIME);
        Headers headers = requestSpecification.getFilterableRequestSpecification().getHeaders();
        requestSpecification.addQueryParams(Collections.singletonMap("configurationId", node.getConfigurationId()));
        requestSpecification.addBodyToRequest(node.getRequestDto());
        requestSpecification.setContentType(ContentType.JSON);
        requestSpecification.addHeaders(headers);
        Response response = TurnAroundTimeStepsResponse(requestSpecification);
        response.then().statusCode(HttpStatus.SC_BAD_REQUEST);
        return response.as(TATResponseDTO.class);

    }

    public Response TurnAroundTimeStepsResponse(CustomFilterableRequestSpecification requestSpecification) {

        return this.requestOperationsHelper.sendPostRequest(requestSpecification.getFilterableRequestSpecification());

    }

}
