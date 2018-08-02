package basics;

public class MyServiceClient {

    public static void main(String[] args) {
        MyService myService1 = MyServiceImpl.DOG;

        for (int i = 0; i < 1000; i++) {
            MyService myService = MyServiceImpl.CAT;
            myService.cry();
        }

        System.out.println(ExpensiveObject.counter);
    }
}
