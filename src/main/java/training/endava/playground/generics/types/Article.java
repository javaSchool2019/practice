package training.endava.playground.generics.types;

import java.util.List;
import java.util.Objects;

public class Article {
    private String title;
    private String description;
    private List<String> listTag;

    public Article(String title, String description,  List<String> listTag) {
        this.title = title;
        this.description = description;
        this.listTag = listTag;
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

    public List<String> getListTag() {
        return listTag;
    }

    public void setListTag(List<String> listTag) {
        this.listTag = listTag;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(title, article.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }


    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", listTag=" + listTag + "\n" +
                '}';
    }






}
