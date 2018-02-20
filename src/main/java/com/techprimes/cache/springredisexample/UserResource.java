package com.techprimes.cache.springredisexample;

import com.techprimes.cache.springredisexample.model.User;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserResource {

    private UserRepository userRepository;

    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/auth")
    public ResponseEntity<User> login(@RequestBody User user){

        if(userRepository.findById(user.getId()) == null){
            return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<User>(HttpStatus.OK);
    }

    @RequestMapping(method = {RequestMethod.POST, }, value = "/api/add")
    public ResponseEntity<User> add(@RequestBody User user){
        userRepository.save(user);
        return new ResponseEntity<User>(HttpStatus.OK);
    }

}
