package com.zero.design.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite 定义有枝节点行为，用来存储子部件，在Component接口中实现与子部件有关操作，如增加(add)和删除
 * 实现目录节点
 * Created by unique on 2017/5/17.
 */
public class NoderComposite extends NodeComponent {

    /**
     * 内部节点列表（包括文件和下级目录）
     */
    private List<NodeComponent> nodeList;

    /**
     *
     * @param name
     */
    public NoderComposite(String name) {
        super(name);
        nodeList = new ArrayList<>();
    }

    /**
     * 新增节点
     * @param node
     * @throws Exception
     */
    @Override
    public void addNode(NodeComponent node) throws Exception {
        nodeList.add(node);
    }

    /**
     * 删除节点
     * @param node
     * @throws Exception
     */
    @Override
    public void remove(NodeComponent node) throws Exception {
        nodeList.remove(node);
    }

    /**
     * 递归循环下级节点
     */
    @Override
    public void display() {
        System.out.println(getName());
        for (NodeComponent node: nodeList) {
             node.display();
        }
    }
}
