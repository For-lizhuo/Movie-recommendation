package org.example.shixun.service;

import org.example.shixun.domain.Movie;
import org.example.shixun.domain.User;

import java.util.List;

public interface RecommandService {
    public List<Movie> recommand(User user);
}
