package org.example.shixun.controller;

import org.example.shixun.domain.Movie;
import org.example.shixun.domain.User;
import org.example.shixun.service.RecommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

//@Controller
@RestController
public class RecommandController {
    @Autowired
    private RecommandService recommandService;

    @RequestMapping(value = {"/recommand"}, method = RequestMethod.POST)
    public List<Movie> recommand(@RequestBody User user){
        List newList=recommandService.recommand(user);
        Collections.shuffle(newList);
        return newList.subList(0,8);
    };
}
