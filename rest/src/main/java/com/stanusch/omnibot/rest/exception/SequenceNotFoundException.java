package com.stanusch.omnibot.rest.exception;

public class SequenceNotFoundException extends RuntimeException {
    private final String sequenceName;
    public SequenceNotFoundException(String sequenceName, String message) {
        super(message);
        this.sequenceName = sequenceName;
    }

    public String getSequenceName() {
        return sequenceName;
    }
}
