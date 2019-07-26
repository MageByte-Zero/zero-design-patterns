package com.zero.design.structural.composite;

/**
 * 叶子构建角色：没有子节点
 * Created by unique on 2017/5/17.
 */
public class FilterLeaf extends NodeComponent {

    /**
     * 通过构造方法为文件节点命名
     * @param name
     */
    public FilterLeaf(String name) {
        super(name);
    }

    /**
     * 显示文件节点
     */
    @Override
    public void display() {
        System.out.println(getName());
    }

}
