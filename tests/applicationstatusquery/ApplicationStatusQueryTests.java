package com.aim.dnaautomation.tests.applicationstatusquery;

import com.aim.automation.helpers.CustomFilterableRequestSpecification;
import com.aim.automation.helpers.GeneralFunctionality;
import com.aim.automation.helpers.enums.platformcontext.PlatformContextVersionEnum;
import com.aim.automation.steps.base.BasePreparationSteps;
import com.aim.automation.tests.base.PostTests;
import com.aim.dnaautomation.dtos.applicationstatusquery.DnaApplicationEventStatusResponseDTO;
import com.aim.dnaautomation.dtos.getdocumentstatus.DnaStatusDTO;
import com.aim.dnaautomation.helpers.constants.BasePathConstants;
import com.aim.dnaautomation.steps.applicationstatusquery.ApplicationStatusQuerySteps;
import com.aim.dnaautomation.steps.getdocumentstatus.GetDocumentStatusSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static com.aim.dnaautomation.helpers.rabbitmqconstants.Constants.*;

public class ApplicationStatusQueryTests extends PostTests {

    private CustomFilterableRequestSpecification requestSpecification;

    @BeforeClass
    public void init() {
        basePath = BasePathConstants.APPLICATION_STATUS_QUERY;
        body = new GeneralFunctionality().generateRandomIntAsString(7);
        this.requestSpecification = new BasePreparationSteps()
                .initializeRequestSpecification(PlatformContextVersionEnum.PC_V1, false);
    }

    @Test
    public void whenPostApplicationStatusQueryWithCaseIdReturnAttachmentIDTransactionIdAsResponse() {

        // Post Send Attachment To DNA Processor
        List<DnaApplicationEventStatusResponseDTO> transactionIds = new ApplicationStatusQuerySteps(requestSpecification).
                constructApplicationStatusQueryServiceRequest(CASEID_QA, null, null, null);

        transactionIds.forEach(responseDTO -> responseDTO.getTransactions().forEach(transaction -> {
                    // GetDocumentStatus Call
                    DnaStatusDTO dnaStatusDTO = new GetDocumentStatusSteps(requestSpecification).
                            createGetDocumentStatusFromDNAProcessorSteps(transaction.getTransactionId());
                    // Verify the Attachment Id and CaseId
                    softNG.assertEquals(transaction.getAttachmentId(), dnaStatusDTO.getAttachmentId());
                    softNG.assertEquals(transaction.getTransactionId(), dnaStatusDTO.getTransactionId());
                    softNG.assertEquals(dnaStatusDTO.getCaseId(), CASEID_QA);
                    softNG.assertEquals(dnaStatusDTO.getStatus(), STATUS);
                    softNG.assertEquals(dnaStatusDTO.getStatusCode(), STATUS_CODE);
                    softNG.assertAll();
                })
        );
    }

    @Test
    public void whenPostApplicationStatusQueryWithAttachmentIdReturnAttachmentIDTransactionIdAsResponse() {

        // Post Send Attachment To DNA Processor
        List<DnaApplicationEventStatusResponseDTO> transactionIds = new ApplicationStatusQuerySteps(requestSpecification).
                constructApplicationStatusQueryServiceRequest(null, ATTACHMENTID, null, null);

        transactionIds.forEach(responseDTO -> responseDTO.getTransactions().forEach(transaction -> {
                    // GetDocumentStatus Call
                    DnaStatusDTO dnaStatusDTO = new GetDocumentStatusSteps(requestSpecification).
                            createGetDocumentStatusFromDNAProcessorSteps(transaction.getTransactionId());
                    // Verify the Attachment Id and CaseId
                    softNG.assertEquals(transaction.getAttachmentId(), dnaStatusDTO.getAttachmentId());
                    softNG.assertEquals(transaction.getTransactionId(), dnaStatusDTO.getTransactionId());
                    softNG.assertEquals(dnaStatusDTO.getCaseId(), CASEID_QA);
                    softNG.assertEquals(dnaStatusDTO.getStatus(), STATUS);
                    softNG.assertEquals(dnaStatusDTO.getStatusCode(), STATUS_CODE);
                    softNG.assertAll();
                })
        );
    }

    @Test
    public void whenPostApplicationStatusQueryWithTransactionIdReturnAttachmentIDTransactionIdAsResponse() {

        // Post Send Attachment To DNA Processor
        List<DnaApplicationEventStatusResponseDTO> transactionIds = new ApplicationStatusQuerySteps(requestSpecification).
                constructApplicationStatusQueryServiceRequest(null, null, TRANSACTIONID, null);

        transactionIds.forEach(responseDTO -> responseDTO.getTransactions().forEach(transaction -> {
                    // GetDocumentStatus Call
                    DnaStatusDTO dnaStatusDTO = new GetDocumentStatusSteps(requestSpecification).
                            createGetDocumentStatusFromDNAProcessorSteps(transaction.getTransactionId());
                    // Verify the Attachment Id and CaseId
                    softNG.assertEquals(transaction.getAttachmentId(), dnaStatusDTO.getAttachmentId());
                    softNG.assertEquals(transaction.getTransactionId(), dnaStatusDTO.getTransactionId());
                    softNG.assertEquals(dnaStatusDTO.getCaseId(), CASEID_QA);
                    softNG.assertEquals(dnaStatusDTO.getStatus(), STATUS);
                    softNG.assertEquals(dnaStatusDTO.getStatusCode(), STATUS_CODE);
                    softNG.assertAll();
                })
        );
    }

    @Test
    public void whenPostApplicationStatusQueryWithCaseIdAndAttachmentIdReturnAttachmentIDTransactionIdAsResponse() {

        // Post Send Attachment To DNA Processor
        List<DnaApplicationEventStatusResponseDTO> transactionIds = new ApplicationStatusQuerySteps(requestSpecification).
                constructApplicationStatusQueryServiceRequest(CASEID_QA, ATTACHMENTID, null, null);
        transactionIds.forEach(responseDTO -> responseDTO.getTransactions().forEach(transaction -> {
                    // GetDocumentStatus Call
                    DnaStatusDTO dnaStatusDTO = new GetDocumentStatusSteps(requestSpecification).
                            createGetDocumentStatusFromDNAProcessorSteps(transaction.getTransactionId());
                    // Verify the Attachment Id and CaseId
                    softNG.assertEquals(transaction.getAttachmentId(), dnaStatusDTO.getAttachmentId());
                    softNG.assertEquals(transaction.getTransactionId(), dnaStatusDTO.getTransactionId());
                    softNG.assertEquals(dnaStatusDTO.getCaseId(), CASEID_QA);
                    softNG.assertEquals(dnaStatusDTO.getStatus(), STATUS);
                    softNG.assertEquals(dnaStatusDTO.getStatusCode(), STATUS_CODE);
                    softNG.assertAll();
                })
        );
    }

    @Test
    public void whenPostApplicationStatusQueryWithCaseIdAttachmentIdAndTransactionIdReturnAttachmentIDTransactionIdAsResponse() {

        // Post Send Attachment To DNA Processor
        List<DnaApplicationEventStatusResponseDTO> transactionIds = new ApplicationStatusQuerySteps(requestSpecification).
                constructApplicationStatusQueryServiceRequest(CASEID_QA, ATTACHMENTID, TRANSACTIONID, null);
        transactionIds.forEach(responseDTO -> responseDTO.getTransactions().forEach(transaction -> {
                    // GetDocumentStatus Call
                    DnaStatusDTO dnaStatusDTO = new GetDocumentStatusSteps(requestSpecification).
                            createGetDocumentStatusFromDNAProcessorSteps(transaction.getTransactionId());
                    // Verify the Attachment Id and CaseId
                    softNG.assertEquals(transaction.getAttachmentId(), dnaStatusDTO.getAttachmentId());
                    softNG.assertEquals(transaction.getTransactionId(), dnaStatusDTO.getTransactionId());
                    softNG.assertEquals(dnaStatusDTO.getCaseId(), CASEID_QA);
                    softNG.assertEquals(dnaStatusDTO.getStatus(), STATUS);
                    softNG.assertEquals(dnaStatusDTO.getStatusCode(), STATUS_CODE);
                    softNG.assertAll();
                })
        );
    }

    @Test
    public void whenPostApplicationStatusQueryWithCaseIdAttachmentIdTransactionIdAndTreatmentCodeReturnAttachmentIDTransactionIdAsResponse() {

        // Post Send Attachment To DNA Processor
        List<DnaApplicationEventStatusResponseDTO> transactionIds = new ApplicationStatusQuerySteps(requestSpecification).
                constructApplicationStatusQueryServiceRequest(CASEID_QA, ATTACHMENTID, TRANSACTIONID, TREATMENTCODE);
        transactionIds.forEach(responseDTO -> responseDTO.getTransactions().forEach(transaction -> {
                    // GetDocumentStatus Call
                    DnaStatusDTO dnaStatusDTO = new GetDocumentStatusSteps(requestSpecification).
                            createGetDocumentStatusFromDNAProcessorSteps(transaction.getTransactionId());
                    // Verify the Attachment Id and CaseId
                    softNG.assertEquals(transaction.getAttachmentId(), dnaStatusDTO.getAttachmentId());
                    softNG.assertEquals(transaction.getTransactionId(), dnaStatusDTO.getTransactionId());
                    softNG.assertEquals(dnaStatusDTO.getCaseId(), CASEID_QA);
                    softNG.assertEquals(dnaStatusDTO.getStatus(), STATUS);
                    softNG.assertEquals(dnaStatusDTO.getStatusCode(), STATUS_CODE);
                    softNG.assertAll();
                })
        );
    }
}
