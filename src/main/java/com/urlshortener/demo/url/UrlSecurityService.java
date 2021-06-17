package com.urlshortener.demo.url;

import com.urlshortener.demo.user.User;
import com.urlshortener.demo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UrlSecurityService {


    @Autowired
    UrlRepository urlRepository;
    public boolean authorizationControl(long id, User user) {

        Optional<Url> url =urlRepository.findById(id);
        if (!url.isPresent()) {
            return false;
        }

        if (url.get().getUser().getId() != user.getId()) {

            return false;
        }


        return true;
    }
}
