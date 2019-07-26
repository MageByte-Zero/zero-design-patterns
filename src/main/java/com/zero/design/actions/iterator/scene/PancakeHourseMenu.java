package com.zero.design.actions.iterator.scene;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 煎饼屋餐厅的菜单实现
 * Created by ljq97 on 2017/6/19.
 */
public class PancakeHourseMenu implements IMenu {

    /**
     * 煎饼屋使用
     */
    private ArrayList<MenuItem> menuItems;

    public PancakeHourseMenu() {
        menuItems = new ArrayList();

        // 在菜单的构造器中，每一个菜单项都会被加入到ArrayList中
        // 每个菜单项都有一个名称、一个描述、是否为素食、还有价格
        addItem("K&B's Pancake Breakfast",
                "Pancakes with scrambled eggs, and toast",
                true,
                2.99);

        addItem("Regular Pancake Breakfast",
                "Pancakes with fried eggs, sausage",
                false,
                2.99);

        addItem("Blueberry Pancakes",
                "Pancakes made with fresh blueberries",
                true,
                3.49);

        addItem("Waffles",
                "Waffles, with your choice of blueberries or strawberries",
                true,
                3.59);
    }

    // 要加入一个菜单项，煎饼屋的做法是创建一个新的菜单项对象，
    // 传入每一个变量，然后将它加入ArrayList中
    public void addItem(String name, String description,
                        boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }

    // 这个方法返回菜单项列表
    public ArrayList getMenuItems() {
        return menuItems;
    }
    // 这里还有菜单的其他方法，这些方法都依赖于这个ArrayList，所以煎饼屋不希望重写全部的代码！
    // ...

    @Override
    public Iterator createIterator() {
        //只需要删除煎饼屋菜单迭代器
//        return new BreakFastMenuIterator(menuItems);
        return menuItems.iterator();
    }

}
