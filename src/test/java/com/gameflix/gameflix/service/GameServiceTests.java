package com.gameflix.gameflix.service;

import com.gameflix.gameflix.model.Game;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameServiceTests {
    @Autowired
    private GameService gameService;

    @Test
    public void testGetAllGames() {
        List<Game> game = gameService.getAllGames();
        assertNotNull(game);
    }

    //test 2
    @Test
    public void testFindByGenre() {
        List<String> genre = new ArrayList<>();
        genre.add("Adventure");
        genre.add("Action");
        List<Game> game = gameService.getGamesByGenreAndRating(genre, null);
        assertNotNull(game);
    }

    @Test
    public void testFindByRating() {
        List<String> rating = new ArrayList<>();
        rating.add("E");
        rating.add("M");
        List<Game> movies = gameService.getGamesByGenreAndRating(null, rating);
        assertNotNull(movies);
    }
}













