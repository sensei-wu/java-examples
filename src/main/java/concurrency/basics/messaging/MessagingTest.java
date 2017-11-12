package concurrency.basics.messaging;

public class MessagingTest {
    public static void main(String[] args) {

        MailBox mailBox = new MailBox();
        Producer producer = new Producer(mailBox);
        new Thread(producer).start();
        Consumer consumer = new Consumer(mailBox);
        new Thread(consumer).start();
    }
}
