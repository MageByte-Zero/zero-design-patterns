package com.zero.headfirst.decorator;

/**
 * 煎饼果子店
 */
public class PancakeShop {
    public static void main(String[] args) {
        System.out.println("========土豪来了，全都加上。======");
        BeggarPancake beggarPancake = new BeggarPancake();
        EggDecorator eggDecorator = new EggDecorator(beggarPancake);
        HamDecorator hamAndEggDecorator = new HamDecorator(eggDecorator);
        LettuceDecorator lettuceAndHamAndEggDecorator = new LettuceDecorator(hamAndEggDecorator);
        lettuceAndHamAndEggDecorator.cook();

        System.out.println("========苦逼码农来了，只要鸡蛋补补脑。=====");
        BeggarPancake beggarPancake1 = new BeggarPancake();
        EggDecorator eggDecorator1 = new EggDecorator(beggarPancake1);
        eggDecorator1.cook();
    }
}
