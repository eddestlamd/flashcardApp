package com.example.flashcardsapp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlashcardRepository extends JpaRepository<Flashcard,Integer> {
}
