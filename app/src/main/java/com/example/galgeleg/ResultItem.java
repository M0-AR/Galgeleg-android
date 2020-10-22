package com.example.galgeleg;

public class ResultItem {
    private String mResultMessage;
    private String mCorrectLetters;
    private String mWrongLetters;

    public ResultItem(String mResultMessage, String mCorrectLetters, String mWrongLetters) {
        this.mResultMessage = mResultMessage;
        this.mCorrectLetters = mCorrectLetters;
        this.mWrongLetters = mWrongLetters;
    }

    public String getResultMessage() {
        return mResultMessage;
    }

    public String getCorrectLetters() {
        return mCorrectLetters;
    }

    public String getWrongLetters() {
        return mWrongLetters;
    }
}
