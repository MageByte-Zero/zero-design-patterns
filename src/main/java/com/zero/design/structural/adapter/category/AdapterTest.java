package com.zero.design.structural.adapter.category;

public class AdapterTest {

	public static void main(String[] args) {
		Targetable targetable = new ClassAdapter();
		targetable.takePhoto();
		targetable.play();

	}

}
