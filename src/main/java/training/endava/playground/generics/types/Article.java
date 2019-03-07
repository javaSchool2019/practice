package training.endava.playground.generics.types;

import java.util.List;

public class Article {
    private String title;
    private List<String> tags;

    public Article(String title, List<String> tags){
        this.title = title;
        this.tags = tags;
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
    public String toString(){
        return title + ": " + tags;
    }
}
