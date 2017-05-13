package lambdas;

/**
 * Created by zen on 5/13/17.
 */
public class SAMTestClient {
    public static void main(String[] args) {
        SAMTest samTest = new SAMTestImpl();
        samTest.blah();
        samTest.yadda();

        SAMTest lambdaBlah = () -> System.out.println("I am a lambda blah"); //only possible because SAMTest has only a single abstract method

        lambdaBlah.blah();

        SAMTest lambdaYadda = () -> System.out.println("I am a lambda yadda");
        lambdaYadda.yadda(); //lambdaYadda is an anonymous implementation of SAMTest, but abstract method though implemented is never invoked by the client


    }
}
