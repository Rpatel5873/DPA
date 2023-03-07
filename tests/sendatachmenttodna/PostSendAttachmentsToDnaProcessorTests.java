package com.aim.dnaautomation.tests.sendatachmenttodna;

import com.aim.automation.helpers.CustomFilterableRequestSpecification;
import com.aim.automation.helpers.GeneralFunctionality;
import com.aim.automation.helpers.enums.platformcontext.PlatformContextVersionEnum;
import com.aim.automation.steps.base.BasePreparationSteps;
import com.aim.automation.tests.base.PostTests;
import com.aim.dnaautomation.dtos.getdocumentstatus.DnaStatusDTO;
import com.aim.dnaautomation.dtos.sendattachmenttodna.SendAttachmentsToDnaProcessorResponseDTO;
import com.aim.dnaautomation.helpers.constants.BasePathConstants;
import com.aim.dnaautomation.helpers.dataproviders.DataProviders;
import com.aim.dnaautomation.steps.getdocumentstatus.GetDocumentStatusSteps;
import com.aim.dnaautomation.steps.sendattachmenttodna.PostSendAttachmentsToDNAProcessorSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class PostSendAttachmentsToDnaProcessorTests extends PostTests {

    private CustomFilterableRequestSpecification requestSpecification;

    @BeforeClass
    public void init() {
        basePath = BasePathConstants.SEND_ATTACHMENTS_TO_DNA_PROCESSOR;
        body = new GeneralFunctionality().generateRandomIntAsString(7);
        this.requestSpecification = new BasePreparationSteps()
                .initializeRequestSpecification(PlatformContextVersionEnum.PC_V1, false);
    }

    @Test(dataProvider = "sendAttachmentsToDNAProcessor", dataProviderClass = DataProviders.class)
    public void whenPostSendAttachmentsToDNAProcessorV1ThenServiceShouldReturnTransactionIdAsResponse(List<String> attachmentIds, String caseId) {

        // Post Send Attachment To DNA Processor
        SendAttachmentsToDnaProcessorResponseDTO[] transactionIds = new PostSendAttachmentsToDNAProcessorSteps(requestSpecification).
                createPostSendAttachmentsToDNAProcessorSteps(attachmentIds, caseId);
        // Iterate Over For Loop and Get the TransactionId's
        for (int i = 0; i < transactionIds.length; i++) {
            // GetDocumentStatus Call
            DnaStatusDTO statusDTO = new GetDocumentStatusSteps(requestSpecification).
                    createGetDocumentStatusFromDNAProcessorSteps(transactionIds[i].getTransactionId());

            // Verify the Attachment Id and CaseId
            softNG.assertEquals(transactionIds[i].getAttachmentId(), statusDTO.getAttachmentId());
            softNG.assertEquals(caseId, statusDTO.getCaseId());
            softNG.assertAll();
        }

    }
}
