package training.endava.playground.generics.types;

import java.util.*;
import java.util.stream.Collectors;

public class ArticlePlayground {

    public static void main(String[] args) {
        List<Article> articles = new ArrayList<>();
        List<String> tags = new ArrayList<>();
        tags.add("Java");
        tags.add("CS");
        Article a1 = new Article("Java 12", tags);
        List<String> tags2 = new ArrayList<>();
        tags2.add("Police");
        Article a2 = new Article("Manhunt", tags2);
        List<String> tags3 = new ArrayList<>();
        tags3.add("Random");
        tags3.add("Sleep");
        tags3.add("Dreams");
        Article a3 = new Article("Dreamcathcer", tags3);
        List<String> tags4 = new ArrayList<>();
        tags4.add("Police");
        tags4.add("CS");
        Article a4 = new Article("Agent 007", tags4);
        List<String> tags5 = new ArrayList<>();
        tags5.add("Random");
        Article a5 = new Article("Blah Blah", tags5);
        articles.add(a1);
        articles.add(a2);
        articles.add(a3);
        articles.add(a4);
        articles.add(a5);

        System.out.println("Unsorted articles: " + articles);
        articles.sort((o1, o2) ->  o1.getTitle().compareTo(o2.getTitle()));
        System.out.println("Sorted articles: " + articles);

        List<String> allTags = new ArrayList<>(tags);
        allTags.addAll(tags2);
        allTags.addAll(tags3);
        allTags.addAll(tags4);
        allTags.addAll(tags5);
        System.out.println("All tags: " + allTags);
        Set<String> tagSet = new HashSet<>(allTags);
        System.out.println("Unique tags: " + tagSet);

        Set<Integer> numberOfTags =  new HashSet<>();
        for (Article article : articles){
            numberOfTags.add(article.getTags().size());
        }

        Map<Integer, List<Article>> groupedTags = new TreeMap<>();
        for(int number : numberOfTags){
            groupedTags.put(number, articles.stream().filter(article -> number == article.getTags().size()).collect(Collectors.toList()));
        }

        groupedTags.entrySet().forEach(group -> System.out.println(group.getKey() + ": " + group.getValue()));

        articles.sort((art1, art2) -> art1.getTags().size() - art2.getTags().size());
    }
}
