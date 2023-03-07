package com.aim.dnaautomation.dtos.turnaroundtime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TATRouterConfigurationResponseDTO {
    private List<TATRouterDTO> configurationValue;
    private  String index;
}
