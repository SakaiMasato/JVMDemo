package com.bob.java;

import sun.security.ec.CurveDB;

import java.net.URL;
import java.security.Provider;

public class ClassLoaderTest1 {
    public static void main(String[] args) {
        System.out.println("**********启动类加载器*************");
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls){
            System.out.println(url.toExternalForm());
        }

        //从上面路径中随意选择一个类，看看他的类加载器是什么。
        ClassLoader tmpClsLoader = Provider.class.getClassLoader();
        System.out.println(tmpClsLoader); //null //是引导类加载器

        System.out.println("**************扩展类加载器*****************");
        String extClsLoaderDirs = System.getProperty("java.ext.dirs");
        for (String extClsLoader : extClsLoaderDirs.split(";")) {
            System.out.println(extClsLoader);
        }
        
        tmpClsLoader = CurveDB.class.getClassLoader();
        System.out.println(tmpClsLoader);//sun.misc.Launcher$ExtClassLoader@4b67cf4d
        
    }
}
