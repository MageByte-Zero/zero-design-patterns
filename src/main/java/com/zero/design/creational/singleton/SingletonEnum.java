package com.zero.design.creational.singleton;

/**
 * 枚举单例实现
 *
 * @author jianqing.li
 * @date 2018/7/3
 */
public class SingletonEnum {

    enum SingletonHolder {
        PRESIDENT(new President());
        private Object holdedObject;

        SingletonHolder(Object holdedObject) {
            this.holdedObject = holdedObject;
        }

        public Object getHoldedObject() {
            return holdedObject;
        }
    }

    public static void main(String[] args) {
        President holdedObject = (President) SingletonHolder.PRESIDENT.getHoldedObject();
        President holdedObject2 = (President) SingletonHolder.PRESIDENT.getHoldedObject();
        System.out.println(holdedObject == holdedObject2);
    }
}
