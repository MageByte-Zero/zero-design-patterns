package com.zero.test.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author lijianqing
 * @Type Company
 * @Desc
 * @date 2018/11/23 15:54
 * @Version 1.0
 */
public class Company implements Serializable {
    private BigDecimal lastAmount;
    private BigDecimal fee;
    private BigDecimal total;

    public Company() {
    }

    public Company(BigDecimal lastAmount, BigDecimal fee) {
        this.lastAmount = lastAmount;
        this.fee = fee;
    }

    public BigDecimal getLastAmount() {
        return lastAmount;
    }

    public void setLastAmount(BigDecimal lastAmount) {
        this.lastAmount = lastAmount;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("lastAmount", lastAmount)
                .append("fee", fee)
                .append("total", total)
                .toString();
    }
}
