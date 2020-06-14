package com.syh.common.threadPool;

import com.syh.common.util.ThreadPoolUtil;
import lombok.SneakyThrows;
import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * ThreadPoolUtilTest
 *
 * @author HSY
 * @since 2020/06/14 23:02
 */

public class ThreadPoolUtilTest {

    /**
     * 线程池
     */
    private static ExecutorService threadPool;

    private void initThreadPool() {
        if (threadPool == null) {
            synchronized (this) {
                if (threadPool == null) {
                    threadPool = new ThreadPoolUtil(new ArrayBlockingQueue<>(20000)).getThreadPool();
                }
            }
        }
    }
    @Test
    public void threadPoolTest() {
        initThreadPool();
        for (int i = 0; i < 10000; i++) {
            threadPool.execute(new ThreadTest());
        }
    }
}
class ThreadTest extends Thread {

    @SneakyThrows
    @Override
    public void run () {
        System.out.println("threadName: " + this.getName());
    }
}
