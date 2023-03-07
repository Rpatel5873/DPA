package com.aim.dnaautomation.dtos.manageattachments;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttachmentIdsDTO {

    private List<String> attachmentIds;
}
