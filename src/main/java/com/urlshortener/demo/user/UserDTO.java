package com.urlshortener.demo.user;

import lombok.Data;

@Data
public class UserDTO {

    private String userName;
    public  UserDTO(User user){
        this.userName=user.getUsername();
    }
}
