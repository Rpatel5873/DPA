package capabilities.turnaroundtimeautomation.tests.prodturnaroundtimecalculation;

import com.aim.automation.helpers.convert.GenericConvertHelper;
import com.aim.dnaautomation.dtos.turnaroundtime.ClientConfigTestCaseDTO;
import com.aim.dnaautomation.dtos.turnaroundtime.TATResponseDTO;
import com.aim.dnaautomation.dtos.turnaroundtime.TurnAroundTimeParticipation;
import com.aim.dnaautomation.helpers.clientconfig.ClientConfigBaseTest;
import com.aim.dnaautomation.helpers.clientconfig.PlatformContextConvert;
import com.aim.dnaautomation.steps.turnaroundtime.TurnAroundTimeSteps;
import com.aim.servicemodel.domain.PlatformContext;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.aim.dnaautomation.helpers.rabbitmqconstants.Constants.FIRST_LEVEL_MEMBER_APPEAL;

public class TatFirstLevelMemberAppeal37ProdCalculationTests extends ClientConfigBaseTest {
    private static final String FILE_NAME = "clientconfigurations/tatFirstLevelMemberAppeal37ProdCalculation.json";

    @DataProvider(name = "tatFirstLevelMemberAppeal37ProdCalculationTestCases")
    private Object[][] tatFirstLevelMemberAppeal37ProdCalculationTestCases() {
        return loadTestCaseDTOsFromJson(FILE_NAME);
    }

    @Test(dataProvider = "tatFirstLevelMemberAppeal37ProdCalculationTestCases")
    public void tatFirstLevelMemberAppeal37ProdCalculationTestCases(ClientConfigTestCaseDTO testCaseDTO) throws JsonProcessingException {
        PlatformContext platformContext = new PlatformContextConvert().updatePlatformContextDTO(requestSpecification, testCaseDTO);
        requestSpecification.addPlatformContextToRequest(new GenericConvertHelper().dtoToString(platformContext));
        TurnAroundTimeParticipation routerresponse = new TurnAroundTimeSteps(requestSpecification).TurnAroundTimeRouterConfiguration(requestSpecification);
        TATResponseDTO response = new TurnAroundTimeSteps(requestSpecification).CalculateTurnAroundTimeStepsForPRODTATCalculation(requestSpecification, testCaseDTO, routerresponse, FIRST_LEVEL_MEMBER_APPEAL);
        softly.then(response.getTurnAroundDeterminationDateTime()).isEqualTo(testCaseDTO.getExpectedFields().getTurnAroundDeterminationDateTime());
        softly.then(response.getTurnAroundNotificationDateTime()).isEqualTo(testCaseDTO.getExpectedFields().getTurnAroundNotificationDateTime());
        softly.assertAll();
    }
}