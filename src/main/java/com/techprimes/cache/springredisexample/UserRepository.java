package com.techprimes.cache.springredisexample;

import com.techprimes.cache.springredisexample.model.User;

public interface UserRepository {
    void save(User user);
    User findById(int id);

}
