package com.zero.design.creational.singleton;

/**
 * 使用内部类来维护单例实现，JVM内部机制能够保证当一个类被加载的时候
 * 这个类的加载过程是线程互斥的。也就是第一次调用互斥，解决了性能为题
 * @author unique
 *
 */
public class SingletonInner {
	
	private SingletonInner() {
		
	}
	
	/**
	 * 用内部类维护单例,只加载一次并且保证线程安全初始化完成。
	 * @author unique
	 *
	 */
	private static class SingletonFactory {
		//final防止内部误操作
		private static final SingletonInner INSTANCE = new SingletonInner();
	}
	
	public static final SingletonInner getInstance() {
		return SingletonFactory.INSTANCE;
	}

}
