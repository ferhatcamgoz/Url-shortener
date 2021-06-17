package com.urlshortener.demo.url;

import com.urlshortener.demo.user.UserDTO;
import lombok.Data;

@Data
public class UrlDTO {
    private long id;

    private UserDTO userDTO;
    private String longUrl;

    private String shortUrl;

    public UrlDTO(Url url){
        this.longUrl=url.getLongUrl();
        this.shortUrl=url.getShortUrl();
        this.id=url.getId();
        this.userDTO=new UserDTO(url.getUser());
    }
}
