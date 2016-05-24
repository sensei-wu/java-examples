package strings;

/**
 * Created by zcheruveettil on 24.05.2016.
 */
public class RegExTests {

    public static void main(String[] args) {
        String s1 = "I want to walk my dog, cat, and tarantula; maybe even my tortoise.";

        System.out.println("Split using \\s+");
        String[] words = s1.split("\\s+");
        for (String s : words) {
            System.out.println(s);
        }
        System.out.println("Count was " + words.length);

        System.out.println();

        System.out.println("Split using \\W+"); //\W => NOT word => whitespaces, comma, dot etc.
        String[] words1 = s1.split("\\W+");
        for (String s : words1) {
            System.out.println(s);
        }
        System.out.println("Count was " + words1.length);

    }
}
