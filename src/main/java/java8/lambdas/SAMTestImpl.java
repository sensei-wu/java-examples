package java8.lambdas;

//Implementation of a Single Abstract Method Interface with a default method
public class SAMTestImpl implements SAMTest {
    @Override
    public void blah() {
        System.out.println("Blah implemented");
    }
}
