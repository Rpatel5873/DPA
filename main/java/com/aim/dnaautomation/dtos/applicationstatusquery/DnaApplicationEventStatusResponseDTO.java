package com.aim.dnaautomation.dtos.applicationstatusquery;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class DnaApplicationEventStatusResponseDTO {

    private String caseId;
    private List<TreatmentCode> treatmentCodes;
    private List<Transaction> transactions;
    private Integer solutionId;
    private String lineOfBusiness;
    private String caseType;
    private String memberGlobalIdentifier;
    private String healthcardIdentifier;
    private String memberFirstName;
    private String memberLastName;
    private String memberMiddleInitial;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    private LocalDate memberDob;
    private String memberGender;
    private String requestingProviderNumber;
    private String requestingProviderNPI;
    private String requestingProviderFirstName;
    private String requestingProviderLastName;
    private String state;
    private String requestType;
    private String caseSpecialty;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    private LocalDate dateOfService;
    private Boolean isAnthemCase;
    private String houseAccountMemberFlag;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private Instant createdDateTime;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private Instant updatedDateTime;
}
