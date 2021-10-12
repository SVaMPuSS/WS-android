package com.example.mytelegram.CallsFavorites;

import java.util.GregorianCalendar;

public class CallFavorite {
    public static final int ACCEPT_CALL = 0;
    public static final int CANCEL_CALL = 1;
    public static final int CALL = 2;
    private int typeResponse;
    private String imageLink;
    private String name;
    private int callDuration;
    private GregorianCalendar timeCall;

    public int getTypeResponse() {
        return typeResponse;
    }

    public void setTypeResponse(int typeResponse) {
        this.typeResponse = typeResponse;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(int callDuration) {
        this.callDuration = callDuration;
    }

    public GregorianCalendar getTimeCall() {
        return timeCall;
    }

    public void setTimeCall(GregorianCalendar timeCall) {
        this.timeCall = timeCall;
    }
}
