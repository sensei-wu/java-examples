package java8.lambdas;

public class MethodRefTests {

    public static void main(String[] args) {

        String sample = "zenifer";

        System.out.println("--------- Printing sample string in uppercase ----------");

        System.out.println("Using anon class: " + Util.transform(sample, new StringFunction() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        }));

        System.out.println("Using lambda: " + Util.transform(sample, s1 -> s1.toUpperCase()));

        System.out.println("Using method reference: " + Util.transform(sample, String::toUpperCase));

        System.out.println("--------- Printing after prepending sample string with 'test-' ----------");

        System.out.println("Using anon class: " + Util.transform(sample, new StringFunction() {
            @Override
            public String apply(String s) {
                return "test-".concat(s);
            }
        }));

        System.out.println("Using lambda: " + Util.transform(sample, s -> "test-".concat(s))); // can be replaced with method reference "test-"::concat

        System.out.println("Using method reference: " + Util.transform(sample, "test-"::concat)); // same as the lambda in the above line

        System.out.println("--------- Printing after appending sample string with '-test' ----------");

        System.out.println("Using anon class: " +  Util.transform("-test", new StringFunction() {
            @Override
            public String apply(String s) {
                return sample.concat(s);
            }
        }));

        System.out.println("Using lambda: " +  Util.transform("-test", s -> sample.concat(s)));

        System.out.println("Using method reference: " +  Util.transform("-test", sample::concat));

        System.out.println("--------- Printing after making sample string more exciting using !! ----------");

        System.out.println(Util.transform(sample, Util::makeExciting));

    }

    @FunctionalInterface
    private interface StringFunction {
         String apply(String s);
    }

    private static class Util {
        private static String transform(String s, StringFunction func) {
            return func.apply(s);
        }

        //our own custom function which makes a given String really exciting when printed out
        private static String makeExciting(String s) {
            return s + "!!";
        }
    }
}
