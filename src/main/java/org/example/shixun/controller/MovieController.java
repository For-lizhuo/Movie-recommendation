package org.example.shixun.controller;

import org.example.shixun.domain.Movie;
import org.example.shixun.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
@RequestMapping("/movie")
@CrossOrigin(origins = "*",maxAge = 3600)
public class MovieController {
    @Autowired
    private MovieService movieService;


    @GetMapping(value = {"movieList"})
    public List<Movie> getMovie()
    {
        return movieService.queryMovieList();
    }

    @GetMapping(value = {"getMovieList"})
    public List<Movie> getMovie2()
    {
        return movieService.queryMovieList2();
    }

    @GetMapping(value = {"searchMovieList"})
    public List<Movie> searchMovie()
    {
        return movieService.searchMovieList();
    }

    @RequestMapping(value = {"/searchByType"}, method = RequestMethod.POST)
    public List<Movie> searchMovieByType(@RequestParam(value = "type") String type)
    {
        return movieService.queryMovieByType(type);
    }

    //精确查询
    @RequestMapping(value = {"/searchByTitle"}, method = RequestMethod.POST)
    public List<Movie> searchMovieByTitle1(@RequestParam(value = "title") String type)
    {
        return movieService.queryMovieByTitle(type);
    }

    //模糊查询
    @RequestMapping(value = {"/searchByTitle2"}, method = RequestMethod.POST)
    public List<Movie> searchMovieByTitle2(@RequestParam(value = "title") String type)
    {
        return movieService.queryMovieByTitle2(type);
    }

}
