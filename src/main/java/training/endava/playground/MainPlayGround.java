package training.endava.playground;

import training.endava.playground.generics.types.Article;

import java.util.*;

public class MainPlayGround {

    public static void main(String args[])
    {
        ArrayList<String> a1 = new ArrayList<>();
        a1.add("tag1");
        a1.add("tag2");

        ArrayList<String> a2 = new ArrayList<>();
        a2.add("tag3");

        ArrayList<String> a3 = new ArrayList<>();
        a3.add("tag17");
        a3.add("tag4");
        a3.add("tag5");


        Article article1 = new Article("Art01", "A1", a1 );
        Article article5 = new Article("Art05", "A5", a1 );
        Article article2  = new Article("Art02", "A2", a2 );
        Article article3 = new Article("Art03", "A3", a3 );

        ArrayList<Article> articleList = new ArrayList<>();
        articleList.add(article1);
        articleList.add(article5);
        articleList.add(article2);
        articleList.add(article3);

        articleList.sort(new Comparator<Article>() {
            @Override
            public int compare(Article a1, Article a2) {
                return a1.getTitle().compareTo(a2.getTitle());
            }
        });

        //System.out.println(articleList);

        Set<String> uniqueTags = new HashSet<>();
        for ( Article a : articleList) {
            uniqueTags.addAll(a.getTags());
        }

        // System.out.println(uniqueTags);

        // Group the articles by number of tags. Sort the articles descending by the number of tags.
        // Print for each number of tags it’s articles

        Map<Integer, List<Article>> nrOfTags = new TreeMap<>();

        for ( Article a : articleList) {
            int size = a.getTags().size();
            if(!nrOfTags.containsKey(size))
            {
                nrOfTags.put(size, new ArrayList<>());
            }

            nrOfTags.get(size).add(a);
        }

        for (Integer key : nrOfTags.keySet()) {
            System.out.println("Key = " + key);
            System.out.println("List =" + nrOfTags.get(key));
        }

        LinkedHashMap<Integer, List<Article>> reverseSortedMap = new LinkedHashMap<>();


        nrOfTags.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

        //System.out.println("Reverse Sorted Map   : " + reverseSortedMap);
        for (Integer key : reverseSortedMap.keySet()) {
            System.out.println("Key = " + key);
            System.out.println("List =" + nrOfTags.get(key));
        }

    }

}
