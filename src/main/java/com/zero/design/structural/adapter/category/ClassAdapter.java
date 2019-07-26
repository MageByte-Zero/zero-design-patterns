package com.zero.design.structural.adapter.category;

/**
 * 这样Targetable接口的实现类就拥有了Source类的功能,并且实现待新增的接口从而拓展了新方法
 * @author unique
 *
 */
public class ClassAdapter extends Source implements Targetable {

	@Override
	public void play() {
		System.out.println("我是Targetable的play()方法");
		
	}

	@Override
	public void takePhoto() {
		super.takePhoto();
	}
}
