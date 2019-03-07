package training.endava.playground.collections;

import java.util.*;
import java.util.stream.Collectors;

public class ArticleMain {
    public static List<Article> createDummyArticleList() {
        Article a1 = new Article(9, "Article1", Arrays.asList("#wow", "#new", "#fancy", "#electric", "#eco", "#plus"));
        Article a2 = new Article(2, "Article2", Arrays.asList("#wow", "#expensive"));
        Article a3 = new Article(3, "Article3", Arrays.asList("#good", "#politics", "#job"));
        Article a4 = new Article(4, "Article4", Arrays.asList("#job", "#endava", "#IT"));
        Article a5 = new Article(5, "Article5", Arrays.asList("#millionare", "#expensive", "#collection", "#sportcar"));
        return Arrays.asList(a1, a2, a3, a4, a5);
    }

    public static void printTags(Collection<String> tags) {
        System.out.print("Unique tags: ");
        for (String tag : tags) {
            System.out.print(tag + " ");
        }
        System.out.println();
    }

    public static void printArticles(List<Article> articles) {
        for (Article article : articles) {
            System.out.println(article);
        }
        System.out.println();
    }

    public static void printArticles(Map<Integer, List<Article>> map) {
        for (Map.Entry<Integer, List<Article>> entry : map.entrySet()) {
            System.out.println("Articles with " + entry.getKey() + " tags:");
            printArticles(entry.getValue());
        }
        System.out.println();
    }

    public static Set<String> getUniqueTags(List<Article> articles) {
        Set<String> uniqueTags = new HashSet<>();
        for (Article article : articles) {
            uniqueTags.addAll(article.getTags());
        }
        return uniqueTags;
    }

    public static Map<Integer, List<Article>> groupByNumberOfTagsWithoutJava8(List<Article> articles) {
        Map<Integer, List<Article>> map = new TreeMap<>(Collections.reverseOrder());
        for (Article article : articles) {
            int size = article.getTags().size();
            if (map.containsKey(size)) {
                List<Article> containedArticles = map.get(size);
                containedArticles.add(article);
                map.put(size, containedArticles);
            } else {
                map.put(size, new ArrayList<>(Arrays.asList(article)));
            }
        }
        return map;
    }

    public static Map<Integer, List<Article>> groupByNumberOfTags(List<Article> articles) {
        Set<Integer> tagsNumber = new HashSet<>();
        articles.forEach(a -> tagsNumber.add(a.getTags().size()));
        Map<Integer, List<Article>> map = new TreeMap<>(Collections.reverseOrder());
        tagsNumber.forEach(t -> map.put(t, articles.stream().filter(a -> a.getTags().size() == t).collect(Collectors.toList())));
        return map;
    }

    public static void main(String[] args) {
        List<Article> articles = createDummyArticleList();
        Collections.shuffle(articles);
        System.out.println("Articles in random order:");
        printArticles(articles);

        Collections.sort(articles);
        System.out.println("Articles ordered by title name:");
        printArticles(articles);

        Set<String> uniqueTags = getUniqueTags(articles);
        printTags(uniqueTags);

        Collections.shuffle(articles);
        System.out.println("Articles sorted in reverse order:");
        Map<Integer, List<Article>> map = groupByNumberOfTagsWithoutJava8(articles);
        printArticles(map);
    }
}
