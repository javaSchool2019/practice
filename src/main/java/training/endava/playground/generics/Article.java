package training.endava.playground.generics;

import java.util.List;
import java.util.Objects;

public class Article implements Comparable<Article> {
    private String title;
    private List<String> tags;

    public Article(String title, List<String> tags) {
        this.title = title;
        this.tags = tags;
    }

    public boolean addTag(String tag) {
        return tags.add(tag);
    }

    public boolean removeTag(String tag) {
        if (tags.contains(tag)) {
            tags.remove(tag);
            return true;
        }
        return false;
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
                "title='" + title + '\'' +
                ", tags=" + tags +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return title.equals(article.title) &&
                tags.equals(article.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, tags);
    }

    @Override
    public int compareTo(Article o) {
        return this.title.compareTo(o.getTitle());
    }
}
