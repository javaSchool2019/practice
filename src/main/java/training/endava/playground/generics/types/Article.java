package training.endava.playground.generics.types;

import java.util.ArrayList;
import java.util.List;

public class Article {
    List <String> tags;
    String title;
    String author;

    public Article(List<String> tags, String title, String author) {
        this.tags = tags;
        this.title = title;
        this.author = author;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Article{" +
                "tags=" + tags +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
