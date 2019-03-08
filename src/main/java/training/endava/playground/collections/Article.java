package training.endava.playground.collections;

import java.util.List;

public class Article implements Comparable<Article> {
    private int id;
    private String title;
    private List<String> tags;

    public Article(int id, String title, List<String> tags) {
        this.id = id;
        this.title = title;
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", tags=" + tags +
                '}';
    }

    @Override
    public int compareTo(Article o) {
        return this.getTitle().compareTo(o.getTitle());
    }
}
