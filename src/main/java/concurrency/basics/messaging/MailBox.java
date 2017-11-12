package concurrency.basics.messaging;

/**
 * Ensures the following:
 *
 * <ul>
 *     <li>A Producer will send a message only if the last message was consumed</li>
 *     <li>A Consumer will consume a message only once a message was produced</li>
 * </ul>
 */
public class MailBox {

    private String message;

    private boolean empty = true;

    public synchronized void put(String message) {

        while(!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.empty = false;

        this.message = message;

        notifyAll();
    }

    public synchronized String fetch() {

        while(empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.empty = true;
        notifyAll();
        return message;
    }
}
