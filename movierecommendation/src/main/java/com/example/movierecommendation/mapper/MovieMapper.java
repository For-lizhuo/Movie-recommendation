package com.example.movierecommendation.mapper;

import com.example.movierecommendation.pojo.Movie;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.SplittableRandom;

@Mapper
@Repository
public interface MovieMapper {

    List<Movie> queryMovieList();

    Movie queryUserByTitle(String title);

    Movie queryUserByTypename(String typename);

    int addUser(String title, String actor, String img, String score, String typename);

    int updateMovie(Movie movie);

    int deleteMovie(String username);
}
