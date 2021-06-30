package com.example.movierecommendation.service;

import com.example.movierecommendation.pojo.Movie;

import java.util.List;
import java.util.SplittableRandom;

public interface MovieService {

    public List<Movie> queryMovieList();

    public Movie queryMovieByTitle(String title);

    public Movie queryMovieByTypename(String typename);

    public int deleteMovie(String title);
}
