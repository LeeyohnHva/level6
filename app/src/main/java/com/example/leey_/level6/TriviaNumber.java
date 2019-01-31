package com.example.leey_.level6;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TriviaNumber {

    @SerializedName("text")
    @Expose
    private String mText;

    @SerializedName("number")
    @Expose
    private int mNumber;

    public TriviaNumber(String mText, int mNumber) {
        this.mText = mText;
        this.mNumber = mNumber;
    }

    public String getText() {
        return mText;
    }

    public void setText(String mText) {
        this.mText = mText;
    }

    public int getNumber() {
        return mNumber;
    }

    public void setNumber(int mNumber) {
        this.mNumber = mNumber;
    }
}
