package concurrency;

import java.time.Instant;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class RawThreadTests {

    public static void main(String[] args) {

        printThreadInfo(1);

        Foo foor = new Foo(1);

        foor.run();

        for (int i = 0; i < 5; i++) {
            new Thread(foor).start();
        }

        for (int i = 0; i < 5; i++) {
            FutureTask<String> future = new FutureTask<>(new FooWithReturn(1));
            new Thread(future).start();
        }
    }

    private static void printThreadInfo(int i) {
        System.out.println(String.format("On thread %s, %s at %s from instance %d",
                Thread.currentThread().getId(), Thread.currentThread().getName(), Instant.now().toString(), i));
    }

    private static class Foo implements Runnable {

        private int instanceId;

        public Foo(int instanceId) {
            this.instanceId = instanceId;
        }

        @Override
        public void run() {
            printThreadInfo(instanceId);
        }
    }

    private static class FooWithReturn implements Callable<String> {

        private int instanceId;

        public FooWithReturn(int instanceId) {
            this.instanceId = instanceId;
        }

        @Override
        public String call() throws Exception {
            printThreadInfo(instanceId);
            return null;
        }
    }
}
