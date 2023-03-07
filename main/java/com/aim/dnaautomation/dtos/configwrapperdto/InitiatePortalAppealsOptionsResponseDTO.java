package com.aim.dnaautomation.dtos.configwrapperdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static com.aim.dnaautomation.helpers.configwrapperconstant.ConfigWrapperConstants.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InitiatePortalAppealsOptionsResponseDTO {

    private List<String> appealDisplayOptionsCode;
    private List<String> appealDisplayOptionsText;
    private List<String> appealCalculatedOptionsCode;

    public String getInitiatePortalAppealsOptionsResponseDTO_AppealsOptionResponse1() {
        String appealsOptionResponse1 = PORTAL_APPEALS_OPTION_RESPONSE1;
        return appealsOptionResponse1;
    }

    public String getInitiatePortalAppealsOptionsResponseDTO_AppealsOptionResponse2() {
        String appealsOptionResponse2 = PORTAL_APPEALS_OPTION_RESPONSE2;
        return appealsOptionResponse2;
    }

    public String getInitiatePortalAppealsOptionsResponseDTO_AppealsOptionResponse3() {
        String appealsOptionResponse3 = PORTAL_APPEALS_OPTION_RESPONSE3;
        return appealsOptionResponse3;
    }
}