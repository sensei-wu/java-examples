package java8.lambdas;

public class MyTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Running a tough job");
    }
}
