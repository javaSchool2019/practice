package training.endava.playground.generics.types;

import java.util.*;

class ArticleShowOff{

    public static void main(String[] argv){
        Article article1 = new Article("C", "Description C","vip", "news");
        Article article2 = new Article("B", "Description B","showbiz", "news", "breaking");
        Article article3 = new Article("E", "Description E","wow","vip");
        Article article4 = new Article("D", "Description D","news");
        Article article5 = new Article("A", "Description A", "news", "wow");

        List<Article> articles = new ArrayList<>();
        articles.add(article1);
        articles.add(article2);
        articles.add(article3);
        articles.add(article4);
        articles.add(article5);

        Comparator<Article> articleComparator = new Comparator<Article>() {
            @Override
            public int compare(Article o1, Article o2) {
                return 0;
            }
        };
        // Ex1
        articles.sort(new Comparator<Article>() {
            @Override
            public int compare(Article o1, Article o2) {
                return o1.title.compareTo(o2.title);
            }
        });
        articles.sort(new Comparator<Article>() {
            @Override
            public int compare(Article o1, Article o2) {
                return 0;
            }
        });
        articles.forEach(System.out::println);

        // Ex2
        Set<String> uniqueTags = new HashSet<>();
        articles.forEach(article -> uniqueTags.addAll(article.getTags()));

        System.out.println(uniqueTags);

        // Ex3

        Map<Integer, List<Article>> articlesGroupedByNumberOfTags = new HashMap<>();
        articles.forEach(article -> {
            Integer numberOfTags = article.getNumberOfTags();
            if(!articlesGroupedByNumberOfTags.containsKey(numberOfTags)){
                articlesGroupedByNumberOfTags.put(numberOfTags, new ArrayList<>());
            }

            articlesGroupedByNumberOfTags.get(numberOfTags).add(article);
        });

        articles.sort(new Comparator<Article>() {
            @Override
            public int compare(Article o1, Article o2) {
                return (-1) * (o1.getNumberOfTags()-o2.getNumberOfTags());
            }
        });
        
        articlesGroupedByNumberOfTags.forEach((integer, articleList) -> {
            System.out.println("Number of tags: " + integer + " has "+articleList);
        });
                                                                    
    }

}

public class Article {
    String title;
    String description;
    List<String> tags;



    public Article(String title, String description, String ... tags) {
        this.title = title;
        this.description = description;
        this.tags = new ArrayList<>(Arrays.asList(tags));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTags() {
        return tags;
    }

    public int getNumberOfTags(){
        return this.tags.size();
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void addTag(String tag){
        this.tags.add(tag);
    }

    public void removeTag(String tag){
        if(this.tags.contains(tag)){
            this.tags.remove(tag);
        }
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", tags=" + tags +
                '}';
    }
}
