package com.aim.dnaautomation.dtos.sendattachmenttodna;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
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
public class CaseSaveEventRequestDTO {

    private String caseId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
    private LocalDateTime caseCreatedDateTime;
    private String caseType;
    private String clientId;
    private String lineOfBusiness;
    private String memberGlobalIdentifier;
    private String healthCardIdentifier;
    private String memberFirstName;
    private String memberLastName;
    private String memberMiddleInitial;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    private LocalDate memberDob;
    private String memberGender;
    private String requestingProviderNPI;
    private String caseSpecialty;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    private LocalDate dateOfService;
    private List<MedicalAttachmentDTO> medicalAttachment;
    private List<TreatmentCodeDTO> treatmentCodes;

    @JsonGetter("caseCreatedDateTime")
    public String getCaseCreatedDateTimeProperty() {
        if (caseCreatedDateTime != null) {
            return caseCreatedDateTime.toString();
        }
        return null;
    }

    @JsonSetter("caseCreatedDateTime")
    public void setCaseCreatedDateTimeProperty(String val) {
        if (val != null) {
            this.caseCreatedDateTime = LocalDateTime.parse(val);
        } else {
            this.caseCreatedDateTime = null;
        }
    }

    @JsonGetter("memberDob")
    public String getMemberDobProperty() {
        if (memberDob != null) {
            return memberDob.toString();
        }
        return null;
    }

    @JsonSetter("memberDob")
    public void setMemberDobProperty(String val) {
        if (val != null) {
            this.memberDob = LocalDate.parse(val);
        } else {
            this.memberDob = null;
        }
    }

    @JsonGetter("dateOfService")
    public String getDateOfServiceProperty() {
        if (dateOfService != null) {
            return dateOfService.toString();
        }
        return null;
    }

    @JsonSetter("dateOfService")
    public void setDateOfServiceProperty(String val) {
        if (val != null) {
            this.dateOfService = LocalDate.parse(val);
        } else {
            this.dateOfService = null;
        }
    }

}
