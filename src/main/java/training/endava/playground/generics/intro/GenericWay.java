package training.endava.playground.generics.intro;

import java.util.ArrayList;
import java.util.List;

public class GenericWay {

    public static void main(String ... args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("School");
        arrayList.add("Of");
        arrayList.add("Java");
        printToUpperCaseGenericList(arrayList);



        // try the same thing
//        arrayList.add(new ArrayList<String>());
    }

    private static void printToUpperCaseGenericList(List<? extends String> stringArrayList) {
        for (int i = 0; i < stringArrayList.size(); i++) {
            String uppercaseString = stringArrayList.get(i).toUpperCase();
            System.out.println(uppercaseString);
        }
    }
}
