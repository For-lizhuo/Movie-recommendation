package org.example.shixun.serviceImpl;

import org.example.shixun.dao.RankListDao;
import org.example.shixun.domain.RankList;
import org.example.shixun.service.RankListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("RankListService")
public class RankListServiceImpl implements RankListService {

    @Autowired
    private RankListDao rankListDao;

    public List<RankList> queryRankList(){
        return rankListDao.queryRankList();
    }
}
