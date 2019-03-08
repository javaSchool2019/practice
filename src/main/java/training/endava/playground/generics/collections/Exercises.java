package training.endava.playground.generics.collections;

import java.util.*;

public class Exercises implements Comparator<Items> {
    ArrayList<Items> list = new ArrayList<Items>();

    public Exercises() {
        this.list = makeArticleList();
    }

    public void sortByTitle() {
        System.out.println("Unsorted");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("\t" + list.get(i).getTitle());
        }
        list.sort(this);
        System.out.println("Sorted");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("\t" + list.get(i).getTitle());
        }
    }

    public void printUniqueTitles() {
        ArrayList<Integer> uniqueTags = new ArrayList<Integer>();

        for (int i = 0; i < this.list.size(); i++) {
            uniqueTags.addAll(this.list.get(i).tags);
        }

        System.out.println("All tags");
        System.out.println("\t" + uniqueTags);

        TreeSet<Integer> sortedSet = new TreeSet<Integer>(uniqueTags);

        System.out.println("Unique tags \t");
        System.out.print("\t");
        for (Integer i :
                sortedSet) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


    public ArrayList<Items> makeArticleList() {
        ArrayList<Items> list = new ArrayList<Items>();
        for (int i = 10; i > 0; i--) {
            list.add(new Items("titlu" + i));
        }
        return list;
    }

    public void printGroupByNrOfTags() {
        TreeSet<Integer> sizeUniqueTags = new TreeSet<>();
        for (int i = 0; i < this.list.size(); i++) {
            sizeUniqueTags.add(this.list.get(i).tags.size());
        }

        TreeMap<Integer, ArrayList<Items>> group = new TreeMap<>();
        for (Integer size : sizeUniqueTags) {
            ArrayList<Items> artWithSameNrTags = new ArrayList<Items>();
            for (int i = 0; i < this.list.size(); i++) {
                if (this.list.get(i).tags.size() == size) {
                    artWithSameNrTags.add(this.list.get(i));
                }
            }
            group.put(size, artWithSameNrTags);
        }
        for (Integer i :
                group.descendingKeySet()) {
            System.out.println("tag size: " + i);
            for (int j = 0; j < group.get(i).size(); j++) {
                System.out.println("\t article title "+group.get(i).get(j).getTitle());
            }
        }
    }

    @Override
    public int compare(Items o1, Items o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
