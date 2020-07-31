package com.home.yx.ch1;

public class NumberRange {
    private int lower, upper;

    public int getLower() {
        return lower;
    }

    public void setLower(int value) {
        if (value > upper) {
            return;
        }
        this.lower = value;
    }

    public int getUpper() {
        return upper;
    }

    public void setUpper(int value) {
        if (value < lower) {
            return;
        }
        this.upper = value;
    }
}
