package com.create;

//创建多线程的方法之二
//实现Runnable
class MyThread2 extends Thread{
    private String name;
    public MyThread2(String name){
        this.name = name;
    }
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println(name + "运行， i = " + i);
        }
    }
}

class TestMyThread2{
    public static void main(String[] args) {
        MyThread2 thread3 = new MyThread2("线程C ");
        MyThread2 thread4 = new MyThread2("线程D ");

        thread3.start();
        thread4.start();
    }
}
/*
线程C 运行， i = 0
线程C 运行， i = 1
线程C 运行， i = 2
线程C 运行， i = 3
线程C 运行， i = 4
线程D 运行， i = 0
线程D 运行， i = 1
线程D 运行， i = 2
线程D 运行， i = 3
线程D 运行， i = 4
线程D 运行， i = 5
线程D 运行， i = 6
线程D 运行， i = 7
线程D 运行， i = 8
线程C 运行， i = 5
线程C 运行， i = 6
线程C 运行， i = 7
线程C 运行， i = 8
线程C 运行， i = 9
线程D 运行， i = 9
 */