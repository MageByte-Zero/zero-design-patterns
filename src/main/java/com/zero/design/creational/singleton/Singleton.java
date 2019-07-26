package com.zero.design.creational.singleton;

public class Singleton {

	/**
	 * 持有私有化对象，防止被引用，赋值null，目的是实现延迟加载
	 */
	private static Singleton instance = null;

	/**
	 * 私有化构造方法，防止被实例化
	 */
	private Singleton() {

	}
	
	/**
	 * 创建实例,毫无线程安全
	 * @return
	 */
	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
	
	/**
	 * 只有当null徐娅创建对象的时候加锁。但是java中创建对象与赋值操作是分开的，（1.申请内存，2-初始化对象，3-设置instance指向刚分配的内存地址）但是2、3可能会被指令重排序
	 * 也就是说 instance = new Singleton();是分布执行的，A进来执行instance = new Singleton();然后退出
	 * 此时还没有初始化，可是B进来发现不是null，然后返回。就会导致空指针,解决方法是使用volatile修饰变量
	 * @return
	 */
	public static Singleton getInstanceSyn() {
		if (instance == null) {
			synchronized (instance) {
				instance = new Singleton();
			}
		}
		return instance;
	}
	
	/**
	 * 如果对象被用于序列化，可以保证对象再序列化前后保持一致
	 * @return
	 */
	public Object readResolve() {
		return instance;
	}

}
