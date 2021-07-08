package org.example.shixun.controller;

import org.example.shixun.domain.RankList;
import org.example.shixun.service.RankListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
@RequestMapping("/rank")
@CrossOrigin(origins = "*",maxAge = 3600)
public class RankListController {
    @Autowired
    private RankListService rankListService;

    @GetMapping(value = {"movieList"})
    public List<RankList> getRankList()
    {
        return rankListService.queryRankList();
    }
}
