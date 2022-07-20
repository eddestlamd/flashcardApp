package com.example.flashcardsapp.flashcard;
import com.example.flashcardsapp.topic.Topic;
public class Flashcard {

    Long id;
    String term;
    String answer;
    Topic topic;

    boolean isNew;

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

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
    public boolean isNew(){
        return this.id == null;
    }

    @Override
    public String toString() {
        return "Flashcard{" +
                "id=" + id +
                ", term='" + term + '\'' +
                ", answer='" + answer + '\'' +
                ", topic=" + topic +
                '}';
    }
}
