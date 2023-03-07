package com.aim.dnaautomation.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * Created by BharathRam on 03/03/2022
 */
public class DNAProcessAttachmentEventReqDTO {

    private EventVersionDTO eventVersion;
    private String transactionId;
    private String caseId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDateTime caseCreationDate;
    private String lineOfBusiness;
    private String caseType;
    private String memberGlobalIdentifier;
    private String healthcardIdentifier;
    private String memberFirstName;
    private String memberLastName;
    private String memberMiddleInitial;
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate memberDob;
    private String memberGender;
    private String requestingProviderNpi;
    private String caseSpecialty;
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dateOfService;
    private String attachmentId;
    private String policyId;
    private List<Integer> ruleId;
}
