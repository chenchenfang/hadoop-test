package threadpoolexecutor;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorMain {
    public static void main(String[] args) throws InterruptedException {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 1000L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(10), namedThreadFactory, new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(() ->{ System.out.println("222424");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        }

        threadPoolExecutor.shutdown();




            int queueSize = threadPoolExecutor.getQueue().size();
            System.out.println("当前排队线程数：" + queueSize);

            int activeCount = threadPoolExecutor.getActiveCount();
            System.out.println("当前活动线程数：" + activeCount);

            long completedTaskCount = threadPoolExecutor.getCompletedTaskCount();
            System.out.println("执行完成线程数：" + completedTaskCount);

            long taskCount = threadPoolExecutor.getTaskCount();
            System.out.println("总线程数：" + taskCount);
            /*Thread.sleep(3000);*/



        /*threadPoolExecutor.shutdown();*/

        /*System.out.println();
        System.out.println(threadPoolExecutor.awaitTermination(1000, TimeUnit.MILLISECONDS));*/


    }
}
