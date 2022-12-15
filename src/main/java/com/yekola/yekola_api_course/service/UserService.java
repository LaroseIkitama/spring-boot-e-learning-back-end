package com.yekola.yekola_api_course.service;

import com.yekola.yekola_api_course.domain.User;
import com.yekola.yekola_api_course.exception.EntityNotFoundException;
import com.yekola.yekola_api_course.exception.RequestException;
import com.yekola.yekola_api_course.mapper.UserMapper;
import com.yekola.yekola_api_course.repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class UserService {
    UserRepository userRepository;

    UserMapper userMapper;

    MessageSource messageSource;

    public User createUser(User user) {
        userRepository.findById(user.getId())
                .ifPresent(entity -> {
                    throw new RequestException(messageSource.getMessage("user.exists", new Object[]{user.getId()},
                            Locale.getDefault()), HttpStatus.CONFLICT);
                });
        log.info("Saving new User: {} to database",user.getUsername());

        return userMapper.toUser(userRepository.save(userMapper.fromUser(user)));
    }

    public User updateUser(User user){
        log.info("Update user: {} ",user.getUsername());

        return userRepository.findById(user.getId())
                .map(entity -> {
                    return userMapper.toUser(
                            userRepository.save(userMapper.fromUser(user)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("user.notfound", new Object[]{user.getId()},
                        Locale.getDefault())));
    }

    public void deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
            log.info("User id: {} has been deleted",id);

        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("user.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }

    public User getUser(Long id) {
        log.info("Fetching user: {} ",id);

        return userMapper.toUser(userRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("user.notfound", new Object[]{id},
                        Locale.getDefault()))));
    }



    public List<User> getUsers(){
        log.info("Fetching all users");

        return userRepository.findAll().stream()
                .map(userMapper::toUser)
                .collect(Collectors.toList());
    }

}
