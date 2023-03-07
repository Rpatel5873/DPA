package com.aim.dnaautomation.helpers.rabbitmqconstants;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Constants {

    // Case Document Constants
    public static final String CASE_ID = "111005940";
    public static final String ATTACHMENT_ID = "011cb709-f08e-46df-8bdd-9428aa8776b8";
    public static final String ATTACHMENT_STATUS_CODE = "CC";
    public static final String ATTACHMENT_TYPE_NAME = "AAA";
    public static final String ATTACHMENT_STATUS_DESCRIPTION = "DD";
    public static final String ATTACHMENT_REVIEWED_BY_USER_ROLE_NAME = "EE";

    // LocalDateTime
    public static final LocalDateTime LOCAL_DATE_TIME = LocalDateTime.now();
    // Attachment constants
    public static final String ATTACHMENT_FOLDER = "Attachment/";
    public static final String DISPLAY_NAME_PARAMETER = "displayName";
    public static final String TEST_PNG_FILE = "test_png.png";
    public static final String PNG_ATTACHMENT_TYPE = "image/png";
    // RBM Case Save Event Queue's
    public static final String RBM_CASE_SAVE_EVENT_LISTENER_QUEUE = "aim.queue.capability.attachment.process.qa";
    public static final String RBM_CASE_SAVE_EVENT_EXCHANGE = "aim.stream";
    public static final String RBM_CASE_SAVE_EVENT_ROUTING_KEY = "aim.stream.dna.processes.attachment";
    public static final String RBM_CASE_SAVE_EVENT_ROUTING_KEYS = "aim.stream.dna.processes.attachment.retry";
    // Case Constants
    public static final String CASE_REVIEW_TYPE = "PROSPECTIVE";
    public static final String LINE_OF_BUSINESS = "Commercial";
    public static final String MEMBER_GLOBAL_IDENTIFIER = "123214";
    public static final String HEALTH_CARD_IDENTIFIER = "AIM";
    public static final String MEMBER_FIRST_NAME = "JACK";
    public static final String MEMBER_LAST_NAME = "JOHN";
    public static final String MEMBER_MIDDLE_INITIAL = "J";
    public static final String MEMBER_GENDER = "M";
    public static final String REQUESTING_PROVIDER_NPI = "ASDA";
    public static final String CASE_SPECIALTY = "CSAS";
    // Treatment Code Constants
    public static final String MAIN_CODE = "70486";
    public static final String CODE_NAME = "main";
    public static final String MAIN_CODE1 = "72149";
    public static final String MAIN_CODE2 = "72158";
    public static final String DNA_NON_CONFIGURED_CPT = "77078";
    public static final String DNA_NON_CONFIGURED_POLICY_ID = "TOC_CN_ONLY";
    //DNA Client Id's
    public static final String CLIENT_ID_85 = "85";
    public static final String CLIENT_ID_45 = "45";
    public static final String CLIENT_ID_40 = "40";
    public static final String CLIENT_ID_55 = "55";
    public static final String CLIENT_ID_183 = "183";
    public static final String CLIENT_ID_191 = "191";
    public static final String CLIENT_ID_201 = "201";
    public static final String CLIENT_ID_227 = "227";
    public static final String CLIENT_ID_218 = "218";
    //DNA Client Id's
    public static final String SOLUTION_ID_1 = "1";
    public static final String SOLUTION_ID_3 = "3";
    public static final String SOLUTION_ID_12 = "12";
    // RBM Case Saved Event Constants
    public static final String MESSAGE_TYPE = "RbmCaseSavedV2";
    public static final String BUS_CORRELATION_ID = "bus-cor-id-456";
    public static final String CORRELATION_ID = "correlation-id-123";
    public static final String REQUEST_ID = "request-id-1000";
    public static final String SERVICE_CONSUMER = "service-consumer-678";
    //SendAttachmentsToDNAProcessor Constants
    public static final String CASEID_1 = "135748921";
    public static final String CASEID_2 = "135752020";
    public static final String CASEID_3 = "135752033";
    public static final String CASEID_4 = "135752036";
    public static final String ATTACHMENTID1_FOR_CASEID1 = "88de0dcf-1c6a-488a-89dc-7709e9f67f89";
    public static final String ATTACHMENTID2_FOR_CASEID1 = "8bdcc7d7-29f5-4a24-8b6a-d4ed890d833f";
    public static final String ATTACHMENTID1_FOR_CASEID2 = "ab860322-e848-4d20-a680-ac0aa7a918b1";
    public static final String ATTACHMENTID2_FOR_CASEID2 = "8446d09f-f9aa-45b3-a50f-6099f25daf50";
    public static final String ATTACHMENTID1_FOR_CASEID3 = "0bb4ec9e-ad56-4679-ae00-66d4af5b6ce9";
    public static final String ATTACHMENTID1_FOR_CASEID4 = "20cb4221-b86f-43a4-aa5e-9d8f60347b5b";
    public static final String ATTACHMENTID2_FOR_CASEID4 = "48a51835-cdcb-4496-bf4c-2f95a0efd3c7";
    public static final String ATTACHMENTID3_FOR_CASEID4 = "d5a3dc79-1ea4-4f57-bad2-f7eab32f8d80";
    //Application Status Query
    public static final String CASEID_QA = "135758972";
    public static final String ATTACHMENTID = "4a809cfd-7615-44ea-b535-df8ab845c839";
    public static final String TRANSACTIONID = "e0965edb-cbdb-47b3-8f9a-df3fa5738763";
    public static final String TREATMENTCODE = "70486";
    public static final String STATUS = "Generating Insights";
    public static final String STATUS_CODE = "600";

    // RBM Tibco Service Headers
    public static final String CONNECTION_ID = "keep-alive";
    public static final String PRODUCT_ID = "1";
    public static final String EVENT_TYPE_CD = "AIM.RBM.CaseSaved.V2";
    public static final String PUBLISHER_APPLICATION_ID = "1";
    public static final String PUBLISHER_EVENT_ID = "1";
    public static final String PRODUCT_NAME = "RBM";
    public static final String DATE_OF_BIRTH = "2021-08-02T16:40:43";

    // SURGICAL Tibco Service Headers
    public static final String CONNECTION_ID_SURG = "keep-alive";
    public static final String PRODUCT_ID_SURG = "9";
    public static final String EVENT_TYPE_CD_SURG = "aim.stream.eventbridge.surgical.v2.caseSaved";
    public static final String PUBLISHER_APPLICATION_ID_SURG = "1";
    public static final String PUBLISHER_EVENT_ID_SURG = "1";
    public static final String PRODUCT_NAME_SURG = "SURGICAL";
    public static final String DATE_OF_BIRTH_SURG = "2021-08-02T16:40:43";


    // MSK Tibco Service Headers
    public static final String MSK_CONNECTION_ID = "keep-alive";
    public static final String MSK_PRODUCT_ID = "12";
    public static final String MSK_CASE_SAVE_EVENT_TYPE_CD = "AIM.MSK.CaseSaved.V2";
    public static final String MSK_CASE_PROMOTED_EVENT_TYPE_CD = "AIM.MSK.CasePromoted.V2";
    public static final String MSK_PUBLISHER_APPLICATION_ID = "2";
    public static final String MSK_PUBLISHER_EVENT_ID = "e807615c-00db-4b49-ae9a-6949b38c5b3b";
    public static final String MSK_PRODUCT_NAME = "MSK";
    public static final String MSK_DATE_OF_BIRTH = "05/25/2012T00:00:00-05:00";

    //RBM CPT CODES
    public static final String LUMBAR_MRI_CPT_CODE_1 = "72148";
    public static final String LUMBAR_MRI_CPT_CODE_2 = "72149";
    public static final String LUMBAR_MRI_CPT_CODE_3 = "72158";
    public static final String CERVICAL_MRI_CPT_CODE_1 = "72141";
    public static final String CERVICAL_MRI_CPT_CODE_2 = "72142";
    public static final String CERVICAL_MRI_CPT_CODE_3 = "72156";
    public static final String DIVERTICULITIS_CPT_CODE_1 = "74150";
    public static final String DIVERTICULITIS_CPT_CODE_2 = "74160";
    public static final String DIVERTICULITIS_CPT_CODE_3 = "74170";
    public static final String DIVERTICULITIS_CPT_CODE_4 = "74176";
    public static final String DIVERTICULITIS_CPT_CODE_5 = "74177";
    public static final String DIVERTICULITIS_CPT_CODE_6 = "74178";
    public static final String SINUSITIS_CPT_CODE_1 = "70486";
    public static final String SINUSITIS_CPT_CODE_2 = "70487";
    public static final String SINUSITIS_CPT_CODE_3 = "70488";
    public static final String BREAST_MRI_CPT_CODE_1 = "70446";
    public static final String BREAST_MRI_CPT_CODE_2 = "70447";
    public static final String BREAST_MRI_CPT_CODE_3 = "70448";
    public static final String BREAST_MRI_CPT_CODE_4 = "70449";
    public static final String CHEST_CPT_CODE_1 = "71250";
    public static final String CHEST_CPT_CODE_2 = "71260";
    public static final String MRI_BRAIN_AIM_CPT_CODE_1 = "70551";
    public static final String MRI_BRAIN_AIM_CPT_CODE_2 = "70552";
    public static final String MRI_UPPER_EXTREMITY_AIM_CPT_CODE_1 = "73221";
    public static final String CT_ABDOMEN_AND_OR_PELVIS_AIM_CPT_CODE = "74176";

    // CARDIOLOGY CPT CODES
    public static final String CARDIOLOGY_CPT_CODE_1 = "93880";
    public static final String CARDIOLOGY_CPT_CODE_2 = "71271";
    public static final String CARDIOLOGY_CPT_CODE_3 = "93455";
    public static final String CARDIOLOGY_CPT_CODE_4 = "93461";
    // MSK CPT CODES
    public static final String MSK_CPT_CODE_1 = "22800";
    public static final String MSK_CPT_CODE_2 = "22551";
    public static final String MSK_CPT_CODE_3 = "62323";
    public static final String MSK_CPT_CODE_4 = "27331";
    public static final String MSK_NON_CONFIGURED_CPT = "77078";
    public static final String MSK_NON_CONFIGURED_POLICY_ID = "TOC_CN_ONLY";
    //TAT ROUTER CONFIGURATIONID
    public static final String FIRSTLEVELMEMBERAPPEAL = "a0a452a0-3367-49e2-a31b-d4ce8a3b2efb";
    public static final String FIRSTLEVELPROVIDERAPPEAL = "284cf725-5b01-48f2-be00-8b70eaa2479b";
    public static final String LACKOFINFORMATION = "07ff89b6-acd1-4c3f-9f0e-a363727ddf1d";
    public static final String PROVIDERCOURTESYREVIEW = "6c4f06dc-6027-48e1-b3ac-91cdfa207d46";
    public static final String PROVIDERDOCUMENTATIONREVIEW = "69bb3d38-48f9-4cb4-8333-1c56ac3ff8f1";
    public static final String TURNAROUNDTIMESTANDARD = "cd3a05f7-95b1-4035-8dc1-ca15fd872c96";
    //DNA POLICYID'S
    public static final String POLICY_SINUSITIS = "Sinusitis";
    public static final String POLICY_DIVERTICULITIS = "Diverticulitis";
    public static final String POLICY_LUMBAR_MRI = "Lumbar MRI";
    public static final String POLICY_BREAST_MRI = "BREAST MRI HP";
    public static final String POLICY_MRI_BRAIN_AIM = "MRI BRAIN AIM";
    public static final String POLICY_MRI_UPPER_EXTREMITY_AIM = "MRI UPPER EXTREMITY AIM";
    public static final String POLICY_CERVICAL_MRI = "Cervical MRI";
    public static final String POLICY_CT_ABDOMEN_AND_OR_PELVIS_AIM = "CT ABDOMEN AND/OR PELVIS AIM";
    public static final String POLICY_CHEST = "CHEST";
    public static final String DPA_LUMBAR_MRI = "office visit, radiology report MRI lumbar spine, physical therapy notes";
    public static final String DPA_BREAST_MRI = "office visit, encounter visit and radiology note";
    public static final String DPA_SINUSITIS = "office visit";
    public static final String DPA_CERVICALMRI = "office visit, radiology report MRI cervical spine, physical therapy notes";
    public static final String DPA_CHEST = "office visit";
    public static final String DPA_MRI_BRAIN_AIM = "office visit";
    public static final String DPA_MRI_UPPER_EXTREMITY_AIM = "Office Visit,Shoulder Xray,PT Note";
    public static final String DPA_CT_ABDOMEN_AND_OR_PELVIS_AIM = "office visit,radiology report,PT note if available";
    public static final Integer DNACONFIGURATIONRESPONSESIZE_2 = 2;
    public static final Integer DNACONFIGURATIONRESPONSESIZE_1 = 1;
    public static final Integer DNACONFIGURATIONRESPONSESIZE_3 = 3;
    //TAT SCENARIO's
    public static final String FIRST_LEVEL_PROVIDER_APPEAL = "firstLevelProviderAppeal";
    public static final String LACK_OF_INFORMATION = "lackOfInformation";
    public static final String RECONSIDERATION = "reconsideration";
    public static final String PROVIDER_DOCUMENTATION_REVIEW = "providerDocumentationReview";
    public static final String TURNAROUND_TIME_STANDARD = "turnAroundTimeStandard";
    public static final String FIRST_LEVEL_MEMBER_APPEAL = "firstLevelMemberAppeal";
    public static final String PROVIDER_COURTESY_REVIEW = "provideCourtesyReview";
    // LocalDateTime
    public static LocalDate LOCAL_DATE = LocalDate.now();

    public static String HOUSEACCOUNT_TRUE = "Y";
    public static String HOUSEACCOUNT_FALSE = "N";


}
