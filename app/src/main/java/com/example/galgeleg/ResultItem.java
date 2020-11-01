package com.example.galgeleg;

import java.io.Serializable;
import java.util.Date;

public class ResultItem implements Serializable{
    private String mResultMessage;
    private String mCorrectLetters;
    private String mWrongLetters;
    private Date date;

    public ResultItem(String mResultMessage, String mCorrectLetters, String mWrongLetters) {
        this.mResultMessage = mResultMessage;
        this.mCorrectLetters = mCorrectLetters;
        this.mWrongLetters = mWrongLetters;
    }

    public ResultItem(String mResultMessage, String mCorrectLetters, String mWrongLetters, Date date) {
        this.mResultMessage = mResultMessage;
        this.mCorrectLetters = mCorrectLetters;
        this.mWrongLetters = mWrongLetters;
        this.date = date;
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

    public Date getDate() {
        return date;
    }
}
