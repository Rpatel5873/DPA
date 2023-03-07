package com.aim.dnaautomation.enums;

/**
 * Created By BharathRam on 02/28/2022
 */
public enum ExchangeEnum {

    exchange_river("River"),
    exchange_trickle("Trickle"),
    exchange_stream("Stream");

    private String exchange;

    ExchangeEnum(String exchange) {
        this.exchange = exchange;
    }

    public String getExchange() {
        return exchange;
    }

}
