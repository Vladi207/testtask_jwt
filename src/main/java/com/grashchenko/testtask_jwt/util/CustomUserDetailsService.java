package com.grashchenko.testtask_jwt.util;

import com.grashchenko.testtask_jwt.model.User;
import com.grashchenko.testtask_jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByName(username);

        if (user.isEmpty())
            throw new UsernameNotFoundException("User not found!");

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.get().getName())
                .password(user.get().getPassword())
                .build();
    }
}
