package com.aim.dnaautomation.dtos.configwrapperdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InitiatePortalAppealsEnabledDTO {

    private String outcome;
    private String caseStatus;
    private String userRole;
    private List<InitiatePortalAppealsEnabledServicesDTO> services;

}
