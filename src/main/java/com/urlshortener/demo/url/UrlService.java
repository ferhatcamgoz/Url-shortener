package com.urlshortener.demo.url;

import com.urlshortener.demo.user.User;
import com.urlshortener.demo.util.UrlDuplicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.urlshortener.demo.util.UrlDuplicate.stringSet;

@Service
public class UrlService {

    @Autowired
    UrlRepository urlRepository;

    public String createShortUrl(Url url, User user){
        List<Url> urlList = urlRepository.findByUser(user);

        for (Url url1:urlList){
            if(url.getLongUrl().equals(url1.getLongUrl())){
                System.out.println("long url var yeniye gerek yok");
                return url1.getShortUrl();
            }
        }



            String newUrl=getRandomChars();
            int count = stringSet.size();

            stringSet.add(newUrl);
            while (true){
                //uniqe short url oluşturulana kadar deneme yanılma
                if(count<stringSet.size()) break;
                newUrl=getRandomChars();
                count = stringSet.size();
                stringSet.add(newUrl);
            }
            url.setShortUrl(newUrl);
            url.setUser(user);
            urlRepository.save(url);
            return newUrl;




    }
    public String getLongUrl(String shortUrl){
        System.out.println(shortUrl);

        return urlRepository.findByShortUrl(shortUrl).getLongUrl();




    }

    private String getRandomChars() {
        String randomStr = "";
        String possibleChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        for (int i = 0; i < 5; i++)
            randomStr += possibleChars.charAt((int) Math.floor(Math.random() * possibleChars.length()));
        return randomStr;
    }

    public List<Url> getUrls(User user) {
        return urlRepository.findByUser(user);
    }

    public void delete(long id) {
         urlRepository.deleteById(id);
    }
}
