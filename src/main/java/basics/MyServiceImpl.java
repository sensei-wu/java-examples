package basics;

import java.time.Instant;
import java.util.Date;

public enum MyServiceImpl implements MyService {

    DOG {
        @Override
        public void cry() {
            long start = System.currentTimeMillis();
            System.out.println("Wow wow");
            long end = System.currentTimeMillis();
            System.out.println("Bark Took " + (end - start) + " ms");
        }
    },
    CAT {

        private String d = Instant.now().toString();

        @Override
        public void cry() {
            long start = System.currentTimeMillis();
            ExpensiveObject expensiveObject = new ExpensiveObject();
            System.out.println("Meaow " + d + " at " + Instant.now().toString());
            long end = System.currentTimeMillis();

            System.out.println("Meaow Took " + (end - start) + " ms");
        }
    }
}
