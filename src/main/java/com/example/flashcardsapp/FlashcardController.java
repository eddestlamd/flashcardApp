package com.example.flashcardsapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FlashcardController {

    @Autowired
    FlashcardRepository repository;
    @Autowired
    TopicRepository topicRepository;


    @GetMapping({"/"})
    public String start(Model model) {
        List<Flashcard> flashcard = this.repository.findAll();
        model.addAttribute("flashcards", flashcard);
        return "homepage";
    }

    @GetMapping({"/flashcards"})
    public String flashcards(Model model) {
        List<Flashcard> flashcard = this.repository.findAll();
        model.addAttribute("flashcards", flashcard);
        return "flashcards";
    }

    @GetMapping({"/add"})
    public String add(Model model) {
        model.addAttribute("flashcard", new Flashcard());
        List<Topic> topics = topicRepository.findAll();
        return "flashcards";
    }

    @PostMapping({"/save"})
    public String set(@ModelAttribute Flashcard flashcard) {
        repository.save(flashcard);
        return "redirect:/";
    }
}
