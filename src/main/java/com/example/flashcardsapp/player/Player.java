package com.example.flashcardsapp.player;

import javax.persistence.*;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    Long id;
    String name;
    String answers;
    @Column(name="correct_answers")
    int correctAnswers;
    String username;
    String pw;

    public Player() {
    }

    public Player(Long id, String name, String answers, int correctAnswers, String username, String pw) {
        this.id = id;
        this.name = name;
        this.answers = answers;
        this.correctAnswers = correctAnswers;
        this.username = username;
        this.pw = pw;
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

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
