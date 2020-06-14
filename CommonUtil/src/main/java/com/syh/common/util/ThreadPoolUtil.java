package com.syh.common.util;

import java.util.concurrent.*;

/**
 * @author hsy
 * @version 1.0
 * @date 2019/12/20 13:37
 */
public class ThreadPoolUtil {

    /**
     * 线程池对象
     */
    private ExecutorService threadPool = null;

    /**
     * CPU密集型为true，IO密集型为false；默认为true
     */
    private boolean cpuOrIo = true;

    /**
     * 核心线程数
     */
    private int corePoolSize;

    /**
     * 最大线程数
     */
    private int maximumPoolSize;

    /**
     * 空余线程默认存活时间
     */
    private final static long DEFAULT_KEEP_ALIVE_TIME = 10L;

    /**
     * CPU核数
     */
    private final static int PROCESSORS = Runtime.getRuntime().availableProcessors();

    /**
     * 线程池默认拒绝策略
     */
    private static final RejectedExecutionHandler DEFAULT_HANDLER =
            new ThreadPoolExecutor.AbortPolicy();

    /**
     * <>
     *    初始化线程池对象（线程数根据CPU核数动态设置；空余线程默认存活时间为10s） 
     * </>
     * 
     * @param blockingQueue	阻塞队列
     */
    public ThreadPoolUtil(BlockingQueue<Runnable> blockingQueue){
        setUp(DEFAULT_KEEP_ALIVE_TIME, TimeUnit.SECONDS, blockingQueue);
    }

    /**
     * <p>
     *      初始化线程池对象
     * </p>
     * 
     * @param blockingQueue	阻塞队列
     * @param keepAliveTime	空余线程存活时间
     * @param unit			keepAliveTime的单位
     */
    public ThreadPoolUtil(BlockingQueue<Runnable> blockingQueue,
                          long keepAliveTime,
                          TimeUnit unit){
        setUp(keepAliveTime, unit, blockingQueue);
    }

    /**
     * 初始化线程池对象
     * @param blockingQueue	队列
     * @param threadFactory	生成线程的线程工厂
     * @param handler		拒绝策略
     */
    public ThreadPoolUtil(BlockingQueue<Runnable> blockingQueue,
                          ThreadFactory threadFactory,
                          RejectedExecutionHandler handler){
        setUp(DEFAULT_KEEP_ALIVE_TIME, TimeUnit.SECONDS,
                blockingQueue, threadFactory, handler);
    }

    /**
     * 初始化线程池对象
     * @param blockingQueue	队列
     * @param keepAliveTime	空余线程存活时间
     * @param unit			keepAliveTime的单位
     * @param threadFactory	生成线程的线程工厂
     * @param handler		拒绝策略
     */
    public ThreadPoolUtil(BlockingQueue<Runnable> blockingQueue,
                          long keepAliveTime,
                          TimeUnit unit,
                          ThreadFactory threadFactory,
                          RejectedExecutionHandler handler){
        setUp(keepAliveTime, unit, blockingQueue, threadFactory, handler);
    }

    /**
     * 根据五个参数创建线程池
     * @param keepAliveTime      空余线程存活时间
     * @param unit               keepAliveTime的单位
     * @param workQueue          队列
     */
    private void setUp(long keepAliveTime,
                       TimeUnit unit,
                       BlockingQueue<Runnable> workQueue){
        threadPool = setUp(keepAliveTime,
                unit,
                workQueue,
                Executors.defaultThreadFactory(),
                DEFAULT_HANDLER);
    }

    /**
     * 根据七大参数创建线程池
     * @param keepAliveTime		空余线程存活时间
     * @param unit				keepAliveTime的单位
     * @param workQueue			队列
     * @param threadFactory		创建线程的线程工厂
     * @param handler			拒绝策略
     * @return  {@link ExecutorService}
     */
    private ExecutorService setUp(long keepAliveTime,
                                  TimeUnit unit,
                                  BlockingQueue<Runnable> workQueue,
                                  ThreadFactory threadFactory,
                                  RejectedExecutionHandler handler){
        getCorePoolSize();
        threadPool = new ThreadPoolExecutor(corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                unit,
                workQueue,
                threadFactory,
                handler);
        return threadPool;
    }

    /**
     * <p>
     *     线程池核心线程数
     * </p>
     */
    private void getCorePoolSize() {
        if (cpuOrIo) {
            corePoolSize = PROCESSORS <= 1 ? PROCESSORS : PROCESSORS + 1;
        } else {
            corePoolSize = PROCESSORS <= 1 ? PROCESSORS : PROCESSORS << 1;
        }
        getMaximumPoolSize();
    }

    /**
     * <p>
     *     线程池最大线程数
     * </p>
     */
    private void getMaximumPoolSize() {
        maximumPoolSize = corePoolSize << 1;
    }

    public ExecutorService getThreadPool() {
        return threadPool;
    }
    public void setThreadPool(ExecutorService threadPool) {
        this.threadPool = threadPool;
    }

    public boolean getCpuOrIo() {
        return cpuOrIo;
    }

    public void setCpuOrIo(boolean cpuOrIo) {
        this.cpuOrIo = cpuOrIo;
    }
}
