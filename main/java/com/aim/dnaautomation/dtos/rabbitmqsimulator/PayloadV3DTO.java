package com.aim.dnaautomation.dtos.rabbitmqsimulator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PayloadV3DTO {
    private HashMap<String, String> additionalHeaders;
    private Object payload;

}
