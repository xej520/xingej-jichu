package com.xingej.proxy;

import java.io.FileOutputStream;
import java.lang.reflect.Proxy;

import org.junit.Test;

import com.xingej.common.utils.PropertiesUtil;

import sun.misc.ProxyGenerator;   


public class ProxyHandlerTest {
    
    @Test
    public void test() throws Throwable{
        //创建一个被代理对象
        Person person = new ZhangSan();
        
        //创建代理对象
        //说明：处理类是可以动态变化的，
        //从而使得，代理对象，也再不断变化
        // 也就是说，前两个参数是固定的，
        // 第3个参数可以动态变化，如通过配置文件读取
        //java程序，分为：编码器，编译器，运行器
        //其中，下面的语句，动态代理，是在运行器的，因此，我们根本看不到的
        Person proxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, 
                new ProxyHandler(person));
        
        //说明，proxy是代理对象，代理person
        // 或者你可以这么认为
        // person是演员，而proxy是经纪人
       
        proxy.eat();
    }
    
    @Test
    public void test2() throws Throwable{
        //创建一个被代理对象

        String className = PropertiesUtil.getValue("className");
        System.out.println("---className----:\t" + "com.xingej.proxy." + className);
        
        //利用反射，创建对象
        Person person = (Person) Class.forName("com.xingej.proxy." + className).newInstance();
        
        //创建代理对象
        //说明：处理类是可以动态变化的，
        //从而使得，代理对象，也再不断变化
        // 也就是说，前两个参数是固定的，第3个参数
        Person proxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, 
                new ProxyHandler(person));
        
        // 说明，proxy是代理对象，代理person
        // 或者你可以这么认为
        // person是演员，而proxy是经纪人
       
        proxy.eat();
    }
    
    //获取，运行时期，产生的代理对象，并保存到指定的目录
    @Test
    public void test3() throws Throwable{
        //创建一个被代理对象
        Person person = new ZhangSan();
        
        //java程序，分为：编码器，编译器，运行器
        //其中，下面的语句，动态代理，是在运行器的，因此，我们根本看不到的
        Person proxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, 
                new ProxyHandler(person));
        
        //说明，proxy是代理对象，代理person
        // 或者你可以这么认为
        // person是演员，而proxy是经纪人
       
        proxy.eat();
        
        //打印输出的是com.sun.proxy.$Proxy4
        //可见，代理对象的类型，并不是Person,
        //因为，代理对象也实现了Person的接口，因此，可以调用eat等方法
        //代理对象，在内存中的名字是$Proxy4
        //下面，创建一个方法，createProxyClassFile()来获取该字节数组
        System.out.println("---->:\t"+  proxy.getClass().getName()); //com.sun.proxy.$Proxy4

        //将运行时期的动态代理对象，保存到项目路径下面去
        createProxyClassFile();
        
    }
    
    private static void createProxyClassFile(){
        byte[] bys= ProxyGenerator.generateProxyClass("$Proxy4", new Class[]{Person.class});
        
        //字节数组通过流的形式保存到项目文件中
        try {
            FileOutputStream fos = new FileOutputStream("$Proxy4.class");
            
            fos.write(bys);
            
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
