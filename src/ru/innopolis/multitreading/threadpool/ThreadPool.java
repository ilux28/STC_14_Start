package ru.innopolis.multitreading.threadpool;

import java.util.LinkedList;
import java.util.List;

public class ThreadPool {
    private final List<Thread> threads = new LinkedList<>();
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>();
    private final int nThreads;

    public ThreadPool() {
        this.nThreads = Runtime.getRuntime().availableProcessors(); //the quantity core of processor
        for (int i = 0; i < nThreads; i++) {
            String nameThread = String.valueOf(i);
            threads.add(new MyThread(nameThread));
            threads.get(i).start();
        }

    }

    /**
     * This method added task in blocking queue, when job added in tasks,
     * all threads a wakeup
     *
     * @param job - task
     * @throws InterruptedException
     */
    public void work(Runnable job) throws InterruptedException {
        tasks.offer(job);
        tasks.notifyAll();
    }

    public void shutdown() throws InterruptedException {
        tasks.poll();
    }
}
