package com.example.flashcardsapp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "topic_name")
    private String name;
    @OneToMany(mappedBy = "topic", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Flashcard> box = new HashSet<>();

    public Topic() {
    }

    public Topic(Long id, String name, Set<Flashcard> flashcardSet) {
        this.id = id;
        this.name = name;
        this.box = flashcardSet;
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
