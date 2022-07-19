package com.hadvq.quanlysinhvien;

import android.text.Editable;

public class Student {
    private int MSSV;
    private String name;
    private String email;
    private String birthday;

    public Student() {
    }

    public Student(int MSSV, String name, String email, String birthday) {
        this.MSSV = MSSV;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
    }

    public int getMSSV() {
        return MSSV;
    }

    public void setMSSV(int MSSV) {
        this.MSSV = MSSV;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
