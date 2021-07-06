package org.example.shixun.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RankList {
    private int id;
    private String title;
    private String actor;
    private String score;
    private String link;
    private String source;
}
