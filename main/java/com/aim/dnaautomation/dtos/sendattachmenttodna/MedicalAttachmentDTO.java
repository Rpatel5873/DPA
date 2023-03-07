package com.aim.dnaautomation.dtos.sendattachmenttodna;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalAttachmentDTO {
    private String attachmentId;
    private String attachmentTypeName;
    private String attachmentStatusCode;
    private String attachmentStatusDescription;
    private String attachmentReviewedByUserRoleName;
}
