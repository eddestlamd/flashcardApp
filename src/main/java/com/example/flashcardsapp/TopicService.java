package com.example.flashcardsapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    TopicRepository topicRepository;

    public Topic findTopic(Long id) {

        return topicRepository.findById(id).get();
    }
}
