package com.zero.design.structural.composite;

import java.io.File;

/**
 * 客户端测试
 * Created by unique on 2017/5/17.
 */
public class Client {

    /**
     * 根据文件路径创建树,生成目录数据结构
     * @param node
     * @throws Exception
     */
    public static void createTree(NodeComponent node) throws Exception {
        File file = new File(node.getName());
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile()) {
                FilterLeaf filter = new FilterLeaf(f.getAbsolutePath());
                node.addNode(filter);
            }
            if (f.isDirectory()) {
                NoderComposite noder = new NoderComposite(f.getAbsolutePath());
                node.addNode(noder);
                //使用递归生成树结构
                createTree(noder);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        NodeComponent node = new NoderComposite("D:\\JAVA\\maven");
        try {
            createTree(node);
        } catch (Exception e) {
            e.printStackTrace();
        }

        node.display();
    }
}
