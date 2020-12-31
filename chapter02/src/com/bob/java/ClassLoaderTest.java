package com.bob.java;

public class ClassLoaderTest {
    public static void main(String[] args) {
        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);  //sun.misc.Launcher$AppClassLoader@18b4aac2

        //获取其上层，扩展类加载器
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader); //sun.misc.Launcher$ExtClassLoader@4554617c

        //获取其上层
        ClassLoader bootStrapClassLoader = extClassLoader.getParent();
        System.out.println(bootStrapClassLoader);   //null   //引导类加载器无法直接获取

        //对于用户自定义的加载器, 默认使用系统类加载器
        ClassLoader customClassLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(customClassLoader);  //sun.misc.Launcher$AppClassLoader@18b4aac2

        //String类使用引导类加载器(BootStrap), ---> java的核心类库都是使用引导类加载器
        ClassLoader strClassLoader = String.class.getClassLoader();
        System.out.println(strClassLoader); //null


    }
}