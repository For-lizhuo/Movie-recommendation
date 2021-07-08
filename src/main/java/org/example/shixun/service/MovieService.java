package org.example.shixun.service;

import org.example.shixun.domain.Movie;

import java.util.List;

public interface MovieService {

    public List<Movie> queryMovieList();

    public List<Movie> searchMovieList();

    public List<Movie> queryMovieList2();

    public List<Movie> queryMovieByTitle(String title);

    public List<Movie> queryMovieByTitle2(String title);

    public List<Movie> queryMovieByType(String type);

    public int deleteMovie(String title);
}
