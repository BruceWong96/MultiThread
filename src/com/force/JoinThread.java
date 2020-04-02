package com.force;
/*
* 线程的强制执行
* 在线程的操作中，可以使用join()方法让一个线程强制执行
* 线程强制运行期间，其他线程无法运行
* 必须等待此线程完成之后才可以继续执行
*
* */
class MyThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            //取得当前线程的名字
            System.out.println(Thread.currentThread().getName() + "运行， i = " + i);
        }
    }
}

public class JoinThread {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread t = new Thread(myThread, "我的自定义线程");
        t.start();

        for (int i = 0; i < 20; i++) {
            if (i > 6){
                try {
                    t.join();  //线程强制执行
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Main线程运行 i = " + i);
        }

    }
}
/*
* Main线程运行 i = 0
Main线程运行 i = 1
Main线程运行 i = 2
Main线程运行 i = 3
Main线程运行 i = 4
Main线程运行 i = 5
Main线程运行 i = 6
我的自定义线程运行， i = 0
我的自定义线程运行， i = 1
我的自定义线程运行， i = 2
我的自定义线程运行， i = 3
我的自定义线程运行， i = 4
我的自定义线程运行， i = 5
我的自定义线程运行， i = 6
我的自定义线程运行， i = 7
我的自定义线程运行， i = 8
我的自定义线程运行， i = 9
我的自定义线程运行， i = 10
我的自定义线程运行， i = 11
我的自定义线程运行， i = 12
我的自定义线程运行， i = 13
我的自定义线程运行， i = 14
我的自定义线程运行， i = 15
我的自定义线程运行， i = 16
我的自定义线程运行， i = 17
我的自定义线程运行， i = 18
我的自定义线程运行， i = 19
Main线程运行 i = 7
Main线程运行 i = 8
Main线程运行 i = 9
Main线程运行 i = 10
Main线程运行 i = 11
Main线程运行 i = 12
Main线程运行 i = 13
Main线程运行 i = 14
Main线程运行 i = 15
Main线程运行 i = 16
Main线程运行 i = 17
Main线程运行 i = 18
Main线程运行 i = 19
*/