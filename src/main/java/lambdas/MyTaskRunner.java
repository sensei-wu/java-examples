package lambdas;

public class MyTaskRunner {
    public static void main(String[] args) {
        //pre Java 8
        MyTask aTask = new MyTask();
        aTask.run();

        Runnable anotherTask = new Runnable() {
            @Override
            public void run() {
                System.out.println("Do nothing");
            }
        };
        anotherTask.run();

        //Java 8
        Runnable aLambdaTask = () -> System.out.println("I will do a lambda job");
        aLambdaTask.run();
    }
}
