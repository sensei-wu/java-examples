package concurrency.basics.messaging;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {

    private final MailBox mailBox;

    public Consumer(MailBox mailBox) {
        this.mailBox = mailBox;
    }

    @Override
    public void run() {
        Random random = new Random();

        for(String message = mailBox.fetch(); !message.equals("DONE"); message = mailBox.fetch()) {
            System.out.format("Received %s%n", message);
            try {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
