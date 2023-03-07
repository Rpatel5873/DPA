package com.aim.dnaautomation.dtos.configwrapperdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InitiatePortalAppealsEnabledResponseDTO {

    private boolean initiatePortalAppealsEnabled;

    public boolean isInitiatePortalAppealsEnabled() {
        return initiatePortalAppealsEnabled;
    }

    public void setInitiatePortalAppealsEnabled(boolean initiatePortalAppealsEnabled) {
        this.initiatePortalAppealsEnabled = initiatePortalAppealsEnabled;
    }
}
