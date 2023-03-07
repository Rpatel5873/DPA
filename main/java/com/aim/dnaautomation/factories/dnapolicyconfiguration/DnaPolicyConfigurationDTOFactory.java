package com.aim.dnaautomation.factories.dnapolicyconfiguration;

import com.aim.dnaautomation.dtos.dnapolicyconfiguration.DnaPolicyConfigurationRequestDTO;

import java.util.List;

public class DnaPolicyConfigurationDTOFactory {
    public DnaPolicyConfigurationRequestDTO CreateDnaPolicyConfigurationDTOFactory(String clientId, String solutionId, List<String> treatmentCodes) {
        DnaPolicyConfigurationRequestDTO requestDTO = new DnaPolicyConfigurationRequestDTO();
        requestDTO.setClientId(clientId);
        requestDTO.setSolutionId(solutionId);
        requestDTO.setTreatmentCodes(treatmentCodes);
        return requestDTO;
    }
}
