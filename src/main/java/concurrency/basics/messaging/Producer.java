package concurrency.basics.messaging;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Producer can push only if {@link MailBox} is empty
 * It sleeps for a random time between retries
 */
public class Producer implements Runnable {

    private final MailBox mailBox;

    public Producer(MailBox mailBox) {
        this.mailBox = mailBox;
    }

    @Override
    public void run() {
        String[] messages = {"Aidan", "Simon", "Florian", "Fanny", "Aurelie"};

        Random random = new Random();

        for(String message: messages) {


            mailBox.put(message);

            try {
                int sleep = random.nextInt(500);
                System.out.format("Sleeping for %d%n", sleep);

                TimeUnit.MILLISECONDS.sleep(sleep);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        mailBox.put("DONE");
    }
}
