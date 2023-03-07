package com.aim.dnaautomation.tests.mskevents;

import com.aim.automation.helpers.CustomFilterableRequestSpecification;
import com.aim.automation.helpers.GeneralFunctionality;
import com.aim.automation.helpers.enums.platformcontext.PlatformContextVersionEnum;
import com.aim.automation.steps.base.BasePreparationSteps;
import com.aim.automation.tests.base.PostTests;
import com.aim.dnaautomation.dtos.applicationstatusquery.DnaApplicationEventStatusResponseDTO;
import com.aim.dnaautomation.dtos.getdocumentstatus.DnaStatusDTO;
import com.aim.dnaautomation.helpers.attachmentutilities.PostManageAttachmentUtility;
import com.aim.dnaautomation.helpers.constants.BasePathConstants;
import com.aim.dnaautomation.helpers.dataproviders.DataProviders;
import com.aim.dnaautomation.helpers.tibcoserviceutility.TibcoServiceUtility;
import com.aim.dnaautomation.steps.applicationstatusquery.ApplicationStatusQuerySteps;
import com.aim.dnaautomation.steps.getdocumentstatus.GetDocumentStatusSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static com.aim.dnaautomation.helpers.rabbitmqconstants.Constants.*;

public class MSKCasePromotedEventTests extends PostTests {
    private CustomFilterableRequestSpecification requestSpecification;

    @BeforeClass
    public void init() {
        basePath = BasePathConstants.SEND_ATTACHMENT_TO_DNA_PROCESSOR;
        body = new GeneralFunctionality().generateRandomIntAsString(7);
        this.requestSpecification = new BasePreparationSteps()
                .initializeRequestSpecification(PlatformContextVersionEnum.PC_V1, false);
    }

    @Test(dataProvider = "MSKCasePromotedEvents", dataProviderClass = DataProviders.class)
    public void whenMSKCasePromotedEventIsTriggeredThroughTibcoServiceByProvidingValidAttachmentIDCPTThenApplicationStatusQueryServiceResponseShouldContainUniqueTransactionIdAlongWithCPTCodeAndAttachmentIdAndPolicyIdAsTC_CN_ONLY(String CPT, String productId, String eventTypeCode, String publisherApplicationId, String publisherEventId, String productName, String DOB, String clientId, String houseAccountMemberFlag) throws Exception {

        // Upload an Attachment through ManageAttachments/V2
        PostManageAttachmentUtility utility = new PostManageAttachmentUtility(requestSpecification);

        // Create  AttachmentId
        String attachmentId = utility.createAttachmentIdFromManageAttachmentsV2AndReturnAttachmentId();
        Thread.sleep(30000);

        // Generate CaseId
        String caseId = new GeneralFunctionality().generateRandomIntAsString(9);

        // Publish MSK Case Save Event Through Tibco Service
        TibcoServiceUtility caseSave = new TibcoServiceUtility(requestSpecification, MSK_CONNECTION_ID, MSK_PRODUCT_ID, MSK_CASE_PROMOTED_EVENT_TYPE_CD, MSK_PUBLISHER_APPLICATION_ID, MSK_PUBLISHER_EVENT_ID);
        caseSave.publishCaseSavedEventThroughTibcoService(caseId, attachmentId, CPT, productId, eventTypeCode,
                publisherApplicationId, publisherEventId, productName, DOB, clientId, houseAccountMemberFlag);
        Thread.sleep(10000);

        // Invoke Application Status Query API
        List<DnaApplicationEventStatusResponseDTO> transactionIds = new ApplicationStatusQuerySteps(requestSpecification).
                constructApplicationStatusQueryServiceRequest(caseId, attachmentId, "", "");

        transactionIds.forEach(responseDTO -> responseDTO.getTransactions().forEach(transaction -> {
                    if (houseAccountMemberFlag.equalsIgnoreCase("N")) {
                        // GetDocumentStatus Call
                        DnaStatusDTO dnaStatusDTO = new GetDocumentStatusSteps(requestSpecification).
                                createGetDocumentStatusFromDNAProcessorSteps(transaction.getTransactionId());
                        // Verify the Attachment Id and CaseId
                        softly.then(transaction.getAttachmentId()).isEqualTo(dnaStatusDTO.getAttachmentId());
                        softly.then(transaction.getTransactionId()).isEqualTo(dnaStatusDTO.getTransactionId());
                        softly.then(dnaStatusDTO.getCaseId()).isEqualTo(caseId);
                        softly.then(dnaStatusDTO.getStatus()).isEqualTo(STATUS);
                    } else {
                        new GetDocumentStatusSteps(requestSpecification).
                                houseAccountMemberCase(transaction.getTransactionId());
                    }
                })
        );
        softly.assertAll();
    }
}