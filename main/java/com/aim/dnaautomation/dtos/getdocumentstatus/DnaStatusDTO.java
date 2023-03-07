package com.aim.dnaautomation.dtos.getdocumentstatus;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * Created by BharathRam on 02/23/2022
 */
public class DnaStatusDTO {

    private String attachmentId;
    private String caseId;
    private ZonedDateTime createdDateTime;
    private LocalDate dateOfService;
    private String documentFormat;
    private String documentName;
    private String documentType;
    private String finalRecommendation;
    private String generatedInsightUrl;
    private String policyId;
    private String recommendation;
    private Integer solutionId;
    private String status;
    private String statusCode;
    private String transactionId;
    private String treatmentCode;
    private ZonedDateTime updatedDateTime;
    private Integer runSequence;

    @JsonGetter("createdDateTime")
    public String getCreatedDateTimeProperty() {
        if (createdDateTime != null) {
            return createdDateTime.toString();
        }
        return null;
    }

    @JsonSetter("createdDateTime")
    public void setCreatedDateTimeProperty(String val) {
        if (val != null) {
            this.createdDateTime = ZonedDateTime.parse(val);
        } else {
            this.createdDateTime = null;
        }

    }

    @JsonGetter("updatedDateTime")
    public String getUpdatedDateTimeProperty() {
        if (updatedDateTime != null) {
            return updatedDateTime.toString();
        }
        return null;
    }

    @JsonSetter("updatedDateTime")
    public void setUpdatedDateTimeProperty(String val) {
        if (val != null) {
            this.updatedDateTime = ZonedDateTime.parse(val);
        } else {
            this.updatedDateTime = null;
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
