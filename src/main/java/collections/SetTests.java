package collections;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * An example to demo the difference between the ordering behaviour of 3 Set implementations in standard Jdk
 */
public class SetTests {

    public static void main(String[] args) {

        Set<Integer> treeSet = new TreeSet<>();
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> linkedHashSet = new LinkedHashSet<>();

        Path path = Paths.get("setTests.txt");

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write("Generating and adding randomly generated integers between 0 and 5000 to the sets \n");

            for (int i = 0; i < 5000; i++) {
                int j = (int) (Math.random() * 5000);
                boolean result = treeSet.add(j);
                hashSet.add(j);
                linkedHashSet.add(j);

                if(!result)
                    writer.write("Discarded duplicate " + j + "\n");
                else
                    writer.write("Added " + j + "\n");

            }

            //TreeSet should keep elements in their "natural order", i.e., the order defined as per the Comparable interface for the element in teh Set
            writer.write("******************* Printing the integers from the TreeSet *******************");
            for(int i : treeSet) {
                writer.write(i + "\n");
            }

            //HashSet does not make any guarantee to the order, though for simpler types such as Integer, in practice the elements may be kept in their natural order
            writer.write("******************* Printing the integers from the HashSet *******************");
            for(int i : hashSet) {
                writer.write(i + "\n");
            }

            //LinkedHashSet maintains elements in their insertion order
            writer.write("******************* Printing the integers from the LinkedHashSet *******************");
            for(int i : linkedHashSet) {
                writer.write(i + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
