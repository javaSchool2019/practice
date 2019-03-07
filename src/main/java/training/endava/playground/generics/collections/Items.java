package training.endava.playground.generics.collections;

import java.util.ArrayList;
import java.util.Random;

public class Items {
    private String title;
    ArrayList<Integer> tags = new ArrayList<Integer>();
    Random rand = new Random();

    public Items(String title) {
        this.setTitle(title);
        this.setTags(title);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTags(String title) {
        for (int i = 0; i < rand.nextInt(10) + 2; i++) {
            this.tags.add(rand.nextInt(10));
        }

    }

    @Override
    public String toString() {
        return "Items{" +
                "title='" + title + '\'' +
                '}';
    }
}
