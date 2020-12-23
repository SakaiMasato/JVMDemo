package com.bob.java;

//一个线程开始初始化的时候会给clinit方法自动加锁
public class DeadThreadTest {
    public static void main(String[] args){
        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName() + "开始");
            DeadThread deadThread = new DeadThread();
            System.out.println(Thread.currentThread().getName() + "结束");
        };

        Thread t1 = new Thread(r,"线程1");
        Thread t2 = new Thread(r,"线程2");

        t1.start();
        t2.start();

    }


}

class DeadThread {
    static {
        if(true) {
            System.out.println(Thread.currentThread().getName() + "初始化当前类");
            while (true) {}
        }
    }

}
