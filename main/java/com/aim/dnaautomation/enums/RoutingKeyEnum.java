package com.aim.dnaautomation.enums;

public enum RoutingKeyEnum {

    rbm_Case_Save_Event("aim.stream.eventbridge.rbm.v2.caseSaved");
    private String routingKey;

    RoutingKeyEnum(String routingKey) {
        this.routingKey = routingKey;
    }

    public String getRoutingKey() {
        return routingKey;
    }

}
