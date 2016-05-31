package basics;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by zcheruveettil on 31.05.2016.
 */
public class HashCodeTest {
    public static void main(String[] args) {

        System.out.println("Creating two logically identical objects using NoHashCode..");
        NoHashCode noHashCode1 = new NoHashCode(42, "Jaba");
        NoHashCode noHashCode2 = new NoHashCode(42, "Jaba");

        System.out.println(String.format("Hashcodes for the two NoHashCode objects are %d and %d: ", noHashCode1.hashCode(), noHashCode2.hashCode()));

        System.out.println("Creating two logically identical objects using WithHashCode..");
        WithHashCode withHashCode1 = new WithHashCode(42, "Jaba");
        WithHashCode withHashCode2 = new WithHashCode(42, "Jaba");
        System.out.println(String.format("Hashcodes for the two WithHashCode objects are %d and %d: ", withHashCode1.hashCode(), withHashCode2.hashCode()));
        assert withHashCode1.hashCode() == withHashCode2.hashCode();

        System.out.println("Putting some NoHashCode into a Map to see whether they can be retrieved");
        Map<String, NoHashCode> noHashCodeMap = new HashMap<>();
        noHashCodeMap.put("noHashCode1", noHashCode1);
        noHashCodeMap.put("noHashCode2", noHashCode2);
        noHashCodeMap.put("noHashCode3", noHashCode1);

        NoHashCode noHashCode = noHashCodeMap.get("noHashCode1");
        System.out.println(String.format("Retrieved the object %s from the Map using the key noHashCode1", noHashCode));

    }
}

class NoHashCode {
    private int x;
    private String s;

    public NoHashCode(int x, String s) {
        this.x = x;
        this.s = s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoHashCode that = (NoHashCode) o;
        return x == that.x &&
                Objects.equals(s, that.s);
    }

    @Override
    public String toString() {
        return "NoHashCode{" +
                "x=" + x +
                ", s='" + s + '\'' +
                '}';
    }
}

class WithHashCode {
    private int x;
    private String s;

    public WithHashCode(int x, String s) {
        this.x = x;
        this.s = s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WithHashCode that = (WithHashCode) o;
        return x == that.x &&
                Objects.equals(s, that.s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, s);
    }

    @Override
    public String toString() {
        return "NoHashCode{" +
                "x=" + x +
                ", s='" + s + '\'' +
                '}';
    }
}
