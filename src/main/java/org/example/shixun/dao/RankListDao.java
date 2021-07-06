package org.example.shixun.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.shixun.domain.RankList;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RankListDao {
    List<RankList> queryRankList();
}
