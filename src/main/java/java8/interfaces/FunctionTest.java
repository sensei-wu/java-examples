package java8.interfaces;

import java.util.function.Function;

/**
 * How to use {@link Function} interface
 */
public class FunctionTest {

    public static void main(String[] args) {

        String aLowerCaseString = "jaba";
        double aDoubleNumber = 3.0;

        //A function which takes a String and returns a String after applying a function
        Function<String, String> toUpperFunc = String::toUpperCase;
        System.out.println(String.format("After converting %s to Upper case = %s", aLowerCaseString, toUpperFunc.apply(aLowerCaseString)));

        //f(x) = sqrt(x)
        Function<Double, Double> squareRootFunc = Math::sqrt;
        System.out.println(String.format("Square root of %f = %f", aDoubleNumber, squareRootFunc.apply(aDoubleNumber)));

        //f(x) = x * x
        Function<Double, Double> squareFunc = i -> Math.pow(i, 2.0);
        System.out.println(String.format("Square of %f = %f", aDoubleNumber, squareFunc.apply(aDoubleNumber)));

        //f(x) = x/2
        Function<Double, Double> halfFunc = i -> i/2;

        //Higher order functions are a common feature in many functional languages. Here functional operations can be chained

        //compose function evaluates the input parameter first and then applies that result to the calling function
        //f(x) = (x * (1/2)) * (x *(1/2))
        System.out.println(String.format("Square of the Half of %f = %f", aDoubleNumber, squareFunc.compose(halfFunc).apply(aDoubleNumber)));

        //andThen function first applies the calling function and applies the result to the input parameter
        //f(x) = (x * x) * (1/2)
        System.out.println(String.format("Half of the Square of %f = %f", aDoubleNumber, squareFunc.andThen(halfFunc).apply(aDoubleNumber)));

        //f(x) = x, Identity function can be useful for initializing
        System.out.println(String.format("Identity of %f = %s", aDoubleNumber, Function.identity().apply(aDoubleNumber).toString()));

    }
}
