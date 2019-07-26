package com.zero.design.structural.adapter.category;

/**
 * 客户端目标接口
 * @author unique
 *
 */
public interface Targetable {
	
	/**
	 * 与源类中的方法相同,可以不写，但是调以的时候要强转((Source) targetable).takePhoto();多此一举
	 */
    void takePhoto();

    /**
	 * 新的方法
	 */
    void play();

}
