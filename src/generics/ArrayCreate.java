package generics;

import java.util.Arrays;
import java.util.List;

/**
 * Java does not support generic array creation.
 *
 * <p>In Java, Generics are implemented using type erasure -- a technique whereby any generic type information
 * is erased during compilation. This was implemented that way in-order to maintain binary compatibility with pre 1.5 version of Java.
 * <p> The consequence of type erasure is that at runtime, generic information is not available
 * <p> Arrays on the other hand "reify" their component types, meaning that they carry runtime information about their component types. If component types
 * are not reifiable, as is the case with Generic types, you cannot create an array. As a result, you cannot easily create an array with neither type variable,
 * nor parametrized type component.
 * <p>This example shows two ways to overcome this limitation</p>
 * Both ways make use of Reflection, while taking advantage of the fact that though you cannot instantiate an array with type variable,
 * you can still cast to a type variable
 *
 */
public class ArrayCreate {

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1, 2, 3, 4);

        Integer[] myHardArray = convertoArray(integers, new Integer[] {integers.size()});

        Object[] objects = convertoArrayUsingClass(Arrays.asList("Apple", "Oranges", "Bananas", "Peaches", 24, 5.15), Object.class);

        Arrays.stream(myHardArray).forEach(t -> System.out.print(t + ", "));

        System.out.println();

        Arrays.stream(objects).forEach(t -> System.out.print(t + ", "));
    }

    //Uses a type variable array provided as the additional parameter to be able to cast to the target type
    private static <T> T[] convertoArray(List<T> list, T[] type) {
        //T[] array = new T[list.size()]; //=> will not work, compile error
        T[] array = (T[]) java.lang.reflect.Array.newInstance(type.getClass().getComponentType(), list.size()); //unchecked cast

        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }

        return array;
    }

    //Uses the generic class to get the information about component type
    private static <T> T[] convertoArrayUsingClass(List<T> list, Class<T> clazz) {
        //T[] array = new T[list.size()]; => will not work
        T[] array = (T[]) java.lang.reflect.Array.newInstance(clazz, list.size()); //unchecked cast

        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }

        return array;
    }
}
