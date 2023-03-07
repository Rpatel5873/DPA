package com.aim.dnaautomation.dtos.sendattachmenttodna;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendAttachmentsToDnaProcessorResponseDTO {
    private String transactionId;
    private String attachmentId;
}
