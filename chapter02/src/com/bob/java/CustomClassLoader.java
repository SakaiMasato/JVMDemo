package com.bob.java;

import java.io.FileNotFoundException;

/**
 * 没有太复杂的逻辑，继承URLClassLoader.不用重写findClass方法
 */
public class CustomClassLoader extends ClassLoader{
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] result = getClassFromCustomPath(name);
            if(result == null){
                throw new FileNotFoundException();
            }else{
                return defineClass(name, result,0, result.length);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        throw new ClassNotFoundException(name);
    }

    private byte[] getClassFromCustomPath(String name){
        //Todo
        return null;
    }


    public static void main(String[] args){
        CustomClassLoader custClsLoader = new CustomClassLoader();
        try {
            Class<?> cls = Class.forName("one", true, custClsLoader);
            Object obj = cls.newInstance();
            System.out.println(obj.getClass().getClassLoader());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
