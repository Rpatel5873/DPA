package com.aim.dnaautomation.dtos.turnaroundtime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TATRequestDTO {
    private boolean isUrgent;
    private Object requestDto;
}
