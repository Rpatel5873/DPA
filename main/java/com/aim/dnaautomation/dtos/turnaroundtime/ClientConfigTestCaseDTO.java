package com.aim.dnaautomation.dtos.turnaroundtime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientConfigTestCaseDTO {
    private String configurationId;
    private String description;
    private TATResponseDTO expectedFields;
    private TATRequestDTO requestDto;
}
