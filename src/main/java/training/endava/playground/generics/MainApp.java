package training.endava.playground.generics;

import training.endava.playground.generics.types.Article;

import java.util.*;

public class MainApp {

    public static void main(String[] args) {

        List<Article> articles=new ArrayList<>();

        ArrayList<String> tagA=new ArrayList<String>();
        tagA.add("tag1");
        tagA.add("tag2");
        tagA.add("tag1");

        ArrayList<String> tagB=new ArrayList<String>();
        tagB.add("tag1");
        tagB.add("tag3");
        tagB.add("tag3");
        tagB.add("tag8");

        ArrayList<String> tagC=new ArrayList<String>();
//        tagC.add("tag1");
        tagC.add("tag4");
        tagC.add("tag3");
        tagC.add("tag3");
        tagC.add("tag5");

        Article article1=new Article("titleC","DescriptionC","ColorC",tagC);
        Article article2=new Article("titleA","DescriptionA","ColorA",tagA);
        Article article3=new Article("titleB","DescriptionB","ColorB",tagB);

        articles.addAll(Arrays.asList(article1,article2,article3));

//        System.out.println(articles);


        System.out.println("------------------------------------EX1---------------------------------------------------");
        sortByTitle(articles);
        System.out.println(articles);


        System.out.println("------------------------------------EX2---------------------------------------------------");
        System.out.println(uniqueArticles(articles));


        System.out.println("------------------------------------EX3--------------------------------------------------");
        System.out.println(groupByNumberOfTags(articles));


    }



    private static void sortByTitle(List<Article> articles) {
        articles.sort(new Comparator<Article>() {
            @Override
            public int compare(Article o1, Article o2) {
                return (o1.getTitle().compareTo(o2.getTitle()));
            }
        });
    }


    private static Set<String> uniqueArticles (List<Article> articles) {
        Set<String> articleSet=new HashSet<>();
        for(Article a:articles){
            articleSet.addAll(a.getListTag());
        }
        return articleSet;
    }


    private static Map<Integer,List<Article>> groupByNumberOfTags (List<Article> articles){
        Map<Integer,List<Article>> groupByNumberOfTags=new TreeMap<>();

        for (Article a:articles) {
            int sizeListTags=a.getListTag().size();

            if(!groupByNumberOfTags.containsKey(sizeListTags)){
                groupByNumberOfTags.put(sizeListTags,new ArrayList<>());
            }
            groupByNumberOfTags.get(sizeListTags).add(a);

        }
        return groupByNumberOfTags;
    }



}
