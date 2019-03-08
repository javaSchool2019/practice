package training.endava.playground.generics.types;
import java.sql.SQLOutput;
import java.util.*;

public class GenericTypes {

    public static void main(String ... args) {
        Box<Bottle> box = new Box<>();
        box.packBox(new Bottle("Coca-cola"));

        Bottle cocaCola = box.emptyBox();
        System.out.println(cocaCola);

        // compiler checks

        Box<Fruit> box2 = new Box<>();
        box2.packBox(new Fruit(300));

        List<String> tags1 = new ArrayList<String>();
        tags1.add("Food");
        tags1.add("Health");
        tags1.add("Vegan");

        List<String> tags2 = new ArrayList<String>();
        tags2.add("Cars");
        tags2.add("Auto");
        tags2.add("Vehicle");

        List<String> tags3 = new ArrayList<String>();
        tags3.add("Cars");
        tags3.add("Health");

        Article articol0 = new Article(tags1, "Vegans", "Iulia");
        Article articol1 = new Article(tags2, "Automobilism", "David");
        Article articol2 = new Article(tags3, "AutoAndFood", "Daea");
        List<Article> listOfArts = new ArrayList<Article>();
        listOfArts.add(articol0);
        listOfArts.add(articol1);
        listOfArts.add(articol2);
        System.out.println(listOfArts);
        //sort
        listOfArts.sort(new Comparator<Article>() {
            @Override
            public int compare(Article o1, Article o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        System.out.println(listOfArts );

        //unique tags
        Set<String> tagUnique = new HashSet<String>();
        for(Article allTags: listOfArts)
            tagUnique.addAll(allTags.getTags());
        System.out.println(tagUnique);

        //group by number of tags
        HashMap<Integer, List<Article>> MapOfTags = new HashMap<Integer, List<Article>>();
        for(Article arts: listOfArts)
        {    int totalTags = arts.getTags().size();
            if(MapOfTags.containsKey(totalTags))
                MapOfTags.get(totalTags).add(arts);
            else
                MapOfTags.put(totalTags,new ArrayList<>());
                MapOfTags.get(totalTags).add(arts);
        }
        MapOfTags.forEach((k,v) -> System.out.println("Key = "
                + k + ", Value = " + v));

    }

}
