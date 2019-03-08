package training.endava.playground.functionalinterfaces;

import java.lang.reflect.Method;
import java.util.Arrays;

public class LambdasVsAnonymous {

    public static void main(String ... args) {
        Class c = LambdasVsAnonymous.class;
        Method[] m = c.getDeclaredMethods();
//        for (int i = 0; i < m.length; i++)
//            System.out.println(m[i].toString());

        Arrays.asList(c.getDeclaredMethods()).forEach(method -> System.out.println(method.getName()));
    }
}
