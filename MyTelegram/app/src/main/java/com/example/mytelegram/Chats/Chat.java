package com.example.mytelegram.Chats;

import java.util.GregorianCalendar;

public class Chat {

    public static final int DELIVERED = 0;
    public static final int DELIVERED_AND_READ = 1;

    private String imageLink;
    private String name;
    private GregorianCalendar messageTime;
    private String lastMessage;
    private String lastSender;
    private int status;

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

    public GregorianCalendar getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(GregorianCalendar messageTime) {
        this.messageTime = messageTime;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String getLastSender() {
        return lastSender;
    }

    public void setLastSender(String lastSender) {
        this.lastSender = lastSender;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
