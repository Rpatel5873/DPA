package com.aim.dnaautomation.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventVersionDTO {
    private String major;
    private String minor;
    private String patch;
}
