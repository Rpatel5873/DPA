package com.aim.dnaautomation.factories.rabbitmqsimulator;

import com.aim.dnaautomation.dtos.sendattachmenttodna.CaseSaveEventRequestDTO;
import com.aim.dnaautomation.dtos.sendattachmenttodna.MedicalAttachmentDTO;
import com.aim.dnaautomation.dtos.sendattachmenttodna.TreatmentCodeDTO;
import com.aim.dnaautomation.enums.dna.ClientIdEnum;
import com.aim.dnaautomation.helpers.rabbitmqconstants.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CaseSaveEventRequestDTOFactory {

    public CaseSaveEventRequestDTO createCaseSaveEventRequestDTOFactory(String caseId, List<String> attachmentIds) {

        CaseSaveEventRequestDTO requestDTO = new CaseSaveEventRequestDTO();
        requestDTO.setCaseId(caseId);
        requestDTO.setClientId(ClientIdEnum.CLIENT_ID_186.getIdAsString());
        requestDTO.setCaseCreatedDateTime(Constants.LOCAL_DATE_TIME);
        requestDTO.setLineOfBusiness(Constants.LINE_OF_BUSINESS);
        requestDTO.setCaseType(Constants.CASE_REVIEW_TYPE);
        requestDTO.setMemberGlobalIdentifier(Constants.MEMBER_GLOBAL_IDENTIFIER);
        requestDTO.setHealthCardIdentifier(Constants.HEALTH_CARD_IDENTIFIER);
        requestDTO.setMemberFirstName(Constants.MEMBER_FIRST_NAME);
        requestDTO.setMemberLastName(Constants.MEMBER_LAST_NAME);
        requestDTO.setMemberMiddleInitial(Constants.MEMBER_MIDDLE_INITIAL);
        requestDTO.setMemberDob(Constants.LOCAL_DATE);
        requestDTO.setMemberGender(Constants.MEMBER_GENDER);
        requestDTO.setRequestingProviderNPI(Constants.REQUESTING_PROVIDER_NPI);
        requestDTO.setCaseSpecialty(Constants.CASE_SPECIALTY);
        requestDTO.setDateOfService(Constants.LOCAL_DATE);
        List<MedicalAttachmentDTO> medicalAttachmentDTOS = new ArrayList<>();

        // Iterate Over Each AttachmentId and Add Medical Attachment Record
        for (int i = 0; i < attachmentIds.size(); i++) {
            MedicalAttachmentDTO dto = new MedicalAttachmentDTO();
            dto.setAttachmentId(attachmentIds.get(i));
            dto.setAttachmentReviewedByUserRoleName(Constants.ATTACHMENT_REVIEWED_BY_USER_ROLE_NAME);
            dto.setAttachmentStatusCode(Constants.ATTACHMENT_STATUS_CODE);
            dto.setAttachmentStatusDescription(Constants.ATTACHMENT_STATUS_DESCRIPTION);
            dto.setAttachmentTypeName(Constants.ATTACHMENT_TYPE_NAME);

            medicalAttachmentDTOS.add(dto);
        }
        // Add List Of Medical Attachments To RequestDTO
        requestDTO.setMedicalAttachment(medicalAttachmentDTOS);
        // Add Treatment Codes on Case
        TreatmentCodeDTO codeDTO = new TreatmentCodeDTO();
        codeDTO.setCode(Constants.MAIN_CODE);
        codeDTO.setType(Constants.CODE_NAME);
        requestDTO.setTreatmentCodes(Arrays.asList(codeDTO));

        return requestDTO;

    }
}
