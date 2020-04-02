package com.create;

//创建多线程的方法之一
//实现Runnable接口
class MyThread implements Runnable{

    private String name; //表示线程的名称

    public MyThread(String name){
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name + "运行， i = " + i);
        }
    }
}

class TestMyThread{
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread("线程A ");  //实例化对象
        MyThread myThread2 = new MyThread("线程B ");  //实例化对象

        Thread t1 = new Thread(myThread1);   //实例化Thread类对象
        Thread t2 = new Thread(myThread2);   //实例化Thread类对象

        t1.start();    //启动多线程
        t2.start();   //启动多线程
    }
}
/**
 * 线程A 运行， i = 0
 * 线程A 运行， i = 1
 * 线程A 运行， i = 2
 * 线程B 运行， i = 0
 * 线程B 运行， i = 1
 * 线程B 运行， i = 2
 * 线程B 运行， i = 3
 * 线程B 运行， i = 4
 * 线程B 运行， i = 5
 * 线程B 运行， i = 6
 * 线程B 运行， i = 7
 * 线程B 运行， i = 8
 * 线程B 运行， i = 9
 * 线程A 运行， i = 3
 * 线程A 运行， i = 4
 * 线程A 运行， i = 5
 * 线程A 运行， i = 6
 * 线程A 运行， i = 7
 * 线程A 运行， i = 8
 * 线程A 运行， i = 9
 */
