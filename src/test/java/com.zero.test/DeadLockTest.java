package com.zero.test;

public class DeadLockTest {
    public static void main(String[] args) {
        final Object a = new Object();
        final Object b = new Object();
        Thread threadA = new Thread(() -> {
            synchronized (a) {
                try {
                    System.out.println("now i in threadA-lockA");
                    Thread.sleep(1000L);
                    synchronized (b) {
                        System.out.println("now i in threadA-lockB");
                    }
                } catch (Exception e) {
                    // ignore
                }
            }
        });

        Thread threadB = new Thread(() -> {
            synchronized (b) {
                try {
                    System.out.println("now i in threadB-lockB");
                    Thread.sleep(1000L);
                    synchronized (a) {
                        System.out.println("now i in threadB-lockA");
                    }
                } catch (Exception e) {
                    // ignore
                }
            }
        });

        threadA.start();
        threadB.start();
    }

}
