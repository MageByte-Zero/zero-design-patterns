package com.zero.design.actions.iterator.scene;

import java.util.Iterator;

// 餐厅的菜单实现
public class DinnerMenu implements IMenu {
    // 餐厅采用使用的是数组，所以可以控制菜单的长度，
    // 并且在取出菜单项时，不需要转型
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    private MenuItem[] menuItems;
 
    public DinnerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];
 
        // 和煎饼屋一样，餐厅使用addItem()辅助方法在构造器中创建菜单项的
        addItem("Vegetarian BLT",
                "(Fakin') Bacon with lettuce & tomato on whole wheat",
                true,
                2.99);
        addItem("BLT",
                "Bacon with lettuce & tomato on whole wheat",
                false,
                2.99);
        addItem("Soup of the day",
                "Soup of the day, with a side of potato salad",
                false,
                3.29);
        addItem("Hotdog",
                "A hot dog, with saurkraut, relish, onions, topped with cheese",
                false,
                3.05);
    }
 
    public void addItem(String name, String description,
                        boolean vegetarian, double price) {
        // 餐厅坚持让菜单保持在一定的长度之内
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        if (numberOfItems >= MAX_ITEMS) {
            System.err.println("Sorry, menu is full! Can't add item to menu");
        } else {
            menuItems[numberOfItems] = menuItem;
            numberOfItems = numberOfItems + 1;
        }
    }
 
    // getMenuItems()返回一个菜单项的数组
    public MenuItem[] getMenuItems() {
        return menuItems;
    }
 
    // 正如煎饼屋那样，这里还有很多其他的菜单代码依赖于这个数组
    // ...


    // 我们不再需要getMenuItems()方法，事实上，我们根本不想要这个方法，
    // 因为它会暴露我们内部的实现。
    // 这是createIterator()方法，用来从菜单项数组创建一个DinnerMenuIterator，
    // 并将它返回给客户
    @Override
    public Iterator createIterator() {
        return new DinnerMenuIterator(menuItems);
    }
}