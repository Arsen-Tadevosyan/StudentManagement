package com.example.studentmanagement.security;

import com.example.studentmanagement.entity.User;
import com.example.studentmanagement.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {


    private final TeacherService userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> byEmail = userRepository.findByEmail(username);

        if (byEmail.isEmpty()) {
            throw new UsernameNotFoundException("user with " + username + " dose not exists");
        }

        return new SpringUser(byEmail.get());
    }
}
