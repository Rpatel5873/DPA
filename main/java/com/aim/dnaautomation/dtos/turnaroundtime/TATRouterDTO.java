package com.aim.dnaautomation.dtos.turnaroundtime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TATRouterDTO {
    private String scenario;
    private boolean turnAroundTimeTurnedOn;
    private String configurationId;
}
