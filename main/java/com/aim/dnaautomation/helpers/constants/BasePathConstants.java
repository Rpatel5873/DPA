package com.aim.dnaautomation.helpers.constants;

/**
 * Created by BharathRam on 02/16/2022
 */
public class BasePathConstants {

    public static final String SEND_ATTACHMENT_TO_DNA_PROCESSOR = "/digitalnurseassistant/v1/sendAttachmentToDNAProcessor";
    public static final String SEND_ATTACHMENTS_TO_DNA_PROCESSOR = "/digitalnurseassistant/v1/sendAttachmentsToDNAProcessor";
    public static final String GET_DOCUMENT_STATUS = "/digitalnurseassistant/v1/getDocumentStatus";
    public static final String CLIENT_CONFIG_QUERY = "/config/v3/clientconfigquery";
    public static final String APPLICATION_STATUS_QUERY = "/digitalnurseassistant/v1/applicationStatusQuery";
    public static final String TURNARONDTIME = "/turnaroundtime/v1/calculateturnaroundtime";
    public static final String TURNAROUNDTIMEROUTERCONFIGURATION = "/turnaroundtime/v1/turnAroundTimeRouterConfiguration";
    public static final String DNA_POLICY_CONFIGURATION = "/digitalnurseassistant/v1/DnaPolicyConfiguration";


    //clinical simulator
    public static final String SIMULATOR_PATH = "/rabbitmq/simulator/v3/publishEvent";

    // Communication Manage AttachmentIds service
    public static final String MANAGE_ATTACHMENT_IDS = "communications/attachment/v2";

    // Tibco Service
    public static final String TIBCO_SERVICE = "http://sdcqiapplnx001:5444";
}
