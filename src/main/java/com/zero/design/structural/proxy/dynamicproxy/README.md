# 代理模式(Proxy)动态代理
## 作用
Java动态代理类位于Java.lang.reflect包下，一般主要涉及到以下两个类：
 
(1). Interface InvocationHandler：该接口中仅定义了一个方法Object：invoke(Objectobj,Method method, Object[] args)。
在实际使用时，第一个参数obj一般是指代理类，method是被代理的方法，如上例中的request()，args为该方法的参数数组。这个抽象方法
在代理类中动态实现。
 
(2).Proxy：该类即为动态代理类，作用类似于上例中的ProxySubject，其中主要包含以下内容：
Protected Proxy(InvocationHandler h)：构造函数，估计用于给内部的h赋值。
 
Static Class getProxyClass (ClassLoaderloader, Class[] interfaces)：获得一个代理类，其中loader是类装载器，interfaces
是真实类所拥有的全部接口的数组。
 
Static Object newProxyInstance(ClassLoaderloader, Class[] interfaces, InvocationHandler h)：返回代理类的一个实例，
返回后的代理类可以当作被代理类使用(可使用被代理类的在Subject接口中声明过的方法)。
 
所谓Dynamic Proxy是这样一种class：它是在运行时生成的class，在生成它时你必须提供一组interface给它，然后该class就宣称它实现了
这些interface。你当然可以把该class的实例当作这些interface中的任何一个来用。当然啦，这个DynamicProxy其实就是一个Proxy，它不
会替你作实质性的工作，在生成它的实例时你必须提供一个handler，由它接管实际的工作。

通过这种方式，被代理的对象(RealSubject)可以在运行时动态改变，需要控制的接口(Subject接口)可以在运行时改变，控制的方式(DynamicSubject类)
也可以动态改变，从而实现了非常灵活的动态代理关系

## 1.3.代理模式使用原因和应用方面
    
   （1）授权机制不同级别的用户对同一对象拥有不同的访问权利,如Jive论坛系统中,就使用Proxy进行授权机制控制,访问论坛有两种人:注册用户和游客
   (未注册用户),Jive中就通过类似ForumProxy这样的代理来控制这两种用户对论坛的访问权限.
    
   （2）某个客户端不能直接操作到某个对象,但又必须和那个对象有所互动.
        举例两个具体情况:
        如果那个对象是一个是很大的图片,需要花费很长时间才能显示出来,那么当这个图片包含在文档中时,使用编辑器或浏览器打开这个文档,打开文档
        必须很迅速,不能等待大图片处理完成,这时需要做个图片Proxy来代替真正的图片.
       
        如果那个对象在Internet的某个远端服务器上,直接操作这个对象因为网络速度原因可能比较慢,那我们可以先用Proxy来代替那个对象.
    
        总之原则是,对于开销很大的对象,只有在使用它时才创建,这个原则可以为我们节省很多宝贵的Java内存. 所以,有些人认为Java耗费资源内存,
        我以为这和程序编制思路也有一定的关系.
    
   （3）现实中，Proxy应用范围很广,现在流行的分布计算方式RMI和Corba等都是Proxy模式的应用
    
    
   
   
   
