package com.gameflix.gameflix.service;
import com.gameflix.gameflix.model.Game;
import org.springframework.data.domain.Page;
import java.util.List;

public interface GameService {
    List<Game> getAllGames();
    void saveGame(Game game);

}
