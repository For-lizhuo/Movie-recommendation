package com.example.movierecommendation.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
        private int user_id;
        private String account;
        private String username;
        private String password;
        private String profile;
        private String picture;
        private String sex;
        private int age;
        private String register_way;

}
