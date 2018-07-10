package com.nowcoder;

/**
 * Created with IDEA
 *
 * @author duzhentong
 * @Date 2018/7/9
 * @Time 21:52
 */
public class DeadLockTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(new DeadLock(true));
        Thread t2 = new Thread(new DeadLock(false));
        t1.start();
        t2.start();
    }
}

class DeadLock implements Runnable {

    private static Object o1 = new Object();
    private static Object o2 = new Object();
    private boolean isDead;

    public DeadLock(boolean isDaad) {
        this.isDead = isDaad;
    }
    @Override
    public void run() {

        if (this.isDead) {
            synchronized (o1) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("lock");
                }
            }
        } else {
            synchronized (o2) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("lock");
                }
            }
        }
    }
}
