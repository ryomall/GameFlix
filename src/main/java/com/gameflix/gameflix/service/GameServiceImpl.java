package com.gameflix.gameflix.service;

import com.gameflix.gameflix.model.Game;
import com.gameflix.gameflix.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.util.List;


    @Service
    public class GameServiceImpl implements GameService {

        @Autowired
        private GameRepository gameRepository;

        @Override
        public List<Game> getAllGames() {
            return gameRepository.findAll();
        }

        @Override
        public List<Game>getGamesByGenreAndRating(List <String> genre, List <String> rating) {

            if ((genre == null || genre.isEmpty()) && (!rating.isEmpty() || rating != null)) {
                // return gameRepository.searchByRating(genre);
                return gameRepository.findByRatingIn(rating);
            }
            else if ((rating == null || rating.isEmpty()) && (!genre.isEmpty() || genre != null)) {
                return gameRepository.findByGenreIn(genre);
            }
            else return gameRepository.searchByGenreAndRatingIn(genre, rating);
        }

        @Override
        public void saveGame(Game Game) {
            this.gameRepository.save(Game);
        }
    }
