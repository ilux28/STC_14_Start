package ru.innopolis.multitreading.threadpool;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * The Class blocking queue
 * @param <T>
 */
public class SimpleBlockingQueue<T> {
    private List<T> queue = new LinkedList<>();
    private int limit = 10;
    public SimpleBlockingQueue() {

    }
    public SimpleBlockingQueue(int limit){
        this.limit = limit;
    }
    /**
     * This method offer() the put in queue when element in queue exist place,
     * and not put when queue is busy
     * @param value type of T
     */
    public synchronized void offer(T value) throws InterruptedException{
        while (this.queue.size() == this.limit) {
            wait();
        }
        if (this.queue.size() == 0) {
            notifyAll();
        }
        this.queue.add(value);
    }
    /**
     * @return
     * @throws InterruptedException
     */
    public synchronized T poll() throws InterruptedException{
        while (this.queue.size() == 0) {
            wait();
        }
        if (this.queue.size() == this.limit) {
            notifyAll();
        }
        return this.queue.remove(0);
    }
    public synchronized int getSize() {
        return this.queue.size();
    }
}
