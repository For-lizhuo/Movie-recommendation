package org.example.shixun.serviceImpl;

import org.example.shixun.dao.MovieDao;
import org.example.shixun.dao.UserDao;
import org.example.shixun.domain.Movie;
import org.example.shixun.domain.User;
import org.example.shixun.service.RecommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("RecommandService")
public class RecommandServiceImpl implements RecommandService {

    @Autowired
    private MovieDao movieDao;
    public List<Movie> recommand(User user){
        String type=user.getLabel();
        return movieDao.queryUserByType(type);
    }
}
