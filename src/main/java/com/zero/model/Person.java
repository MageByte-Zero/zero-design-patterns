package com.zero.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Person {
    private String userName;
    private String phone;
    private String password;
    private String address;
    private Integer age;
    private Integer sex;

    /**
     * 将builder全部赋值给person对象
     * @param builder
     */
    private Person(Builder builder) {
        this.userName = builder.userName;
        this.password = builder.password;
        this.phone = builder.phone;
        this.address = builder.address;
        this.age = builder.age;
        this.sex = builder.sex;
    }

    /**
     * 将所有参数包装在Builder中,在最后build方法全部赋值给Person
     */
    public static class Builder {
        // 必填参数
        private String userName;
        private String password;

        // 可选参数
        private String phone;
        private String address;
        private Integer age;
        private Integer sex;

        public Builder(String userName, String password) {
            this.userName = userName;
            this.password = password;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder age(Integer age) {
            this.age = age;
            return this;
        }

        public Builder sex(Integer sex) {
            this.sex = sex;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("userName", userName)
                .append("phone", phone)
                .append("password", password)
                .append("address", address)
                .append("age", age)
                .append("sex", sex)
                .toString();
    }

    public static void main(String[] args) {
        Person person = new Builder("李健青", "123456")
                .address("广西")
                .age(28)
                .phone("18556538119")
                .build();
        System.out.println(person.toString());
    }
}