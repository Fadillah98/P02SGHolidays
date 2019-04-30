package com.myapplicationdev.android.p02sgholidays;

public class Holiday {
    private String name;
    private boolean type;
    private String date;
    private Integer id;

    public Holiday(Integer id,String name, boolean type , String date) {
        this.name = name;
        this.type = type;
        this.date = date;
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public boolean isType() {
        return type;
    }
    public String getDate() {
        return date;
    }
    public Integer getID(){
        return id;
    }

    // getView() is the method ListView will call to get the
}


