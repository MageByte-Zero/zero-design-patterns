package com.zero.design.structural.composite;

/**
 * 【说明】抽象构建角色：是组合中的对象声明接口，在适当的情况下，实现所有类共有接口的默认行为。
 * 声明一个接口用于访问和管理Component子部件。
 * 【作用】将文件与目录统一看作是一类节点，做一个抽象类来定义这种节点，然后以其实现类来区分文件与目录，在实现类中分别定义各自的具体实现内容
 * Created by unique on 2017/5/17.
 */
public abstract class NodeComponent {
    /**
     * 名称
     */
    private String name;

    public NodeComponent(String name) {
        this.name = name;
    }

    /**
     * 新增节点：文本节点无此方法，目录节点重写此方法
     * @throws Exception
     */
    public void addNode(NodeComponent node) throws Exception {
        throw new Exception("Invalid exception");
    }

    /**
     * 遍历节点
     */
    public abstract void display();

    /**
     * 删除节点:文本节点无此方法
     * @param node
     */
    public void remove(NodeComponent node) throws Exception {
        throw new Exception("Invalid exception");
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "NodeComponent{" +
                "name='" + name + '\'' +
                '}';
    }
}
