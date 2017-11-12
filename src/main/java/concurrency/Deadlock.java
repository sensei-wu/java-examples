package concurrency;


/**
 * Courtesy: https://docs.oracle.com/javase/tutorial/essential/concurrency/deadlock.html
 *
 * Demonstrates deadlock using an example
 *
 */
public class Deadlock {
    static class Friend {
        private final String name;

        Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s" + " has bowed to me! %n", this.getName(), bower.getName());
            bower.bowBack(this);
        }


        private synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s" + " has bowed back to me! %n", this.getName(), bower.getName());
        }

        public static void main(String[] args) {
            final Friend alphonse =
                    new Friend("Alphonse");
            final Friend gaston =
                    new Friend("Gaston");
            new Thread(new Runnable() {
                public void run() { alphonse.bow(gaston); }
            }).start();
            new Thread(new Runnable() {
                public void run() { gaston.bow(alphonse); }
            }).start();
        }
    }
}
