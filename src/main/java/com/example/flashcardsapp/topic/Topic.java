package com.example.flashcardsapp.topic;

import com.example.flashcardsapp.flashcard.Flashcard;


import java.util.HashSet;
import java.util.Set;


public class Topic {


    private Long id;
    private String name;
    private Set<Flashcard> box = new HashSet<>();

    public Topic() {
    }

    public Topic(Long id, String name, Set<Flashcard> box) {
        this.id = id;
        this.name = name;
        this.box = box;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Flashcard> getBox() {
        return box;
    }

    public void setBox(Set<Flashcard> box) {
        this.box = box;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
