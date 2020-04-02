package com.deadlock;

class Zhangsan{
    public void say(){
        System.out.println("张三对李四说：“你给我钱，我就把书给你！”");
    }
    public void get(){
        System.out.println("张三得到钱了");
    }
}

class Lisi{
    public void say(){
        System.out.println("李四对张三说：”你给我书，我就把钱给你！“");
    }
    public void get(){
        System.out.println("李四得到书了");
    }
}

public class ThreadDeadLock implements Runnable{

    private static Zhangsan zhangsan = new Zhangsan();
    private static Lisi lisi = new Lisi();
    private boolean flag = false;     //声明标志位

    @Override
    public void run() {
        if (flag){
            synchronized (zhangsan){
                zhangsan.say();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lisi){
                    zhangsan.get();
                }
            }
        }else {
            synchronized (lisi){
                lisi.say();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (zhangsan){
                    lisi.get();
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadDeadLock t1 = new ThreadDeadLock();
        ThreadDeadLock t2 = new ThreadDeadLock();
        t1.flag = true;
        t2.flag = false;

        Thread threadA = new Thread(t1);
        Thread threadB = new Thread(t2);

        threadA.start();
        threadB.start();

    }
}
