package com.sas.sasystem.view;

import java.util.HashMap;

public class Message {
    private HashMap<String, String> message;

    public Message(HashMap<String, String> message) {
        this.message = message;
    }

    public String get(String s) {
        return message.get(s);
    }

    public void put(String key, String value) {
        this.message.put(key, value);
    }
}
