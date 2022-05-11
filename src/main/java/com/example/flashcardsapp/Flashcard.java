package com.example.flashcardsapp;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "cards")
public class Flashcard {

    @Id
    @GeneratedValue
    Long id;
    String term;
    String answer;
    @ManyToOne
    @JoinColumn(name = "topic_id")
    Topic topic;

    public Flashcard() {
    }

    public Flashcard(Long id, String term, String answer, Topic topic) {
        this.id = id;
        this.term = term;
        this.answer = answer;
        this.topic = topic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Topic getTheme() {
        return topic;
    }

    public void setTheme(Topic theme) {
        this.topic = theme;
    }

    @Override
    public String toString() {
        return "Flashcard{" +
                "id=" + id +
                ", term='" + term + '\'' +
                ", answer='" + answer + '\'' +
                ", theme=" + topic +
                '}';
    }
}
