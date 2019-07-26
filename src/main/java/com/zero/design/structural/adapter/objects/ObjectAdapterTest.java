package com.zero.design.structural.adapter.objects;

import com.zero.design.structural.adapter.category.Source;
import com.zero.design.structural.adapter.category.Targetable;

public class ObjectAdapterTest {

	public static void main(String[] args) {
		Source source = new Source();
		Targetable targetable = new ObjectAdapter(source);
		targetable.takePhoto();
		targetable.play();

	}

}
