package com.sas.sasystem.view;

import java.util.HashMap;

public class Pack {
    private HashMap<String, Object> pack;

    public Pack() {
        this.pack = new HashMap<>();
    }

    public Pack(HashMap<String, Object> message) {
        this.pack = message;
    }

    public Object get(String s) {
        return pack.get(s);
    }

    public void put(String key, Object value) {
        this.pack.put(key, value);
    }

    public int getSize() {
        return this.pack.size();
    }
}
