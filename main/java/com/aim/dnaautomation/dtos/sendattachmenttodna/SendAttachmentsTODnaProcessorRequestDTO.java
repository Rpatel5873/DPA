package com.aim.dnaautomation.dtos.sendattachmenttodna;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class SendAttachmentsTODnaProcessorRequestDTO {
    private List<String> attachments;
    private String caseId;
}
