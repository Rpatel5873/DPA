package com.aim.dnaautomation.tests.sendatachmenttodna;

import com.aim.automation.helpers.CustomFilterableRequestSpecification;
import com.aim.automation.helpers.GeneralFunctionality;
import com.aim.automation.helpers.enums.platformcontext.PlatformContextVersionEnum;
import com.aim.automation.steps.base.BasePreparationSteps;
import com.aim.automation.tests.base.PostTests;
import com.aim.dnaautomation.dtos.getdocumentstatus.DnaStatusDTO;
import com.aim.dnaautomation.helpers.constants.BasePathConstants;
import com.aim.dnaautomation.helpers.rabbitmqconstants.Constants;
import com.aim.dnaautomation.steps.getdocumentstatus.GetDocumentStatusSteps;
import com.aim.dnaautomation.steps.sendattachmenttodna.PostSendAttachmentToDNAProcessorSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PostSendAttachmentToDnaProcessorTests extends PostTests {

    private CustomFilterableRequestSpecification requestSpecification;

    @BeforeClass
    public void init() {
        basePath = BasePathConstants.SEND_ATTACHMENT_TO_DNA_PROCESSOR;
        body = new GeneralFunctionality().generateRandomIntAsString(7);
        this.requestSpecification = new BasePreparationSteps()
                .initializeRequestSpecification(PlatformContextVersionEnum.PC_V1, false);
    }

    @Test
    public void whenPostSendAttachmentToDNAProcessorV1ThenServiceShouldReturnTransactionIdAsResponse() {

        // Post Send Attachment To DNA Processor
        String transactionId = new PostSendAttachmentToDNAProcessorSteps(requestSpecification).
                createPostSendAttachmentToDNAProcessorSteps(Constants.ATTACHMENT_ID, Constants.CASE_ID);

        // GetDocumentStatus Call
        DnaStatusDTO statusDTO = new GetDocumentStatusSteps(requestSpecification).
                createGetDocumentStatusFromDNAProcessorSteps(transactionId);

        // Verify the Attachment Id and CaseId
        softNG.assertEquals(Constants.ATTACHMENT_ID, statusDTO.getAttachmentId());
        softNG.assertEquals(Constants.CASE_ID, statusDTO.getCaseId());
        softNG.assertAll();

    }

}
