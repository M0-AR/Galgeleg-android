package com.example.galgeleg.version_01.item;

import java.io.Serializable;
import java.util.Date;

public class ResultItem implements Serializable{
    private String mResultMessage;
    private String mCorrectLetters;
    private String mWrongLetters;
    private Date date;
    // TODO: 02/01/2021 make an int for high score and set the default value for 6 then for every wrong letter decrease the value

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
