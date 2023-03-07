package com.aim.dnaautomation.tests.dnapolicyconfiguration;

import com.aim.automation.helpers.CustomFilterableRequestSpecification;
import com.aim.automation.helpers.GeneralFunctionality;
import com.aim.automation.helpers.enums.platformcontext.PlatformContextVersionEnum;
import com.aim.automation.steps.base.BasePreparationSteps;
import com.aim.automation.tests.base.PostTests;
import com.aim.dnaautomation.dtos.dnapolicyconfiguration.DnaPolicyConfigurationResponseDTO;
import com.aim.dnaautomation.helpers.constants.BasePathConstants;
import com.aim.dnaautomation.helpers.rabbitmqconstants.Constants;
import com.aim.dnaautomation.steps.dnapolicyconfiguration.DnaPolicyConfigurationSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class DNAPolicyConfigurationTests extends PostTests {
    private CustomFilterableRequestSpecification requestSpecification;

    @BeforeClass
    public void init() {
        basePath = BasePathConstants.DNA_POLICY_CONFIGURATION;
        body = new GeneralFunctionality().generateRandomIntAsString(7);
        this.requestSpecification = new BasePreparationSteps()
                .initializeRequestSpecification(PlatformContextVersionEnum.PC_V1, false);
    }

    @Test
    public void whenDnaPolicyConfigurationwithclientId85solutionId1andSingletreatmentCodesreturnDNAConfiguration() {
        List<DnaPolicyConfigurationResponseDTO> responseDTO = new DnaPolicyConfigurationSteps(requestSpecification).constructDnaPolicyConfigurationRequest(Constants.CLIENT_ID_85, Constants.SOLUTION_ID_1, Arrays.asList(Constants.LUMBAR_MRI_CPT_CODE_1));
        Integer responseDTOLength = responseDTO.size();
        softly.then(responseDTOLength).isEqualTo(Constants.DNACONFIGURATIONRESPONSESIZE_1);
        for (int i = 0; i < responseDTOLength; i++) {
            if (responseDTO.get(i).getPolicyId().equals(Constants.POLICY_LUMBAR_MRI)) {
                softly.then(responseDTO.get(i).getPolicyId()).isEqualTo(Constants.POLICY_LUMBAR_MRI);
                softly.then(responseDTO.get(i).getDpaclinicaldocuments()).isEqualTo(Constants.DPA_LUMBAR_MRI);
            }
        }
        softly.assertAll();
    }

    @Test
    public void whenDnaPolicyConfigurationwithclientId85solutionId1andtwoDifferenttreatmentCodesreturnDNAConfiguration() {
        List<DnaPolicyConfigurationResponseDTO> responseDTO = new DnaPolicyConfigurationSteps(requestSpecification).constructDnaPolicyConfigurationRequest(Constants.CLIENT_ID_85, Constants.SOLUTION_ID_1, Arrays.asList(Constants.LUMBAR_MRI_CPT_CODE_1, Constants.SINUSITIS_CPT_CODE_1));
        Integer responseDTOLength = responseDTO.size();
        softly.then(responseDTOLength).isEqualTo(Constants.DNACONFIGURATIONRESPONSESIZE_2);
        for (int i = 0; i < responseDTOLength; i++) {
            if (responseDTO.get(i).getPolicyId().equals(Constants.POLICY_LUMBAR_MRI)) {
                softly.then(responseDTO.get(i).getPolicyId()).isEqualTo(Constants.POLICY_LUMBAR_MRI);
                softly.then(responseDTO.get(i).getDpaclinicaldocuments()).isEqualTo(Constants.DPA_LUMBAR_MRI);
            }
            if (responseDTO.get(i).getPolicyId().equals(Constants.POLICY_SINUSITIS)) {
                softly.then(responseDTO.get(i).getPolicyId()).isEqualTo(Constants.POLICY_SINUSITIS);
                softly.then(responseDTO.get(i).getDpaclinicaldocuments()).isEqualTo(Constants.DPA_SINUSITIS);
            }
        }
        softly.assertAll();
    }

    @Test
    public void whenDnaPolicyConfigurationwithclientId85solutionId1andtwoSametreatmentCodesreturnDNAConfiguration() {
        List<DnaPolicyConfigurationResponseDTO> responseDTO = new DnaPolicyConfigurationSteps(requestSpecification).constructDnaPolicyConfigurationRequest(Constants.CLIENT_ID_85, Constants.SOLUTION_ID_1, Arrays.asList(Constants.SINUSITIS_CPT_CODE_2, Constants.SINUSITIS_CPT_CODE_1));
        Integer responseDTOLength = responseDTO.size();
        softly.then(responseDTOLength).isEqualTo(Constants.DNACONFIGURATIONRESPONSESIZE_1);
        for (int i = 0; i < responseDTOLength; i++) {
            if (responseDTO.get(i).getPolicyId().equals(Constants.POLICY_SINUSITIS)) {
                softly.then(responseDTO.get(i).getPolicyId()).isEqualTo(Constants.POLICY_SINUSITIS);
                softly.then(responseDTO.get(i).getDpaclinicaldocuments()).isEqualTo(Constants.DPA_SINUSITIS);
            }
        }
        softly.assertAll();

    }

    @Test
    public void whenDnaPolicyConfigurationwithclientId85solution1IdandthreeDifferenttreatmentCodesreturnDNAConfiguration() {
        List<DnaPolicyConfigurationResponseDTO> responseDTO = new DnaPolicyConfigurationSteps(requestSpecification).constructDnaPolicyConfigurationRequest(Constants.CLIENT_ID_85, Constants.SOLUTION_ID_1, Arrays.asList(Constants.LUMBAR_MRI_CPT_CODE_1, Constants.SINUSITIS_CPT_CODE_1, Constants.CERVICAL_MRI_CPT_CODE_1));
        Integer responseDTOLength = responseDTO.size();
        softly.then(responseDTOLength).isEqualTo(Constants.DNACONFIGURATIONRESPONSESIZE_3);
        for (int i = 0; i < responseDTOLength; i++) {
            if ((responseDTO.get(i).getPolicyId()).equals(Constants.POLICY_CERVICAL_MRI)) {
                softly.then(responseDTO.get(i).getPolicyId()).isEqualTo(Constants.POLICY_CERVICAL_MRI);
                softly.then(responseDTO.get(i).getDpaclinicaldocuments()).isEqualTo(Constants.DPA_CERVICALMRI);
            }
            if ((responseDTO.get(i).getPolicyId()).equals(Constants.POLICY_SINUSITIS)) {
                softly.then(responseDTO.get(i).getPolicyId()).isEqualTo(Constants.POLICY_SINUSITIS);
                softly.then(responseDTO.get(i).getDpaclinicaldocuments()).isEqualTo(Constants.DPA_SINUSITIS);
            }
            if ((responseDTO.get(i).getPolicyId()).equals(Constants.POLICY_LUMBAR_MRI)) {
                softly.then(responseDTO.get(i).getPolicyId()).isEqualTo(Constants.POLICY_LUMBAR_MRI);
                softly.then(responseDTO.get(i).getDpaclinicaldocuments()).isEqualTo(Constants.DPA_LUMBAR_MRI);
            }
        }
        softly.assertAll();
    }

    @Test
    public void whenDnaPolicyConfigurationwithclientId55solutionId1andSingletreatmentCodesreturnDNAConfiguration() {
        List<DnaPolicyConfigurationResponseDTO> responseDTO = new DnaPolicyConfigurationSteps(requestSpecification).constructDnaPolicyConfigurationRequest(Constants.CLIENT_ID_55, Constants.SOLUTION_ID_1, Arrays.asList(Constants.LUMBAR_MRI_CPT_CODE_1));
        Integer responseDTOLength = responseDTO.size();
        softly.then(responseDTOLength).isEqualTo(Constants.DNACONFIGURATIONRESPONSESIZE_1);
        for (int i = 0; i < responseDTOLength; i++) {
            if (responseDTO.get(i).getPolicyId().equals(Constants.POLICY_LUMBAR_MRI)) {
                softly.then(responseDTO.get(i).getPolicyId()).isEqualTo(Constants.POLICY_LUMBAR_MRI);
                softly.then(responseDTO.get(i).getDpaclinicaldocuments()).isEqualTo(Constants.DPA_LUMBAR_MRI);
            }
        }
        softly.assertAll();
    }

    @Test
    public void whenDnaPolicyConfigurationwithclientId55solutionId1andtwoDifferenttreatmentCodesreturnDNAConfiguration
            () {
        List<DnaPolicyConfigurationResponseDTO> responseDTO = new DnaPolicyConfigurationSteps(requestSpecification).constructDnaPolicyConfigurationRequest(Constants.CLIENT_ID_55, Constants.SOLUTION_ID_1, Arrays.asList(Constants.LUMBAR_MRI_CPT_CODE_1, Constants.SINUSITIS_CPT_CODE_1));
        Integer responseDTOLength = responseDTO.size();
        softly.then(responseDTOLength).isEqualTo(Constants.DNACONFIGURATIONRESPONSESIZE_2);
        for (int i = 0; i < responseDTOLength; i++) {
            if (responseDTO.get(i).getPolicyId().equals(Constants.POLICY_LUMBAR_MRI)) {
                softly.then(responseDTO.get(i).getPolicyId()).isEqualTo(Constants.POLICY_LUMBAR_MRI);
                softly.then(responseDTO.get(i).getDpaclinicaldocuments()).isEqualTo(Constants.DPA_LUMBAR_MRI);
            }
            if (responseDTO.get(i).getPolicyId().equals(Constants.POLICY_SINUSITIS)) {
                softly.then(responseDTO.get(i).getPolicyId()).isEqualTo(Constants.POLICY_SINUSITIS);
                softly.then(responseDTO.get(i).getDpaclinicaldocuments()).isEqualTo(Constants.DPA_SINUSITIS);
            }
        }
        softly.assertAll();
    }

    @Test
    public void whenDnaPolicyConfigurationwithclientId55solutionId1andtwoSametreatmentCodesreturnDNAConfiguration() {
        List<DnaPolicyConfigurationResponseDTO> responseDTO = new DnaPolicyConfigurationSteps(requestSpecification).constructDnaPolicyConfigurationRequest(Constants.CLIENT_ID_55, Constants.SOLUTION_ID_1, Arrays.asList(Constants.SINUSITIS_CPT_CODE_2, Constants.SINUSITIS_CPT_CODE_1));
        Integer responseDTOLength = responseDTO.size();
        softly.then(responseDTOLength).isEqualTo(Constants.DNACONFIGURATIONRESPONSESIZE_1);
        for (int i = 0; i < responseDTOLength; i++) {
            if (responseDTO.get(i).getPolicyId().equals(Constants.POLICY_SINUSITIS)) {
                softly.then(responseDTO.get(i).getPolicyId()).isEqualTo(Constants.POLICY_SINUSITIS);
                softly.then(responseDTO.get(i).getDpaclinicaldocuments()).isEqualTo(Constants.DPA_SINUSITIS);
            }
        }
        softly.assertAll();

    }

    @Test
    public void whenDnaPolicyConfigurationwithclientId55solution1IdandthreeDifferenttreatmentCodesreturnDNAConfiguration() {
        List<DnaPolicyConfigurationResponseDTO> responseDTO = new DnaPolicyConfigurationSteps(requestSpecification).constructDnaPolicyConfigurationRequest(Constants.CLIENT_ID_55, Constants.SOLUTION_ID_1, Arrays.asList(Constants.LUMBAR_MRI_CPT_CODE_1, Constants.SINUSITIS_CPT_CODE_1, Constants.CERVICAL_MRI_CPT_CODE_1));
        Integer responseDTOLength = responseDTO.size();
        softly.then(responseDTOLength).isEqualTo(Constants.DNACONFIGURATIONRESPONSESIZE_3);
        for (int i = 0; i < responseDTOLength; i++) {
            if ((responseDTO.get(i).getPolicyId()).equals(Constants.POLICY_CERVICAL_MRI)) {
                softly.then(responseDTO.get(i).getPolicyId()).isEqualTo(Constants.POLICY_CERVICAL_MRI);
                softly.then(responseDTO.get(i).getDpaclinicaldocuments()).isEqualTo(Constants.DPA_CERVICALMRI);
            }
            if ((responseDTO.get(i).getPolicyId()).equals(Constants.POLICY_SINUSITIS)) {
                softly.then(responseDTO.get(i).getPolicyId()).isEqualTo(Constants.POLICY_SINUSITIS);
                softly.then(responseDTO.get(i).getDpaclinicaldocuments()).isEqualTo(Constants.DPA_SINUSITIS);
            }
            if ((responseDTO.get(i).getPolicyId()).equals(Constants.POLICY_LUMBAR_MRI)) {
                softly.then(responseDTO.get(i).getPolicyId()).isEqualTo(Constants.POLICY_LUMBAR_MRI);
                softly.then(responseDTO.get(i).getDpaclinicaldocuments()).isEqualTo(Constants.DPA_LUMBAR_MRI);
            }
        }
        softly.assertAll();
    }

    @Test
    public void whenDnaPolicyConfigurationwithclientId201solutionId1andSingletreatmentCodesreturnDNAConfiguration() {
        List<DnaPolicyConfigurationResponseDTO> responseDTO = new DnaPolicyConfigurationSteps(requestSpecification).constructDnaPolicyConfigurationRequest(Constants.CLIENT_ID_201, Constants.SOLUTION_ID_1, Arrays.asList(Constants.LUMBAR_MRI_CPT_CODE_1));
        Integer responseDTOLength = responseDTO.size();
        softly.then(responseDTOLength).isEqualTo(Constants.DNACONFIGURATIONRESPONSESIZE_1);
        for (int i = 0; i < responseDTOLength; i++) {
            if (responseDTO.get(i).getPolicyId().equals(Constants.POLICY_LUMBAR_MRI)) {
                softly.then(responseDTO.get(i).getPolicyId()).isEqualTo(Constants.POLICY_LUMBAR_MRI);
                softly.then(responseDTO.get(i).getDpaclinicaldocuments()).isEqualTo(Constants.DPA_LUMBAR_MRI);
            }
        }
        softly.assertAll();
    }

    @Test
    public void whenDnaPolicyConfigurationwithclientId201solutionId1andtwoDifferenttreatmentCodesreturnDNAConfiguration
            () {
        List<DnaPolicyConfigurationResponseDTO> responseDTO = new DnaPolicyConfigurationSteps(requestSpecification).constructDnaPolicyConfigurationRequest(Constants.CLIENT_ID_201, Constants.SOLUTION_ID_1, Arrays.asList(Constants.LUMBAR_MRI_CPT_CODE_1, Constants.SINUSITIS_CPT_CODE_1));
        Integer responseDTOLength = responseDTO.size();
        softly.then(responseDTOLength).isEqualTo(Constants.DNACONFIGURATIONRESPONSESIZE_2);
        for (int i = 0; i < responseDTOLength; i++) {
            if (responseDTO.get(i).getPolicyId().equals(Constants.POLICY_LUMBAR_MRI)) {
                softly.then(responseDTO.get(i).getPolicyId()).isEqualTo(Constants.POLICY_LUMBAR_MRI);
                softly.then(responseDTO.get(i).getDpaclinicaldocuments()).isEqualTo(Constants.DPA_LUMBAR_MRI);
            }
            if (responseDTO.get(i).getPolicyId().equals(Constants.POLICY_SINUSITIS)) {
                softly.then(responseDTO.get(i).getPolicyId()).isEqualTo(Constants.POLICY_SINUSITIS);
                softly.then(responseDTO.get(i).getDpaclinicaldocuments()).isEqualTo(Constants.DPA_SINUSITIS);
            }
        }
        softly.assertAll();
    }

    @Test
    public void whenDnaPolicyConfigurationwithclientId201solutionId1andtwoSametreatmentCodesreturnDNAConfiguration
            () {
        List<DnaPolicyConfigurationResponseDTO> responseDTO = new DnaPolicyConfigurationSteps(requestSpecification).constructDnaPolicyConfigurationRequest(Constants.CLIENT_ID_201, Constants.SOLUTION_ID_1, Arrays.asList(Constants.SINUSITIS_CPT_CODE_2, Constants.SINUSITIS_CPT_CODE_1));
        Integer responseDTOLength = responseDTO.size();
        softly.then(responseDTOLength).isEqualTo(Constants.DNACONFIGURATIONRESPONSESIZE_1);
        for (int i = 0; i < responseDTOLength; i++) {
            if (responseDTO.get(i).getPolicyId().equals(Constants.POLICY_SINUSITIS)) {
                softly.then(responseDTO.get(i).getPolicyId()).isEqualTo(Constants.POLICY_SINUSITIS);
                softly.then(responseDTO.get(i).getDpaclinicaldocuments()).isEqualTo(Constants.DPA_SINUSITIS);
            }
        }
        softly.assertAll();
    }

    @Test
    public void whenDnaPolicyConfigurationwithclientId201solution1IdandthreeDifferenttreatmentCodesreturnDNAConfiguration
            () {
        List<DnaPolicyConfigurationResponseDTO> responseDTO = new DnaPolicyConfigurationSteps(requestSpecification).constructDnaPolicyConfigurationRequest(Constants.CLIENT_ID_201, Constants.SOLUTION_ID_1, Arrays.asList(Constants.LUMBAR_MRI_CPT_CODE_1, Constants.SINUSITIS_CPT_CODE_1, Constants.CERVICAL_MRI_CPT_CODE_1));
        Integer responseDTOLength = responseDTO.size();
        softly.then(responseDTOLength).isEqualTo(Constants.DNACONFIGURATIONRESPONSESIZE_3);
        for (int i = 0; i < responseDTOLength; i++) {
            if ((responseDTO.get(i).getPolicyId()).equals(Constants.POLICY_CERVICAL_MRI)) {
                softly.then(responseDTO.get(i).getPolicyId()).isEqualTo(Constants.POLICY_CERVICAL_MRI);
                softly.then(responseDTO.get(i).getDpaclinicaldocuments()).isEqualTo(Constants.DPA_CERVICALMRI);
            }
            if ((responseDTO.get(i).getPolicyId()).equals(Constants.POLICY_SINUSITIS)) {
                softly.then(responseDTO.get(i).getPolicyId()).isEqualTo(Constants.POLICY_SINUSITIS);
                softly.then(responseDTO.get(i).getDpaclinicaldocuments()).isEqualTo(Constants.DPA_SINUSITIS);
            }
            if ((responseDTO.get(i).getPolicyId()).equals(Constants.POLICY_LUMBAR_MRI)) {
                softly.then(responseDTO.get(i).getPolicyId()).isEqualTo(Constants.POLICY_LUMBAR_MRI);
                softly.then(responseDTO.get(i).getDpaclinicaldocuments()).isEqualTo(Constants.DPA_LUMBAR_MRI);
            }
        }
        softly.assertAll();
    }
}
