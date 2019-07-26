package com.zero.headfirst.states;

/**
 * 机器上下文-持有所有状态，以及当前状态的引用
 */
public class MachineContext {
    /**
     * 持有所有状态
     */
    private MachineState noCoinState;
    private MachineState hasCoinState;
    private MachineState sellingState;
    private MachineState sellOutState;
    public MachineContext(int count) {
        noCoinState = new NoCoinState(this);
        hasCoinState = new HasCoinState(this);
        sellingState = new SellingState(this);
        sellOutState = new SellOutState(this);

        this.count = count;
        if (count > 0) {
            currentState = noCoinState;
        } else {
            currentState = sellOutState;
        }
    }

    /**
     * 默认售罄状态
     */
    private MachineState currentState = sellOutState;
    /**
     * 记录肥宅水数量
     */
    private int count;


    //所有的行为都委托到当前状态类

    /**
     * 投入硬币
     */
    public void putCoin() {
        if (count > 0) {
            this.setCurrentState(getHasCoinState());
        }

        currentState.handleRequest();
    }


    public MachineState getNoCoinState() {
        return noCoinState;
    }



    public MachineState getHasCoinState() {
        return hasCoinState;
    }


    public MachineState getSellingState() {
        return sellingState;
    }



    public MachineState getSellOutState() {
        return sellOutState;
    }



    public MachineState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(MachineState currentState) {
        this.currentState = currentState;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "MachineContext{" +
                "noCoinState=" + noCoinState +
                ", hasCoinState=" + hasCoinState +
                ", sellingState=" + sellingState +
                ", sellOutState=" + sellOutState +
                ", currentState=" + currentState +
                ", count=" + count +
                '}';
    }
}
