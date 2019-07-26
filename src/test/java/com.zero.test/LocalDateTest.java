/**
 * Project: com-zero-design-stu
 * File created at 2019/6/14 16:49
 */
package com.zero.test;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

/**
 * @author lijianqing
 * @version 1.0
 * @ClassName LocalDateTest
 * @date 2019/6/14 16:49
 */
public class LocalDateTest {

    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM");

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate lastMonthDate = now.minusMonths(1);
        LocalDate last12MonthDate = now.minusMonths(12);

        YearMonth lastMonth = YearMonth.from(lastMonthDate);
        YearMonth last12Month = YearMonth.from(last12MonthDate);

        YearMonth yearMonth = YearMonth.parse("2018/06", dateTimeFormatter);
        boolean b = (yearMonth.isAfter(last12Month) || yearMonth.equals(last12Month))
                && (yearMonth.isBefore(lastMonth) || yearMonth.equals(lastMonth));
        System.out.println("--------------" + b + "-----");

    }
}
