package com.aim.dnaautomation.dtos.dnapolicyconfiguration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DnaPolicyConfigurationResponseDTO {
    private String policyId;
    private List<String> ruleId;
    private Boolean isAnthemCase;
    private List<String> treatmentCodes;
    private String dpaclinicaldocuments;

}
