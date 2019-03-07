package training.endava.playground.generics.types;

import java.util.ArrayList;

public class Article {

    private String title;
    private String author;
    private ArrayList<String> tag;

    public Article(String title, String author, ArrayList<String> tag) {
        this.title = title;
        this.author = author;
        this.tag = tag;
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

    public ArrayList<String> getTags() {
        return tag;
    }

    public void setTags(ArrayList<String> tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", tag=" + tag +
                '}';
    }
}
