package com.aim.dnaautomation.helpers.clientconfig;


import com.aim.automation.tests.base.BaseTest;
import com.aim.dnaautomation.dtos.turnaroundtime.ClientConfigTestCaseDTO;
import com.aim.enterprise.config.steps.ClientConfigRequestSteps;

/**
 * Base test class for client configurations specific test classes and intended to be inherited.
 */

public class ClientConfigBaseTest extends BaseTest {


    private final ClientConfigRequestSteps clientConfigRequestSteps;
    private final JSONLoader jsonFileLoader;

    public ClientConfigBaseTest() {
        clientConfigRequestSteps = new ClientConfigRequestSteps();
        jsonFileLoader = new JSONLoader();
    }

    protected ClientConfigTestCaseDTO[][] loadTestCaseDTOsFromJson(String fileName) {
        ClientConfigTestCaseDTO[] testCases = jsonFileLoader.readDtoFromFile(fileName, ClientConfigTestCaseDTO[].class);
        ClientConfigTestCaseDTO[][] dtos = new ClientConfigTestCaseDTO[testCases.length][1];

        for (int i = 0; i < testCases.length; i++) {
            dtos[i][0] = testCases[i];
        }
        return dtos;
    }
}

