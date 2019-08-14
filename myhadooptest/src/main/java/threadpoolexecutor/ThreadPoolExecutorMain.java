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

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 0, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(5), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        threadPoolExecutor.execute(() -> System.out.println("222424"));
        threadPoolExecutor.execute(() -> System.out.println("222424"));
        threadPoolExecutor.execute(() -> System.out.println("222424"));
        threadPoolExecutor.execute(() -> System.out.println("222424"));
        threadPoolExecutor.execute(() -> System.out.println("222424"));
        threadPoolExecutor.execute(() -> System.out.println("222424"));
        threadPoolExecutor.execute(() -> System.out.println("222424"));
        threadPoolExecutor.execute(() -> System.out.println("222424"));
        threadPoolExecutor.execute(() -> System.out.println("222424"));
        threadPoolExecutor.execute(() -> System.out.println("222424"));
        threadPoolExecutor.execute(() -> System.out.println("222424"));
        threadPoolExecutor.execute(() -> System.out.println("222424"));
        threadPoolExecutor.execute(() -> System.out.println("222424"));
        threadPoolExecutor.execute(() -> System.out.println("222424"));
        threadPoolExecutor.execute(() -> System.out.println("222424"));
        threadPoolExecutor.execute(() -> System.out.println("222424"));
        threadPoolExecutor.execute(() -> System.out.println("222424"));
        threadPoolExecutor.execute(() -> System.out.println("222424"));


        threadPoolExecutor.shutdown();
while(true){
    if(threadPoolExecutor.isTerminated()){
        System.out.println("所有的子线程都结束了！");
        break;
    }
    Thread.sleep(1000);

}


    }
}
