package org.example.shixun.serviceImpl;

import org.example.shixun.dao.MovieDao;
import org.example.shixun.domain.Movie;
import org.example.shixun.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("MovieService")
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDao movieDao;

    public List<Movie> queryMovieList(){
        return movieDao.queryMovieList();
    };

    public List<Movie> queryMovieList2(){
        List<Movie> movieList =movieDao.queryMovieList();
        for(int i=1;i<movieList.size();i++)
        {
            for(int j=0;j<i;j++)
            if(movieList.get(i).getTitle().equals(movieList.get(j).getTitle())) {
                movieList.remove(i);
                i--;
            }
        }
        System.out.println(movieList.size());
        return movieList;
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
