package com.example.flashcardsapp;



import javax.persistence.*;

@Entity
@Table(name = "cards")
public class Flashcard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "card_id")
    Integer id;
    String term;
    String answer;
    @ManyToOne
    @JoinColumn(name = "topic_id")
    Topic theme;

    public Flashcard() {
    }

    public Flashcard(Integer id, String term, String answer, Topic theme) {
        this.id = id;
        this.term = term;
        this.answer = answer;
        this.theme = theme;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        return theme;
    }

    public void setTheme(Topic theme) {
        this.theme = theme;
    }
}
