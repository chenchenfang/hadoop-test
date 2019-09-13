package executorservice;

import java.util.Random;
import java.util.concurrent.Callable;

public class CallableTest implements Callable<String> {
    @Override
    public String call() throws Exception {
        Random random = new Random();
        int i = random.nextInt(1000 * 7);
        Thread.sleep(i);
        return null;
    }
}
