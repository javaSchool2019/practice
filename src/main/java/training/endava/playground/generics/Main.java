package training.endava.playground.generics;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Article> articles = createListOfArticles();
        System.out.println("Unsorted list: " + articles);
        Collections.sort(articles);
        System.out.println("Sorted list:" + articles);

        Set<String> uniqueTags = new HashSet<>();
        articles.forEach((article -> uniqueTags.addAll(article.getTags())));
        System.out.println("UniqueArticles: " + uniqueTags);

        Collections.sort(articles, (o1, o2) -> o2.getTags().size() - o1.getTags().size());
        System.out.println("Sorted by number of tags:" + articles);

        Map<Integer, List<Article>> articleMapBySize = new HashMap<>();

        articles.forEach(article -> {
            articleMapBySize.putIfAbsent(article.getTags().size(), new ArrayList<>(Arrays.asList(article)));
            List<Article> articleList = articleMapBySize.get(article.getTags().size());
            articleList.add(article);

        });
        System.out.println("ArticleMap:" + articleMapBySize);

    }


    private static List<Article> createListOfArticles() {
        List<Article> articles = new ArrayList<>();
        articles.add(new Article("ART1", Arrays.asList("Tag1", "Tag2", "Tag3")));
        articles.add(new Article("GDT34", Arrays.asList("Tag5", "Tag2", "Tag4", "Tag9")));
        articles.add(new Article("ATG98", Arrays.asList("Tag1", "Tag26", "Tag38", "Tag94", "Tag96")));
        articles.add(new Article("GTT36", Arrays.asList("Tag11", "Tag22", "Tag33", "Tag93", "Tag94", "Tag95")));
        articles.add(new Article("B0ZC", Arrays.asList("Tag1", "Tag2", "Tag3")));

        return articles;
    }

}
