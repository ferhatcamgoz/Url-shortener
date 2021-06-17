package com.urlshortener.demo.url;

import com.urlshortener.demo.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrlRepository extends JpaRepository<Url,Long> {

    Url findByShortUrl(String shortUrl);

    Url findByLongUrl(String longUrl);


    List<Url> findByUser(User user);
}
