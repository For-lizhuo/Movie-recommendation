package org.example.shixun.controller;

import org.example.shixun.domain.Movie;
import org.example.shixun.domain.User;
import org.example.shixun.result.CodeMsg;
import org.example.shixun.result.Result;
import org.example.shixun.service.RecommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

//@Controller
@RestController
@CrossOrigin(origins = "http://localhost:3000",maxAge = 3600)
public class RecommandController {
    @Autowired
    private RecommandService recommandService;

    @RequestMapping(value = {"/recommand"}, method = RequestMethod.POST)
    @ResponseBody
    public Result<List> recommand(User user){
        if(user == null){
            return Result.error(CodeMsg.SESSION_ERROR);
        }
        List newList=recommandService.recommand(user);
        if(newList.size()<8)
            return Result.success(newList);
        else Collections.shuffle(newList);
        return Result.success(newList.subList(0,8));
    };
}
