package com.example.flashcardsapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class FlashcardController {

    @Autowired
    FlashcardRepository repository;
    @Autowired
    TopicRepository topicRepository;
    @Autowired
    TopicService tService;


    @GetMapping("/")
    public String start(Model model) {
        List<Flashcard> flashcard = repository.findAll();
        model.addAttribute("flashcards", flashcard);
        return "homepage";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("flashcard", new Flashcard());
        List<Topic> topics = topicRepository.findAll();
        model.addAttribute("topics", topics);

        return "flashcards";
    }

    @PostMapping("/save")
    public String set(@ModelAttribute Flashcard flashcard, @RequestParam Topic topics, @RequestParam String term, @RequestParam String answer) {
        flashcard.setTerm(term);
        flashcard.setAnswer(answer);
        flashcard.setTopic(topics);
        repository.save(flashcard);
        return "redirect:/";
    }

    @GetMapping("/practice")
    public String chooseTopic(Model model){
        List<Topic> topics = topicRepository.findAll();
        model.addAttribute("topics", topics);
        return "practice";
    }

    @GetMapping("/practice/{id}")
    public String quiz(@PathVariable Long id, Model model){
        Topic topic = tService.findTopic(id);
        model.addAttribute("topic", topic);



        return "quiz";
    }
}
