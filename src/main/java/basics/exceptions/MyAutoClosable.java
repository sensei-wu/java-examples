package basics.exceptions;

public class MyAutoClosable implements AutoCloseable {

    public void doSomething() {
        System.out.println("doSomething()");
    }

    @Override
    public void close() throws CustomException{
        //close some reources
        //reset the state if any etc. etc.
    }
}
