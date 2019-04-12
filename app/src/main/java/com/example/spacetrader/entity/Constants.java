package com.example.spacetrader.entity;

/**
 * This class represents the constants we used in our implementation
 */
public enum Constants {
    MAX_SKILL(12), COUNTDOWN(6),START_SKILL(16), ONEOTHREE(103), TWENTY(20), FOURTY(40),
    THIRTY(30),SIXTY(60),FIFTY(50),EIGHTY(80),
    SEVENTY(70),NINETY(90),ONETWENTY(120),EIGHTYFIVE(85),
    ONEFOURTY(140),SIXTYFIVE(65),ONEFIFTY(150), FOURTYFOUR(44);

    private final int num;
   Constants(int num) {
        this.num = num;
    }


    /**
     * returns the value of the number
     * @return the decimal value of the number listed
     */
    public int getValue() {
        return this.num;
    }

}
