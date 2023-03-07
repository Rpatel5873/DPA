package com.aim.dnaautomation.factories.manageattachments;

import com.aim.dnaautomation.dtos.manageattachments.AttachmentIdsDTO;

import java.util.List;

public class AttachmentIdsDTOFactory {

    public AttachmentIdsDTO createAttachmentIdsDTOFactory(List<String> attachmentIds) {

        AttachmentIdsDTO dto = new AttachmentIdsDTO();
        dto.setAttachmentIds(attachmentIds);

        return dto;

    }
}
