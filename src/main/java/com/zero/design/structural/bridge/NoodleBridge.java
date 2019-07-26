package com.zero.design.structural.bridge;

/**
 * 定义桥(抽象角色,对所要桥接的事物抽象,持有所要桥接的接口实例Style);
 * 面条的抽象类：也就是充当桥的角色，提供统一接口(JDBC桥DriverManager一样)。
 * 每个数据库提供各自的实现，用一个叫做数据库驱动的程序来桥接就行了。
 *
 * Created by unique on 2017/5/14.
 */
public abstract class NoodleBridge {

    /**
     * Style就相当于JDBC Driver,其不同的实现类就相当于MysqlDriver、DB2Driver...
     */
    private Style style;

    public NoodleBridge() {
    }

    /**
     * 通过构造方法实例化口味
     * @param style
     */
    public NoodleBridge(Style style) {
        this.style = style;
    }

    /**
     * 吃面，调用具体面条风格与面类型
     */
    public final void eat() {
        System.out.println("吃" + style.getPreference() + "一点的" + getNoodleName());
    }

    /**
     * 获取面条类型
     * @return
     */
    protected abstract String getNoodleName();

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }
}
