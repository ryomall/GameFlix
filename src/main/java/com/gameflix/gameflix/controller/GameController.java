package com.gameflix.gameflix.controller;


import com.gameflix.gameflix.model.Game;
import com.gameflix.gameflix.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(path="/game") // did this becasue Im going to
//create other controllers and this wont conflict localhost/courses/getcourses
@RestController
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping("/")  //endpoint
    public List<Game> getGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/hello")  //endpoint
    public String hello() {
        return "hello";
    }
}


