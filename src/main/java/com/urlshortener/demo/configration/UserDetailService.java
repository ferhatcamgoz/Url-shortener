package com.urlshortener.demo.configration;


import com.urlshortener.demo.user.User;
import com.urlshortener.demo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
       User user = userRepository.findByUserName(s);
        System.out.println("giriş yapılan"+s);
        if(user==null){
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}
