package com.gameflix.gameflix.repository;
import com.gameflix.gameflix.model.Game;
import com.gameflix.gameflix.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
   // @Query("SELECT g FROM Game g " +
   //         "WHERE (g.genre IN (:genre))"
   // )
   // List<Game> searchByGenre(@Param("genre") List <String> genre);

    //@Query("SELECT g FROM Game g " +
    //        "WHERE (g.rating IN (:rating))"
   // )
    //List<Game> searchByRating( @Param("rating") List <String> rating);

    //List<Game> findByGenreAndRatingIn (@Param("genre") List <String> genre, @Param("rating") List <String> rating);

    List<Game> findByGenreIn(@Param("genre") List <String> genre);
    List<Game> findByRatingIn(@Param("genre") List <String> rating);


    @Query("SELECT g FROM Game g " +
            "WHERE (g.rating IN (:rating)) AND (g.genre IN (:genre))"
     )
    List<Game> searchByGenreAndRatingIn (@Param("genre") List <String> genre, @Param("rating") List <String> rating);

}
