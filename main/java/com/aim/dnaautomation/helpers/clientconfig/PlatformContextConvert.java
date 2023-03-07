package com.aim.dnaautomation.helpers.clientconfig;

import com.aim.automation.helpers.CustomFilterableRequestSpecification;
import com.aim.dnaautomation.dtos.turnaroundtime.ClientConfigTestCaseDTO;
import com.aim.servicemodel.domain.PlatformContext;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class PlatformContextConvert {
    //TODO delete this method when new version of the shared lib is build with the generic string to dto conversion
    private static final Logger LOGGER = LoggerFactory.getLogger(PlatformContextConvert.class);
    private Object flattenedNode;

    public PlatformContext getPlatformContextDTO(CustomFilterableRequestSpecification customFilterableRequestSpecification) {

        ObjectMapper objectMapper = new ObjectMapper();
        PlatformContext platformContext = new PlatformContext();
        try {
            platformContext = objectMapper.readValue(customFilterableRequestSpecification.getFilterableRequestSpecification().getHeaders().get("platform-context").getValue(), PlatformContext.class);
        } catch (IOException e) {
            LOGGER.error("An error has occurred while parsing platform context string to dto\n", e);
        }
        return platformContext;
    }

    public PlatformContext updatePlatformContextDTO(CustomFilterableRequestSpecification customFilterableRequestSpecification, ClientConfigTestCaseDTO testCaseDTO) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        PlatformContext platformContext = getPlatformContextDTO(customFilterableRequestSpecification);
        JsonNode jsonNode = objectMapper.convertValue(testCaseDTO.getRequestDto().getRequestDto(), JsonNode.class);
        if (jsonNode.has("member")) {
            if (jsonNode.get("member").has("clientId")) {
                platformContext.getMember().setClientId(jsonNode.get("member").get("clientId").asInt());
            }
            if (jsonNode.get("member").has("enrollment")) {
                if (jsonNode.get("member").get("enrollment").has("lineOfBusiness")) {
                    String LOB=jsonNode.get("member").get("enrollment").get("lineOfBusiness").asText();
                    if(LOB.equals("FEP")){
                        platformContext.getMember().getEnrollment().setLineOfBusinessCode(LOB);
                    }
                    else {
                        String lineOfBusiness = LOB.charAt(0) + LOB.substring(1).toLowerCase();
                        platformContext.getMember().getEnrollment().setLineOfBusinessCode(lineOfBusiness);
                    }
                }
            }
        }
        if (jsonNode.has("solutionId")) {
            platformContext.getSolution().setId(jsonNode.get("solutionId").asInt());
        }
        return platformContext;

    }

    public String getPlatformContextAsString(PlatformContext platformContext) {
        ObjectMapper objectMapper = new ObjectMapper();
        String platformContextAsString = "No platform context";
        try {
            platformContextAsString = objectMapper.writeValueAsString(platformContext);
        } catch (JsonProcessingException e) {
            LOGGER.error("An error has occurred while parsing platform context dto to string\n", e);
        }
        return platformContextAsString;
    }
}
