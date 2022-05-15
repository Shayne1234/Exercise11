package com.company;


    public class MyThreaddd implements Runnable {
    Thread thread;

        MyThreaddd(String name) {
        thread = new Thread(this, name);
    }

    public static MyThreaddd createAndStart(String name) {
        MyThreaddd myThreaddd = new MyThreaddd(name);
        myThreaddd.thread.start();
        return myThreaddd;
    }

    public void run() {
        System.out.println(thread.getName() + "starts to operate");
        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(150);
                System.out.println(thread.getName() + " is executed, the counter value: " + count);
            }

        } catch (InterruptedException e) {
            System.out.println(thread.getName() + " has been interrupted");

        }
        System.out.println(thread.getName() + " finishes running");

    }

}

    class Task1 {
        public static void main(String[] args) {
            System.out.println("The main thread starts running");

            MyThreaddd myThread1 = MyThreaddd.createAndStart("Child thread #1");
            MyThreaddd myThread2 = MyThreaddd.createAndStart("Child thread #2");
            MyThreaddd myThread3 = MyThreaddd.createAndStart("Child thread #3");

        /*do {
            System.out.println(".");
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                System.out.println("The main thread has been terminated");
            }
        }while (myThread1.thread.isAlive() || myThread2.thread.isAlive() || myThread3.thread.isAlive());
            System.out.println("The main thread is exiting");*/


            try {
                myThread1.thread.join();
                myThread2.thread.join();
                myThread3.thread.join();
            } catch (InterruptedException e) {
                System.out.println("The thread has terminated" + e);

            }


        }
    }
