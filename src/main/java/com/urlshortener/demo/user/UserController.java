package com.urlshortener.demo.user;

import com.urlshortener.demo.url.Url;
import com.urlshortener.demo.util.CurrnetUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    final UserRepository userRepository;

    final PasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository,PasswordEncoder passwordEncoder) {
        this.passwordEncoder=passwordEncoder;
        this.userRepository = userRepository;
    }

    @PostMapping("/auth")
    UserDTO handleAuth( @CurrnetUser User user){

        return new UserDTO(user);
    }

    @PostMapping("/kayit")
    public UserDTO createUser(@Valid @RequestBody User user){

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println(user);
      return   new  UserDTO(userRepository.save(user));
    }


}
