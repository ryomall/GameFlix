package com.gameflix.gameflix.controller;


import com.gameflix.gameflix.model.Game;
import com.gameflix.gameflix.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(path="/game") //if you put this here it means for rest of class the "/" starts with game // did this becasue Im going to
//create other controllers and this wont conflict localhost/courses/getcourses
@RestController
public class GameController {
   // Genral connecting of gameservice and contorller.
    @Autowired
    private GameService gameService;

    @GetMapping("/")  //endpoint
    public List<Game> getGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/search")  //endpoint
    // creating a function inside the controller whos
    //purpose is to return gameSercives' getGames by Genre and raign
    public List<Game> getGamesByGenreAndRating(@RequestParam(required = false) List <String> genre, @RequestParam(required = false) List <String> rating) {
       System.out.println("lkjlk"+genre+rating);
        return gameService.getGamesByGenreAndRating(genre, rating);
    }

    @GetMapping("/hello")  //endpoint
    public String hello() {
        return "hello";
    }
}


