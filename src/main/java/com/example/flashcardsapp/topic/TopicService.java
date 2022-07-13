package com.example.flashcardsapp.topic;


import com.example.flashcardsapp.flashcard.FlashcardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    TopicRepository topicRepository;
    @Autowired
    FlashcardRepository flashcardRepository;

    public Topic findTopic(Long id) {

        return topicRepository.findById(id).get();
    }

    public String checkAnswer(Long termId, String answer) {
        if (flashcardRepository.findById(termId).get().getAnswer().equals(answer)) {
            return "Nice";
        }
        return "try again";
    }
}
