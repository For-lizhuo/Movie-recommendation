package org.example.shixun.controller;

import org.example.shixun.domain.Movie;
import org.example.shixun.domain.User;
import org.example.shixun.service.RecommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

//@Controller
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class RecommandController {
    @Autowired
    private RecommandService recommandService;

    @RequestMapping(value = {"/recommand"}, method = RequestMethod.POST)
    public List<Movie> recommand(@RequestBody User user){
        List newList=recommandService.recommand(user);
        if(newList.size()<8)
            return newList;
        else Collections.shuffle(newList);
        return newList.subList(0,8);
    };
}
