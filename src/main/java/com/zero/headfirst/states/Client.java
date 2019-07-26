package com.zero.headfirst.states;

/**
 * 客户端模拟投入硬币调用自动售货机提供的接口
 */
public class Client {
    public static void main(String[] args) {
        MachineContext machineContext = new MachineContext(2);

        // 模拟投入硬币
        machineContext.putCoin();
        machineContext.putCoin();
        machineContext.putCoin();

        //模拟管理员添加汽水
        machineContext.setCount(1);
        machineContext.putCoin();


    }
}
