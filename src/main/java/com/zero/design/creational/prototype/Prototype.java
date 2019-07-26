package com.zero.design.creational.prototype;

import java.io.*;

/**
 * 浅复制：将一个对象复制后，基本数据类型的变量都会重新创建，而引用类型指向的还是原对象多指向的地址。
 * 深复制：将一个对象复制后，不论基本类型、引用类型都是重新创建。
 *
 * @author unique
 */
public class Prototype implements Cloneable, Serializable {

    private static final long serialVersionUID = 1L;

    private String str;

    private SerializableObject obj;

    /**
     * 浅复制
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        //调用的是native方法
        Prototype proto = (Prototype) super.clone();
        return proto;
    }

    /**
     * 深复制:需要采用流的形式读入对象的二进制输入，再写出二进制数据对应的对象
     *
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Object deepClone() throws IOException, ClassNotFoundException {

        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos);
             ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
             ObjectInputStream ois = new ObjectInputStream(bis)) {
            //将当前对象二进制流写入
            oos.writeObject(this);
            // 读出二进制流产生的新对象
            return ois.readObject();
        }

    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public SerializableObject getObj() {
        return obj;
    }

    public void setObj(SerializableObject obj) {
        this.obj = obj;
    }

}
