package com.suvam.discord_Stand_up_bot.service;

import com.suvam.discord_Stand_up_bot.entity.UserResponse;
import com.suvam.discord_Stand_up_bot.repository.UserResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {

    @Autowired
    private UserResponseRepository userResponseRepository;

    public void saveResponse(UserResponse userResponse) {
        userResponseRepository.save(userResponse);
    }

}
