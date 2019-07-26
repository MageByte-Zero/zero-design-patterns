package com.zero.test.reduce;

import com.zero.test.model.Company;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lijianqing
 * @Type ReduceTest
 * @Desc
 * @date 2018/11/23 15:54
 * @Version 1.0
 */
public class ReduceTest {

    public static void main(String[] args) {
        Company company1 = new Company(new BigDecimal(100D), new BigDecimal(0.2D));
        Company company2 = new Company(new BigDecimal(200D), new BigDecimal(0.2D));
        Company company3 = new Company(new BigDecimal(300D), new BigDecimal(0.2D));
        List<Company> companies = new ArrayList<>(3);
        companies.add(company1);
        companies.add(company2);
        companies.add(company3);
        BigDecimal bigDecimal = testReduce(companies);
        System.out.println(bigDecimal);
    }

    public static BigDecimal testReduce(List<Company> companies) {
        Company company = new Company();
        BigDecimal bigDecimal = companies.stream().reduce((x, y) -> {
            BigDecimal multiplyX = x.getLastAmount().multiply(x.getFee());
            BigDecimal multiplyY = y.getLastAmount().multiply(y.getFee());
            BigDecimal add = multiplyX.add(multiplyY);
            company.setTotal(add);
            return company;
        }).map(Company::getTotal).get();
        return bigDecimal;
    }

}
