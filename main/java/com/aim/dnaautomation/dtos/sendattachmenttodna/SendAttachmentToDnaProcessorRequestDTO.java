package com.aim.dnaautomation.dtos.sendattachmenttodna;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * Created by BharathRam on 02/11/2022
 */
public class SendAttachmentToDnaProcessorRequestDTO {

    private String attachmentId;
    private String caseId;
}
