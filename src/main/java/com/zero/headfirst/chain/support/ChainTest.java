package com.zero.headfirst.chain.support;

public class ChainTest {
    public static void main(String[] args) {
        AbstractSupport alice = new NoSupport("Alice");
        AbstractSupport jams = new OddSupport("jams");
        AbstractSupport bob = new LimitSupport("Bob", 100);
        AbstractSupport charlie = new SpecialSupport("Charlie", 429);

        //定义责任链
        alice.setNext(jams).setNext(bob).setNext(charlie);
        for (int i = 0; i < 500; i += 33) {
            alice.process(new NumberData(i));
        }
    }
}
