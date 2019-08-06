package executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new CallableTest());
        executorService.submit(new CallableTest());
        executorService.submit(new CallableTest());
        executorService.shutdown();
        System.out.println("关闭线程池");
        executorService.awaitTermination(10, TimeUnit.MINUTES);
        System.out.println("w我我我");
    }
}


