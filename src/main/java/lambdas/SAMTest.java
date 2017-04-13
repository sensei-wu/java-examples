package lambdas;

/**
 * Unlike many other programming languages, functional programming support in Java were added only with version 8 as an afterthought
 * SAM or Single Abstract Method forms the conceptual backbone for the lambda implementation in Java
 */
@FunctionalInterface
public interface SAMTest {

    void blah();

    //below line won't compile as a @FunctionalInterface can have only one abstract method
    //void yadda();

    /**
     * Default methods are still OK in a functional interface
     */
    default void yadda() {
        System.out.println("Yadda yadda");
    }
}
