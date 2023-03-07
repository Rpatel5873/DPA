package com.aim.dnaautomation.factories.applicationstatusquery;

import com.aim.dnaautomation.dtos.applicationstatusquery.ApplicationStatusQueryRequestDTO;

public class ApplicationStatusQueryRequestDTOFactory {


    public ApplicationStatusQueryRequestDTO createApplicationStatusQueryRequestDTOFactory(String caseId, String attachmentId, String transactionId,
                                                                                          String treatmentCode) {

        ApplicationStatusQueryRequestDTO requestDTO = new ApplicationStatusQueryRequestDTO();
        requestDTO.setCaseId(caseId);
        requestDTO.setAttachmentId(attachmentId);
        requestDTO.setTransactionId(transactionId);
        requestDTO.setTreatmentCode(treatmentCode);
        return requestDTO;
    }
}
