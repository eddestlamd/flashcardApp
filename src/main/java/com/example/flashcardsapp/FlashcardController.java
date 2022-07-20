package com.example.flashcardsapp;


import com.example.flashcardsapp.flashcard.Flashcard;
import com.example.flashcardsapp.player.Player;
import com.example.flashcardsapp.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class FlashcardController {

   @Autowired
   RestTemplate restTemplate;

    @PostMapping("/save")
    public String save(@ModelAttribute Flashcard flashcard, @RequestParam String term,@RequestParam String answer, @RequestParam Topic topic){
        /* flashcard.setTopic(topic);
        restTemplate.postForEntity("http://localhost:8081/api/card/save", flashcard, Flashcard.class);*/
        if (flashcard.isNew()) {
            flashcard.setTopic(topic);
            flashcard.setTerm(term);
            flashcard.setAnswer(answer);
            Flashcard newFlashcard = restTemplate.postForObject("http://localhost:8081/api/card/save", flashcard, Flashcard.class);
        }
        else {
            restTemplate.put("http://localhost:8080/api/card/edit" + flashcard.getId(), flashcard, Flashcard.class);
        }
        return "redirect:/";
    }

    @PostMapping("/savePlayer")
    public String savePlayer(@ModelAttribute Player player){
        restTemplate.postForObject("http://localhost:8081/api/player/save", player, Player.class);
        return "homepage";
    }

    @GetMapping("/practice")
    public String chooseTopic(Model model){
        ArrayList topics = restTemplate.getForObject("http://localhost:8081/api/topic/all", ArrayList.class);
        model.addAttribute("topics", topics);

        System.out.println(topics);

        return "practice";
    }
/*
    @GetMapping("/practice/{id}")
    public String quiz(@PathVariable Long id, Model model){
        Topic topic = tService.findTopic(id);
        model.addAttribute("topic", topic);

        Set<Flashcard> cardDeck = topic.getBox();
        model.addAttribute("cardDeck", cardDeck);

        return "quiz";
    }*/


//WORKING
    @GetMapping("/")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("player", new Player());
        return "register";
    }



    @GetMapping("/home")
    public String start(Model model) {
        ArrayList topics = restTemplate.getForObject("http://localhost:8081/api/topic/all", ArrayList.class);
        model.addAttribute("topics", topics);
        return "homepage";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("flashcard", new Flashcard());
        model.addAttribute("newTopic", new Topic());
        ArrayList topics = restTemplate.getForObject("http://localhost:8081/api/topic/all", ArrayList.class);
        model.addAttribute("topics", topics);


        return "flashcards";
    }



    @PostMapping("/saveTopic")
    public String setTopic(@ModelAttribute Topic topic){

        restTemplate.postForObject("http://localhost:8081/api/topic/save", topic, Topic.class);

        return "flashcards";
    }
}
