package com.aim.dnaautomation.factories.sendattachmenttodna;

import com.aim.dnaautomation.dtos.sendattachmenttodna.SendAttachmentToDnaProcessorRequestDTO;

/**
 * Created by BharathRam on 02/11/2022
 */

public class SendAttachmentToDnaProcessorRequestDTOFactory {

    /**
     * @param attachmentId <i>attachmentId</i> to be send it to DNA Processor
     * @param caseId       <i> caseId</i> of the Case to be submitted
     * @return transactionId as a response
     */
    public SendAttachmentToDnaProcessorRequestDTO createSendAttachmentToDnaProcessorRequestDTOFactory
    (String attachmentId, String caseId) {
        SendAttachmentToDnaProcessorRequestDTO requestDTO = new SendAttachmentToDnaProcessorRequestDTO();
        requestDTO.setAttachmentId(attachmentId);
        requestDTO.setCaseId(caseId);

        return requestDTO;
    }

}
