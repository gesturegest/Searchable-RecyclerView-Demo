package com.github.wrdlbrnft.searchablerecyclerviewdemo.ui.adapter.models;

public class Person implements Comparable<Person> {

    private String rank;
    private String name;

    public Person(String rank, String name) {
        this.rank = rank;
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Person another) {
        String[] rank1 = this.getRank().split("\n");
        String[] rank2 = another.getRank().split("\n");
        int diff = Double.valueOf(rank1[0]).compareTo(Double.valueOf(rank2[0]));
        return (diff == 0) ? this.getName().compareTo(another.getName()) : diff;
    }

}
