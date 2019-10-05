package com.kristoffer;

public class Field {

    private String to;
    private String from;
    private int time;

    public Field(String from, String to, int time) {
        this.from = from;
        this.to = to;
        this.time = time;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getTime() {
        return time;
    }
}
