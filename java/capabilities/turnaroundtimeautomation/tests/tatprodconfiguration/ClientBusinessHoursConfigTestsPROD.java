package capabilities.turnaroundtimeautomation.tests.tatprodconfiguration;

import com.aim.dnaautomation.helpers.constants.BasePathConstants;
import com.aim.enterprise.config.ClientConfigHelperTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

public class ClientBusinessHoursConfigTestsPROD extends ClientConfigHelperTest {
    private static final String FILE_NAME = "clientconfigurations/ClientBusinessHoursPROD.json";

    @BeforeClass
    public void init() {
        body = new HashMap<>();
        basePath = BasePathConstants.CLIENT_CONFIG_QUERY;
    }

    @DataProvider(name = "clientConfigDataProvider")
    private Object[][] clientConfigDataProvider() {
        return this.constructSingleRequestClientConfigDataProvider(FILE_NAME); // filters record based on testModeEffectiveDate and testModeEndaDate.
    }

    //Single Request with context Mode
    @Test(dataProvider = "clientConfigDataProvider")
    public void testConfigurations(Object configurationId, Object request, Object response) throws IOException {
        this.executeSingleRequest(configurationId, request, response, PROD);
    }
}
