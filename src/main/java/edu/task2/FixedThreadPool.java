package edu.task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public final class FixedThreadPool implements ThreadPool {

    private final BlockingQueue<Runnable> tasks;
    private final Worker[] threads;
    private final AtomicBoolean isShutdown;

    private FixedThreadPool(int numberOfThreads) {
        if (numberOfThreads <= 0) {
            throw new IllegalArgumentException("Number of threads should be > 0");
        }
        this.threads = new Worker[numberOfThreads];
        this.tasks = new LinkedBlockingQueue<>();
        this.isShutdown = new AtomicBoolean(false);
        start();
    }

    public static FixedThreadPool create(int numberOfThreads) {
        return new FixedThreadPool(numberOfThreads);
    }

    @Override
    public void start() {
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Worker();
            threads[i].start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        if (!isShutdown.get()) {
            tasks.offer(runnable);
        }
    }

    @Override
    public void close() {
        isShutdown.set(true);
        for (Worker worker : threads) {
            worker.interrupt();
        }
    }

    private final class Worker extends Thread {

        @Override
        public void run() {
            while (!(isShutdown.get() && tasks.isEmpty())) {
                Runnable task = tasks.poll();
                if (task != null) {
                    task.run();
                }
            }
        }
    }
}
