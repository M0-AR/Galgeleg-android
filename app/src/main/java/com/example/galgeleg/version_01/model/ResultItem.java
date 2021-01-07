package com.example.galgeleg.version_01.model;

import java.io.Serializable;
import java.util.Date;

public class ResultItem implements Serializable{
    private String mResultMessage;
    private String mCorrectLetters;
    private String mWrongLetters;
    private Date date;
    private String playerName;

    public ResultItem(String mResultMessage, String mCorrectLetters, String mWrongLetters, Date date, String playerName) {
        this.mResultMessage = mResultMessage;
        this.mCorrectLetters = mCorrectLetters;
        this.mWrongLetters = mWrongLetters;
        this.date = date;
        this.playerName = playerName;
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

    public String getPlayerName() {
        return playerName;
    }
}
