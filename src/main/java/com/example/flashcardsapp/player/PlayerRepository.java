package com.example.flashcardsapp.player;

import com.example.flashcardsapp.player.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,Long> {
}
