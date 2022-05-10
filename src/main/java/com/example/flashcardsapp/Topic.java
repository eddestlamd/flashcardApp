package com.example.flashcardsapp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "topic_id")
    private Integer id;
    @Column(name = "topic_name")
    private String name;
    @OneToMany(mappedBy = "theme", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Flashcard> flashcardSet;

    public Topic() {
    }

    public Topic(Integer id, String name, Set<Flashcard> flashcardSet) {
        this.id = id;
        this.name = name;
        this.flashcardSet = flashcardSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Flashcard> getFlashcardSet() {
        return flashcardSet;
    }

    public void setFlashcardSet(Set<Flashcard> flashcardSet) {
        this.flashcardSet = flashcardSet;
    }

}
