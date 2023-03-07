package com.aim.dnaautomation.factories.capabilitiesconfigwrapper;

import com.aim.dnaautomation.dtos.configwrapperdto.InitiatePortalAppealsEnabledDTO;
import com.aim.dnaautomation.dtos.configwrapperdto.InitiatePortalAppealsEnabledServicesDTO;

import java.util.ArrayList;
import java.util.List;

import static com.aim.dnaautomation.helpers.configwrapperconstant.ConfigWrapperConstants.*;
import static com.aim.dnaautomation.helpers.configwrapperconstant.ConfigWrapperConstants.PORTAL_APPEALS_SEQUENCE_NUMBER_1;

public class InitiatePortalAppealsEnabledDTOFactory {

    public InitiatePortalAppealsEnabledDTO createInitiateAppealDTOFactory(String outcome, String caseStatus, String userRole, String id, String outcomeCode, String reasonCode, Integer sequenceNumber) {

        InitiatePortalAppealsEnabledDTO requestDTO = new InitiatePortalAppealsEnabledDTO();
        requestDTO.setOutcome(outcome);
        requestDTO.setCaseStatus(caseStatus);
        requestDTO.setUserRole(userRole);
        requestDTO.setServices(createInitiateAppealServicesDTOFactory(id,outcomeCode,reasonCode,sequenceNumber));

        return requestDTO;
    }

    public InitiatePortalAppealsEnabledDTO createMultipleInitiateAppealDTOFactory(String outcome, String caseStatus, String userRole, String id, String outcomeCode, String reasonCode, Integer sequenceNumber) {

        InitiatePortalAppealsEnabledDTO requestDTO = new InitiatePortalAppealsEnabledDTO();
        requestDTO.setOutcome(outcome);
        requestDTO.setCaseStatus(caseStatus);
        requestDTO.setUserRole(userRole);
        requestDTO.setServices(createMultipleInitiateAppealServicesDTOFactory(1,id,outcomeCode,reasonCode,sequenceNumber));

        return requestDTO;
    }

    public static InitiatePortalAppealsEnabledServicesDTO createServiceDTO2() {
        InitiatePortalAppealsEnabledServicesDTO services = new InitiatePortalAppealsEnabledServicesDTO();
        services.setId(PORTAL_APPEALS_ID_NULL);
        services.setOutcomeCode(PORTAL_APPEALS_OUTCOME_NON_AUTHORIZED);
        services.setReasonCode(PORTAL_APPEALS_REASONCODE_94);
        services.setSequenceNumber(PORTAL_APPEALS_SEQUENCE_NUMBER_1);
        return services;
    }

    public List<InitiatePortalAppealsEnabledServicesDTO> createInitiateAppealServicesDTOFactory(String id, String outcomeCode, String reasonCode, Integer sequenceNumber) {

        List<InitiatePortalAppealsEnabledServicesDTO> services2 = new ArrayList<>();
        InitiatePortalAppealsEnabledServicesDTO serviceRrequestDTO = new InitiatePortalAppealsEnabledServicesDTO();
        serviceRrequestDTO.setId(String.valueOf(id));
        serviceRrequestDTO.setOutcomeCode(String.valueOf(outcomeCode));
        serviceRrequestDTO.setReasonCode(String.valueOf(reasonCode));
        serviceRrequestDTO.setSequenceNumber(Integer.valueOf(String.valueOf(sequenceNumber)));

        services2.add(serviceRrequestDTO);
        return services2;
    }


    public List<InitiatePortalAppealsEnabledServicesDTO> createMultipleInitiateAppealServicesDTOFactory(int numberOfSequence, String id, String outcomeCode, String reasonCode, Integer sequenceNumber) {

        List<InitiatePortalAppealsEnabledServicesDTO> list = new ArrayList<>();
        for (int i = 0; i < numberOfSequence; i++) {
            InitiatePortalAppealsEnabledServicesDTO serviceRrequestDTO = new InitiatePortalAppealsEnabledServicesDTO();
            serviceRrequestDTO.setId(String.valueOf(id));
            serviceRrequestDTO.setOutcomeCode(String.valueOf(outcomeCode));
            serviceRrequestDTO.setReasonCode(String.valueOf(reasonCode));
            serviceRrequestDTO.setSequenceNumber(Integer.valueOf(String.valueOf(sequenceNumber)));

            list.add(serviceRrequestDTO);
            list.add(createServiceDTO2());
        }
        return list;
    }
}
