package com.gameflix.gameflix.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="game")
@Entity
public class Game {
    @Column(name="GAMEID")
    @Id //primary key
    private int gameId;
    @Column(name="NAME")
    private String name;
    @Column(name="GENRE")
    private String genre;
    @Column(name="RATING")
    private String rating;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameId=" + gameId +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }

    public void setRating(String rating) {
        this.rating = rating;


    }
}
