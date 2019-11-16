package com.zero.headfirst.chain.support;

import java.io.Serializable;

public class NumberData implements Serializable {
    private Integer number;

    public NumberData(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "NumberData{" +
                "number=" + number +
                '}';
    }
}
