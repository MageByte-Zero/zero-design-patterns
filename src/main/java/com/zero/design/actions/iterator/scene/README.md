## 举例说明
爆炸性新闻：对象村餐厅和对象村煎饼屋合并了！
真是个好消息！现在我们可以在同一个地方，享用煎饼屋美味的煎饼早餐，和好吃的餐厅午餐了。但是，好像有一点小麻烦：
新的餐厅想用煎饼屋菜单当作早餐的菜单，使用餐厅的菜单当做午餐的菜单，大家都同意了这样实现菜单项。但是大家无法同意菜单的实现。煎饼屋使用
ArrayList记录他的菜单项，而餐厅使用的是数组。他们两个都不愿意改变他们的实现，毕竟有太多代码依赖于它们了。


## 迭代器模式提供一种方法顺序访问一个聚合对象中的各个元素，而又不暴露其内部的表示。

想了解为什么有两种不同的菜单表现方式会让事情变得复杂化，让我们试着实现一个同时使用这两个菜单的客户代码。假设你已经被两个餐厅合租的新公司
雇用，你的工作是创建一个Java版本的女招待，她能应对顾客的需要打印定制的菜单，甚至告诉你是否某个菜单项是素食的，而无需询问厨师。跟我们来看
看这份关于女招待的规格，然后看看如何实现她。

## Java版本的女招待规格：
* printMenu():	打印出菜单上的每一项
* printBreakfastMenu():	只打印早餐项
* printLunchMenu():	只打印午餐项
* printVegetarianMenu():	打印所有的素食菜单项
* isItemVegetarian(name):	指定项的名称，如果该项是素食，返回true，否则返回false
   我们先从实现printMenu()方法开始：
1. 打印每份菜单上的所有项，必须调用PancakeHouseMenu和DinnerMenu的getMenuItems()方法，来取得它们各自的菜单项。请注意，两者的返回类型
是不一样的。
2. 代码
```
public void printMenu(){
// 现在，我们必须实现两个不同的循环，个别处理这两个不同的菜单
        for (int i = 0; i < breakfastItems.size(); i++) {
            MenuItem menuItem = (MenuItem) breakfastItems.get(i);
            System.out.print(menuItem.getName() + " ");
            System.out.print(menuItem.getPrice() + " ");
            System.out.println(menuItem.getDescription() + " ");
        }

        for (int i = 0; i < lunchItems.length; i++) {
            MenuItem menuItem = lunchItems[i];
            System.out.print(menuItem.getName() + " ");
            System.out.print(menuItem.getPrice() + " ");
            System.out.println(menuItem.getDescription() + " ");
        }
    }
```

3. 实现女招待中的其他方法，做法也都和这里的方法相类似。我们总是需要处理两个菜单，并且用两个循环遍历这些项。如果还有第三家餐厅以不同的实现出现，
我们就需要有三个循环。
4. 现在我们创建一个对象，把它称为迭代器(Iterator)，利用它来封装“遍历集合内的每个对象的过程”