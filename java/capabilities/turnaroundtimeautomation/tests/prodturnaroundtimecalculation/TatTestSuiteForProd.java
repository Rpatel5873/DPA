package capabilities.turnaroundtimeautomation.tests.prodturnaroundtimecalculation;

import com.aim.automation.helpers.convert.GenericConvertHelper;
import com.aim.dnaautomation.dtos.turnaroundtime.ClientConfigTestCaseDTO;
import com.aim.dnaautomation.dtos.turnaroundtime.TATResponseDTO;
import com.aim.dnaautomation.helpers.clientconfig.ClientConfigBaseTest;
import com.aim.dnaautomation.helpers.clientconfig.PlatformContextConvert;
import com.aim.dnaautomation.steps.turnaroundtime.TurnAroundTimeSteps;
import com.aim.servicemodel.domain.PlatformContext;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TatTestSuiteForProd extends ClientConfigBaseTest {
    private static final String FILE_NAME = "clientconfigurations/TatTestSuiteForProd.json";

    @DataProvider(name = "TatTestSuiteForProd")
    private Object[][] TatTestSuiteForProd() {
        return loadTestCaseDTOsFromJson(FILE_NAME);
    }

    @Test(dataProvider = "TatTestSuiteForProd")
    public void TatTestSuiteForProd(ClientConfigTestCaseDTO testCaseDTO) throws JsonProcessingException {
        PlatformContext platformContext = new PlatformContextConvert().updatePlatformContextDTO(requestSpecification, testCaseDTO);
        requestSpecification.addPlatformContextToRequest(new GenericConvertHelper().dtoToString(platformContext));
        TATResponseDTO response = new TurnAroundTimeSteps(requestSpecification).CalculateTurnAroundTimeStepsWithSystemDate(requestSpecification, testCaseDTO);
        softly.then(response.getTurnAroundDeterminationDateTime()).isNotNull();
        softly.then(response.getTurnAroundNotificationDateTime()).isNotNull();
        softly.assertAll();
    }
}