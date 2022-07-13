package com.example.flashcardsapp.flashcard;


import com.example.flashcardsapp.player.Player;
import com.example.flashcardsapp.player.PlayerRepository;
import com.example.flashcardsapp.topic.Topic;
import com.example.flashcardsapp.topic.TopicRepository;
import com.example.flashcardsapp.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
public class FlashcardController {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    FlashcardRepository repository;
    @Autowired
    TopicRepository topicRepository;
    @Autowired
    TopicService tService;


    @GetMapping("/home")
    public String start(Model model) {
        List<Topic> topics = topicRepository.findAll();
        model.addAttribute("topics", topics);
        return "homepage";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("flashcard", new Flashcard());
        List<Topic> topics = topicRepository.findAll();
        model.addAttribute("topics", topics);

        model.addAttribute("topic", new Topic());

        return "flashcards";
    }
    @PostMapping("/save")
    public String set(@ModelAttribute Flashcard flashcard,
                      @RequestParam Topic topics,
                      @RequestParam String term,
                      @RequestParam String answer){
        flashcard.setTerm(term);
        flashcard.setAnswer(answer);
        flashcard.setTopic(topics);
        repository.save(flashcard);

        return "redirect:/";
    }

    @PostMapping("/saveTopic")
    public String setTopic(@ModelAttribute Topic topic, @RequestParam String name){
        topic.setName(name);
        topicRepository.save(topic);
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

        Set<Flashcard> cardDeck = topic.getBox();
        model.addAttribute("cardDeck", cardDeck);



        return "quiz";
    }

    @PostMapping("/quiz")
    public String quizPost(@ModelAttribute Player player){


        return"quiz";
    }

    @GetMapping("/")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("player", new Player());

        return "register";
    }

    @PostMapping("/savePlayer")
    public String savePlayer(@ModelAttribute Player player, @RequestParam String username,
                             @RequestParam String pw){
        player.setUsername(username);
        player.setPw(pw);

        playerRepository.save(player);

        return "homepage";
    }
}
