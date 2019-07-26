package com.zero.design.actions.template;

/**
 * Created by unique on 2017/6/7.
 */
public class Tea extends AbstractBeverage {

    /**
     * 这样通过钩子就可以选择是都要加佐料了
     */
    private boolean addCondiments = true;

    /**
     * 添加糖、牛奶
     */
    @Override
    protected void addCondiments() {
        System.out.println("添加柠檬，茶更好喝");
    }

    /**
     * 咖啡冲泡方法
     */
    @Override
    protected void brew() {
        System.out.println("秘制泡茶方式放入茶叶");
    }

    /**
     * 使用钩子，不加佐料
     * @return
     */
    @Override
    boolean customerWantsCondiments() {
        return addCondiments;
    }

    public boolean isAddCondiments() {
        return addCondiments;
    }

    public void setAddCondiments(boolean addCondiments) {
        this.addCondiments = addCondiments;
    }
}

