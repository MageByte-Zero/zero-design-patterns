package com.zero.design.structural.adapter.objects;

import com.zero.design.structural.adapter.category.Source;
import com.zero.design.structural.adapter.category.Targetable;

/**
 * 即Adapter不是继承Source类，而是持有Source类的实例达到解决兼容性问题。
 * @author unique
 *
 */
public class ObjectAdapter implements Targetable {
	
	private Source source;
	
	public ObjectAdapter(Source source) {
		this.source = source;
	}

	@Override
	public void takePhoto() {
		source.takePhoto();
		
	}

	@Override
	public void play() {
		System.out.println("this is ObjectAdapter.play() method");
		
	}

}
