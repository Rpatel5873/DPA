package com.aim.dnaautomation.dtos.turnaroundtime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TATResponseDTO {
    private String turnAroundDeterminationDateTime;
    private String turnAroundNotificationDateTime;
    private String code;
    private String message;

}
