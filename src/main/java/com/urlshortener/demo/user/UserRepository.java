package com.urlshortener.demo.user;

import com.urlshortener.demo.url.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository  extends JpaRepository<User,Long> {

    User findByUserName(String userName);



}
