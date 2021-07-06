package org.example.shixun.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.shixun.domain.Movie;
import org.example.shixun.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MovieDao {
    List<Movie> queryMovieList();

    List<Movie> queryUserByTitle(String title);

    List<Movie> queryUserByTitle2(String title);

    List<Movie> queryUserByType(String type);

    int updateMovie(Movie movie);

    int deleteMovie(String username);
    
}
