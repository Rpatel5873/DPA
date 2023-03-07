package com.aim.dnaautomation.factories.capabilitiesconfigwrapper;

import com.aim.dnaautomation.dtos.configwrapperdto.InitiatePortalAppealsOptionsDTO;

public class InitiatePortalAppealsOptionsDTOFactory {

    public InitiatePortalAppealsOptionsDTOFactory() {
    }


    public InitiatePortalAppealsOptionsDTO createInitiateAppealOptionsDTOFactory(String userRole,String appealType, String appealRequestedBy) {

        InitiatePortalAppealsOptionsDTO requestDTO = new InitiatePortalAppealsOptionsDTO();
        requestDTO.setUserRole(userRole);
        requestDTO.setAppealType(appealType);
        requestDTO.setAppealRequestedBy(appealRequestedBy);
        return requestDTO;
    }
}
