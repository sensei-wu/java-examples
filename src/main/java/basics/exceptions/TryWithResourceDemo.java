package basics.exceptions;

import java.io.*;

/**
 * Within the try.with.resource block, compiler expects a class which implements {@link AutoCloseable}}
 */
public class TryWithResourceDemo {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader(new File(TryWithResourceDemo.class.getResource(
                "crocodile.txt").getPath())))) {
            String line;
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(MyAutoClosable cl = new MyAutoClosable()) {
            cl.doSomething();
        } catch (CustomException e) {
            e.printStackTrace();
        } //no need to add finally block just for closing resources. JVM guarantees to call the close() method of the class inside try-with-resources

    }
}
