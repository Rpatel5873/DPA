package com.aim.dnaautomation.dtos.configwrapperdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InitiatePortalAppealsOptionsDTO {

    private String userRole;
    private String appealType;
    private String appealRequestedBy;

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public void setAppealType(String appealType) {
        this.appealType = appealType;
    }

    public void setAppealRequestedBy(String appealRequestedBy) {
        this.appealRequestedBy = appealRequestedBy;
    }
}
