package com.example.flashcardsapp.flashcard;

import com.example.flashcardsapp.flashcard.Flashcard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlashcardRepository extends JpaRepository<Flashcard,Long> {
}
