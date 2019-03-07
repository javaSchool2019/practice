package training.endava.playground.generics.intro;

import java.util.ArrayList;
import java.util.List;

public class LegacyWay {

    public static void main(String... args) {
        List stringArrayList = new ArrayList();

        stringArrayList.add("School");
        stringArrayList.add("Of");
        stringArrayList.add("Java");

        printToUpperCaseList(stringArrayList);

        //Great, but is it really that great?

        stringArrayList.add(new ArrayList());
        printToUpperCaseList(stringArrayList);
    }

    private static void printToUpperCaseList(List stringArrayList) {
        for (int i = 0; i < stringArrayList.size(); i++) {
            String uppercaseString = ((String) stringArrayList.get(i)).toUpperCase();
            System.out.println(uppercaseString);
        }
    }
}
