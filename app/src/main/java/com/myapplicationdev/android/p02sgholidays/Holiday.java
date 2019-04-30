package com.myapplicationdev.android.p02sgholidays;

public class Holiday {
    private String holidayName;
    private String holidayDate;
    private String shortFormForPic;

    public Holiday(String holidayName, String holidayDate, String shortFormForPic) {
        this.holidayName = holidayName;
        this.holidayDate = holidayDate;
        this.shortFormForPic = shortFormForPic;
    }

    public String getHolidayName() {
        return holidayName;
    }
    public String getHolidayDate() {
        return holidayDate;
    }
    public String getShortFormForPic() {
        return shortFormForPic;
    }
}


