package com.example.movierecommendation.serviceImpl;

import com.example.movierecommendation.mapper.MovieMapper;
import com.example.movierecommendation.pojo.Movie;
import com.example.movierecommendation.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("MovieService")
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieMapper moviemapper;

    public List<Movie> queryMovieList(){
        return moviemapper.queryMovieList();
    };

    public Movie queryMovieByTitle(String title){
        return moviemapper.queryUserByTitle(title);
    };

    public Movie queryMovieByTypename(String typename){
        return moviemapper.queryUserByTypename(typename);
    };

    public int deleteMovie(String title){
        return moviemapper.deleteMovie(title);
    };

}
