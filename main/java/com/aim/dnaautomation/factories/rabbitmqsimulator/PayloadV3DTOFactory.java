package com.aim.dnaautomation.factories.rabbitmqsimulator;

import com.aim.dnaautomation.dtos.rabbitmqsimulator.PayloadV3DTO;

import java.util.HashMap;

public class PayloadV3DTOFactory {

    public PayloadV3DTO createPayloadV3DTO(HashMap<String, String> additionalHeaders, Object payload) {

        PayloadV3DTO body = new PayloadV3DTO();
        body.setAdditionalHeaders(additionalHeaders);
        body.setPayload(payload);

        return body;
    }

}
