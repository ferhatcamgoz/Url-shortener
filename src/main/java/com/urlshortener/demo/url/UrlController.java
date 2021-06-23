package com.urlshortener.demo.url;

import com.urlshortener.demo.exception.Apiexception;
import com.urlshortener.demo.exception.NotFoundException;
import com.urlshortener.demo.user.User;
import com.urlshortener.demo.util.CurrnetUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.net.IDN;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@RestController
@RequestMapping(value = "/url")
public class UrlController {

    @Autowired
    UrlService urlService;



    @PostMapping
    public String setShortenUrl(@Valid @RequestBody Url url, @CurrnetUser User user, HttpServletRequest httpServletRequest) {

       return httpServletRequest.getRequestURL()+"/"+urlService.createShortUrl(url,user);

    }
    @RequestMapping(value="/{randomstring}", method=RequestMethod.GET)
    public void getShortenUrl(HttpServletResponse response, @PathVariable("randomstring") String randomString) throws IOException {
        String url =urlService.getLongUrl(randomString);
        if(url==null){
            throw new NotFoundException();
        }

        String idn = IDN.toASCII(url);
        String newURL = "http://" + idn;
        response.sendRedirect(newURL);
    }
    @RequestMapping(method= RequestMethod.GET)
    public Stream<UrlDTO> getUrls(@CurrnetUser User user,HttpServletRequest request) {
        List<Url> urlList = urlService.getUrls(user);

        for(Url url:urlList){
            url.setShortUrl(request.getRequestURL()+"/"+url.getShortUrl());
        }
        return urlList.stream().map(UrlDTO::new);

    }

    @DeleteMapping(value = "/{id:[0-9]+}")
    @PreAuthorize("@urlSecurityService.authorizationControl(#id,principal)")
    public void deleteUrl(@PathVariable("id")long id){

        urlService.delete(id);
    }

}
