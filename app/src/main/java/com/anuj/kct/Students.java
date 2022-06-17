package com.anuj.kct;

public class Students {
    public String fullname,symbol,faculty,semester;

    public Students(){

    }


    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Students(String fullname, String symbol, String faculty, String semester) {
        this.fullname = fullname;
        this.symbol = symbol;
        this.faculty = faculty;
        this.semester = semester;


    }
}
