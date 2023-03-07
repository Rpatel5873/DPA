package com.aim.dnaautomation.dtos.dnapolicyconfiguration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class DnaPolicyConfigurationRequestDTO {
    private String clientId;
    private String solutionId;
    private List<String> treatmentCodes;
}
