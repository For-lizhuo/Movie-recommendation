package org.example.shixun.serviceImpl;

import org.example.shixun.dao.MovieDao;
import org.example.shixun.dao.UserDao;
import org.example.shixun.domain.Movie;
import org.example.shixun.domain.User;
import org.example.shixun.service.RecommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("RecommandService")
public class RecommandServiceImpl implements RecommandService {

    @Autowired
    private MovieDao movieDao;
    public List<Movie> recommand(User user){
        String type=user.getLabel();
        System.out.println(type);
        String[] split = type.split(",");
        List<Movie> movieList = new ArrayList<>();
        System.out.println(split.length);
        for(int i=0;i<split.length;i++) {
            System.out.println(split[i]);
            movieList.addAll(movieDao.queryUserByType(split[i]));
        }
        return movieList;
    }
}
