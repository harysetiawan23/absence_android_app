package com.example.harry.facialabsence.Model;

public class Pelajaran {
    private String timeStart,timStop,name,className;

    public Pelajaran(String timeStart, String timStop, String name, String className) {
        this.timeStart = timeStart;
        this.timStop = timStop;
        this.name = name;
        this.className = className;
    }


    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimStop() {
        return timStop;
    }

    public void setTimStop(String timStop) {
        this.timStop = timStop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
