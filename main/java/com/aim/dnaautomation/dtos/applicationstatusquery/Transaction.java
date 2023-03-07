package com.aim.dnaautomation.dtos.applicationstatusquery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private String attachmentId;
    private String transactionId;
}
