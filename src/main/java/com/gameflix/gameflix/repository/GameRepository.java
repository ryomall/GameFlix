package com.gameflix.gameflix.repository;
import com.gameflix.gameflix.model.Game;
import com.gameflix.gameflix.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
}
