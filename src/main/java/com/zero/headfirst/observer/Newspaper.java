package com.zero.headfirst.observer;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Newspaper implements Serializable {
    private LocalDateTime reportTime;
    private String data;

    public LocalDateTime getReportTime() {
        return reportTime;
    }

    public void setReportTime(LocalDateTime reportTime) {
        this.reportTime = reportTime;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Newspaper{" +
                "reportTime=" + reportTime +
                ", data='" + data + '\'' +
                '}';
    }
}
