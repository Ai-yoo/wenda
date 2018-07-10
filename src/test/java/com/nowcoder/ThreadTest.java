package com.nowcoder;

import java.util.concurrent.*;

/**
 * Created with IDEA
 *
 * @author duzhentong
 * @Date 2018/7/10
 * @Time 7:31
 */
public class ThreadTest {

    public static void main(String[] args) {
        //testBlockingQueue();
//        threadPool();
        testFuture();
    }

    public static void testFuture() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Integer> future = service.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(1000);
                return 1;
            }
        });
        service.shutdown();
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
    public static void testBlockingQueue() {
        BlockingQueue queue = new ArrayBlockingQueue(10);
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue), "Consumer1").start();
        new Thread(new Consumer(queue), "Consumer2").start();

    }

    /**
     * 使用线 程池顺序打印变量
     */
    public static void threadPool() {
        //指定线程池中的数量
        ExecutorService e = Executors.newFixedThreadPool(2);
        //单线程
//        ExecutorService e = Executors.newSingleThreadExecutor();
        e.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(1000);
                        System.out.println("e1:" + i);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }

                }
            }
        });
        e.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(1000);
                        System.out.println("e2:" + i);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        e.shutdown();
        while (!e.isTerminated()) {
            try {
                Thread.sleep(1000);
                System.out.println("Wait for terminat");
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }

        }
    }

}

/**
 * 消费者
 */
class Consumer implements Runnable {

    private BlockingQueue<String> queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(Thread.currentThread().getName() + ":" + queue.take());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**
 * 生产者
 */
class Producer implements Runnable {

    private BlockingQueue queue;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(10);
                queue.put(String.valueOf(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
