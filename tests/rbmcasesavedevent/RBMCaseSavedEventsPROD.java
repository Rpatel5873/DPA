package com.aim.dnaautomation.tests.rbmcasesavedevent;

import com.aim.automation.helpers.CustomFilterableRequestSpecification;
import com.aim.automation.helpers.GeneralFunctionality;
import com.aim.automation.helpers.PlatformContextUtils;
import com.aim.automation.helpers.enums.ContextModeEnum;
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

public class RBMCaseSavedEventsPROD extends PostTests {

    private final PlatformContextUtils platformContextUtils;
    private CustomFilterableRequestSpecification requestSpecification;

    public RBMCaseSavedEventsPROD() {
        platformContextUtils = new PlatformContextUtils();
    }

    @BeforeClass
    public void init() {
        basePath = BasePathConstants.SEND_ATTACHMENT_TO_DNA_PROCESSOR;
        body = new GeneralFunctionality().generateRandomIntAsString(7);
        this.requestSpecification = new BasePreparationSteps()
                .initializeRequestSpecification(PlatformContextVersionEnum.PC_V1, false);
    }

    @Test(dataProvider = "RBMCaseSavedEventsPROD", dataProviderClass = DataProviders.class)
    public void whenRBMCaseSaveEventIsTriggeredThroughTibcoServiceByProvidingValidAttachmentIdAndCPTCodeThenApplicationStatusQueryServiceResponseShouldContainUniqueTransactionIdAlongWithCPTCodeAndAttachmentId(String CPT, String productId, String eventTypeCode, String publisherApplicationId, String publisherEventId, String productName, String DOB, String clientId, String houseAccountMemberFlag) throws Exception {

        requestSpecification.addPlatformContextToRequest(platformContextUtils
                .changeContextMode(requestSpecification, ContextModeEnum.TEST.getMode()));

        // Upload an Attachment through ManageAttachments/V2
        PostManageAttachmentUtility utility = new PostManageAttachmentUtility(requestSpecification);

        // Create  AttachmentId
        String attachmentId = utility.createAttachmentIdFromManageAttachmentsV2AndReturnAttachmentId();
        Thread.sleep(20000);

        // Generate CaseId
        String caseId = new GeneralFunctionality().generateRandomIntAsString(9);

        // Publish RBM Case Save Event Through Tibco Service
        TibcoServiceUtility caseSave = new TibcoServiceUtility(requestSpecification, CONNECTION_ID, PRODUCT_ID, EVENT_TYPE_CD, PUBLISHER_APPLICATION_ID, PUBLISHER_EVENT_ID);
        caseSave.publishCaseSavedEventThroughTibcoService(caseId, attachmentId, CPT, productId, eventTypeCode,
                publisherApplicationId, publisherEventId, productName, DOB, clientId, houseAccountMemberFlag);
        Thread.sleep(10000);

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
                        switch (CPT) {
                            case CERVICAL_MRI_CPT_CODE_1:
                            case CERVICAL_MRI_CPT_CODE_2:
                            case CERVICAL_MRI_CPT_CODE_3:
                                softly.then(dnaStatusDTO.getPolicyId()).isEqualTo(POLICY_CERVICAL_MRI);
                                break;
                            case LUMBAR_MRI_CPT_CODE_1:
                            case LUMBAR_MRI_CPT_CODE_2:
                            case LUMBAR_MRI_CPT_CODE_3:
                                softly.then(dnaStatusDTO.getPolicyId()).isEqualTo(POLICY_LUMBAR_MRI);
                                break;
                            case SINUSITIS_CPT_CODE_1:
                            case SINUSITIS_CPT_CODE_2:
                            case SINUSITIS_CPT_CODE_3:
                                softly.then(dnaStatusDTO.getPolicyId()).isEqualTo(POLICY_SINUSITIS);
                                break;
                            case DIVERTICULITIS_CPT_CODE_1:
                            case DIVERTICULITIS_CPT_CODE_2:
                            case DIVERTICULITIS_CPT_CODE_3:
                            case DIVERTICULITIS_CPT_CODE_5:
                            case DIVERTICULITIS_CPT_CODE_6:
                                softly.then(dnaStatusDTO.getPolicyId()).isEqualTo(POLICY_DIVERTICULITIS);
                                break;
                            case BREAST_MRI_CPT_CODE_1:
                            case BREAST_MRI_CPT_CODE_2:
                            case BREAST_MRI_CPT_CODE_3:
                            case BREAST_MRI_CPT_CODE_4:
                                softly.then(dnaStatusDTO.getPolicyId()).isEqualTo(POLICY_BREAST_MRI);
                                break;
                            case MRI_BRAIN_AIM_CPT_CODE_1:
                            case MRI_BRAIN_AIM_CPT_CODE_2:
                                softly.then(dnaStatusDTO.getPolicyId()).isEqualTo(POLICY_MRI_BRAIN_AIM);
                                break;
                            case MRI_UPPER_EXTREMITY_AIM_CPT_CODE_1:
                                softly.then(dnaStatusDTO.getPolicyId()).isEqualTo(POLICY_MRI_UPPER_EXTREMITY_AIM);
                                break;
                            case CT_ABDOMEN_AND_OR_PELVIS_AIM_CPT_CODE:
                                softly.then(dnaStatusDTO.getPolicyId()).isEqualTo(POLICY_CT_ABDOMEN_AND_OR_PELVIS_AIM);
                                break;
                            case DNA_NON_CONFIGURED_CPT:
                                softly.then(dnaStatusDTO.getPolicyId()).isEqualTo(DNA_NON_CONFIGURED_POLICY_ID);
                                break;
                        }
                    } else {
                        // GetDocumentStatus Call
                        new GetDocumentStatusSteps(requestSpecification).
                                houseAccountMemberCase(transaction.getTransactionId());

                    }
                })
        );
        softly.assertAll();
    }

}
