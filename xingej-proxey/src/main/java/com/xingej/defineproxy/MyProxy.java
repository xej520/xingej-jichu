package com.xingej.defineproxy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Objects;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/**
 * 替换JDK给我们配的代理对象
 * 
 * @author erjun 2018年1月4日 下午4:31:24
 */
public class MyProxy {
    protected MyInvocationHandler h;

    // 定义一个回车键
    static String rt = "\r\t";

    private MyProxy() {
    }

    protected MyProxy(MyInvocationHandler h) {
        this.h = h;
    }

    // 创建一个内存当中的$Proxy4实例
    public static Object createProxyInstance(ClassLoader loader, Class interf, MyInvocationHandler h) throws Exception {

        // 进行校验
        Objects.requireNonNull(h);

        // 实际运行这个动态代理类构造一个java对象
        System.out.println("-----自定义：类构造一个代理的java对象------");
        // 这里的interf，其实就是指Person接口，这样的话，就可以拿到里面的方法了
        Method[] methods = interf.getMethods();

        // 要将这个对象，构建到com.xingej.defineproxy;这个包里
        String proxyClassString = "package com.xingej.defineproxy;" + rt + "import java.lang.reflect.Method;" + rt
                + "public class $Proxy4 implements " + interf.getName() // 得到是Person
                + "{" + rt + "MyInvocationHandler h;" + rt + "public $Proxy4(MyInvocationHandler h) {" + rt
                + "this.h = h;" + rt + "}" + rt + getMethodString(methods, interf) + rt + "};";

        // 将我们构造的自定义代理类，转换成文件
        String filePath = "E:\\Project\\xingej\\xingej-jichu\\xingej-proxey\\src\\main\\java\\com\\xingej\\defineproxy";
        String fileName = filePath + "\\$Proxy4.java";

        File file = new File(fileName);

        FileWriter fw = new FileWriter(file);

        fw.write(proxyClassString);

        fw.flush();

        fw.close();

        // 开始编译Proxy0.java文件
        // 获取系统编译器
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> units = fileManager.getJavaFileObjects(fileName);

        // 编译这个任务
        CompilationTask compilationTask = compiler.getTask(null, fileManager, null, null, null, units);
        compilationTask.call();

        fileManager.close();

        // 编译完后, 删除.java文件
        file.delete();

        // 编译后，就是一个字节文件，class文件
        // 那么接下来，我们把这个class文件，加载到内存里
        // 通过自定义的类加载器，进行加载
        MyClassLoader loader2 = new MyClassLoader(filePath);

        Class<?> proxy0Class = loader2.findClass("$Proxy4");
        
        // 将.class文件加载到内存后，删除.class文件
        // 这样，内存里，即没有.java和.class文件
        
        // 就跟JDK动态代理方式一样了
        File clazzFile = new File(filePath + "$Proxy4" + ".class");

        if (clazzFile.exists()) {
            clazzFile.delete();
        }

        Constructor<?> constructor = proxy0Class.getConstructor(MyInvocationHandler.class);

        Object object = constructor.newInstance(h);

        return object;
    }

    // 实现的方法
    private static String getMethodString(Method[] methods, Class interf) {
        String proxyMe = "";

        for (Method method : methods) {
            proxyMe += "public void " + method.getName() + "() throws Throwable {" + rt + "Method md = "
                    + interf.getName() + ".class.getMethod(\"" + method.getName() + "\",new Class[]{});" + rt
                    + " this.h.invoke(this, md, null);" + rt + "}" + rt;
        }

        System.out.println("--------自定义的方法----proxyMe----:\n" + proxyMe);

        return proxyMe;
    }

}
