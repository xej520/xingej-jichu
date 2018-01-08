package com.xingej.defineproxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 自定义classLoader， 类加载我们制定的路径，避开父委托机制，
 * 
 * 我们的目的是将打乱顺序数的字节码还原之后，调用实例，方法
 * 
 * 暗含类字节加密的方法
 * 
 * @author erjun 2017年12月31日 下午6:47:31
 */
public class MyClassLoader extends ClassLoader {
    private File dir;

    public MyClassLoader(String classDir) {
        this.dir = new File(classDir);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        
        try {
            if (null != dir) {
                File clazzFile = new File(dir, name + ".class");
                if (clazzFile.exists()) {
                    FileInputStream fis = new FileInputStream(clazzFile);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    
                    byte[] buffer = new byte[1024];
                    
                    int len;
                    
                    while((len = fis.read(buffer))!= -1){
                        baos.write(buffer, 0, len);
                    }
                    
                    
                    fis.close();

                    // 返回Class的实例
                    // 第一个参数，不知道是啥，所以，给了一个null；没事，不影响
                    return defineClass("com.xingej.defineproxy."+name, baos.toByteArray(),0,baos.size());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        
      
        return null;
    }

}
