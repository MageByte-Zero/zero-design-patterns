package com.zero.design.actions.template;

/**
 * Created by unique on 2017/6/7.
 */
public class Test {

    public static void main(String[] args) {
        Tea tea = new Tea();
        tea.setAddCondiments(false);
        tea.prepareRecipe();
        System.out.println("-------------------");
        Coffe coffe = new Coffe();
        coffe.prepareRecipe();
    }

}
