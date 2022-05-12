package com.example.flashcardsapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class FlashcardController {

    @Autowired
    FlashcardRepository repository;
    @Autowired
    TopicRepository topicRepository;


    @GetMapping("/")
    public String start(Model model) {
        List<Flashcard> flashcard = repository.findAll();
        model.addAttribute("flashcards", flashcard);
        return "homepage";
    }
    /*
    @GetMapping("/flashcards")
    public String flashcards(Model model) {
        List<Flashcard> flashcard = this.repository.findAll();
        model.addAttribute("flashcards", flashcard);
        return "";
    }*/

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
}
