package org.example.shixun.serviceImpl;

import org.example.shixun.dao.MovieDao;
import org.example.shixun.domain.Movie;
import org.example.shixun.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("MovieService")
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDao movieDao;

    public List<Movie> queryMovieList(){
        return movieDao.queryMovieList();
    };

    public List<Movie> searchMovieList(){return movieDao.searchMovieList();};

    public List<Movie> queryMovieByTitle(String title){
        return movieDao.queryUserByTitle(title);
    };

    public List<Movie> queryMovieByTitle2(String title){
        return movieDao.queryUserByTitle2(title);
    };

    public List<Movie> queryMovieByType(String typename){
        return movieDao.queryUserByType(typename);
    };

    public int deleteMovie(String title){
        return movieDao.deleteMovie(title);
    };
}
