package com.aim.dnaautomation.factories.sendattachmenttodna;

import com.aim.dnaautomation.dtos.sendattachmenttodna.SendAttachmentsTODnaProcessorRequestDTO;

import java.util.List;

public class SendAttachmentsToDnaProcessorRequestDTOFactory {

    public SendAttachmentsTODnaProcessorRequestDTO createSendAttachmentsToDnaProcessorRequestDTOFactory
            (List<String> attachments, String caseId) {
        SendAttachmentsTODnaProcessorRequestDTO requestDTO = new SendAttachmentsTODnaProcessorRequestDTO();
        requestDTO.setAttachments(attachments);
        requestDTO.setCaseId(caseId);

        return requestDTO;
    }
}
