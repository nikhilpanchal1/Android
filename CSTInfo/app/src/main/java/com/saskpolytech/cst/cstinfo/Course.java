package com.saskpolytech.cst.cstinfo;

import java.util.zip.CheckedOutputStream;

public class Course {
    public String name;
    public String code;
    public int hours;
    public int credits;
    public String desc;

    public Course(String name, String code, int hours,int credits, String desc)
    {
        this.name = name;
        this.credits = credits;
        this.hours = hours;
        this.desc =desc;
        this.code = code;
    }

    @Override
    public  String toString()
    {
        return this.code + "-" +this.name;
    }
}
