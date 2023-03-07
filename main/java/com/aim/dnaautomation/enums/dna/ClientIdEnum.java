package com.aim.dnaautomation.enums.dna;

/**
 * Created By BharathRam on 03/05/2022
 */

public enum ClientIdEnum {

    CLIENT_ID_85("85"),
    CLIENT_ID_184("184"),
    CLIENT_ID_185("185"),
    CLIENT_ID_186("186"),
    CLIENT_ID_187("187");

    private String clientId;

    ClientIdEnum(String clientId) {
        this.clientId = clientId;

    }

    public String getIdAsString() {
        return clientId;
    }

    public int getIdAsInteger() {
        return Integer.parseInt(getIdAsString());
    }
}
