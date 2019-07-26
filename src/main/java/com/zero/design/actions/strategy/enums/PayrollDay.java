package com.zero.design.actions.strategy.enums;

/**
 * 枚举策略模式:多个枚举常量，共享相同的行为
 * Created by unique on 2018/3/5.
 */
public enum PayrollDay {

    MONDAY(PayType.WEEKDAY),
    TUESDAY(PayType.WEEKDAY),
    WEDNESDAY(PayType.WEEKDAY),
    THURSDAY(PayType.WEEKDAY),
    FRIDAY(PayType.WEEKDAY),
    SATURDAY(PayType.WEEKEND),
    SUNDAY(PayType.WEEKEND);

    /**
     * 策略类型,由此控制选择策略
     */
    private final PayType payType;

    /**
     * 将策略实例传给构造器，从而将算法委托给策略枚举
     * @param payType
     */
    PayrollDay(PayType payType) {
        this.payType = payType;
    }

    /**
     * 工资算法,委托给策略枚举
     *
     * @param hoursWorked 工作时长
     * @param payRate 每小时薪资
     * @return
     */
    double pay(double hoursWorked, double payRate) {
        return payType.pay(hoursWorked, payRate);
    }

    /**
     * 策略枚举
     */
    private enum PayType {
        /**
         * 周日超时所付工资算法策略
         */
        WEEKDAY {
            @Override
            double overtimePay(double hoursWorked, double payRate) {
                return hoursWorked <= HOURS_PER_SHIFT ? 0 : (hoursWorked - HOURS_PER_SHIFT) * payRate;
            }
        },
        /**
         * 周末所付工资算法策略,2倍工资
         */
        WEEKEND {
            @Override
            double overtimePay(double hoursWorked, double payRate) {
                return hoursWorked * payRate * 2;
            }
        };

        private static final int HOURS_PER_SHIFT = 8;

        /**
         * 定义抽象算法,由具体枚举策略实现
         *
         * @param hoursWorked
         * @param payRate
         * @return
         */
        abstract double overtimePay(double hoursWorked, double payRate);

        double pay(double hoursWorked, double payRate) {
            double basePay = hoursWorked * payRate;
            return basePay + overtimePay(hoursWorked, payRate);
        }
    }
}
