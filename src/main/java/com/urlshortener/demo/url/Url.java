package com.urlshortener.demo.url;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.urlshortener.demo.user.User;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Data
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @Pattern(regexp = "(http:\\/\\/www\\.|https:\\/\\/www\\.|http:\\/\\/|https:\\/\\/)?[a-z0-9-_ğüşıöçĞÜŞİÖÇ]+([\\-\\.]{1}[a-z0-9-_ğüşıöçĞÜŞİÖÇ]+)*\\.[a-z-_ğüşıöçĞÜŞİÖÇ]{2,5}(:[0-9]{1,5})?(\\/.*)?$", message = "url giriş hayası")
    private String longUrl;


    private String shortUrl;

    @ManyToOne
    private User user;


}
