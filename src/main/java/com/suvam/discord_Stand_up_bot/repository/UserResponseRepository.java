package com.suvam.discord_Stand_up_bot.repository;

import com.suvam.discord_Stand_up_bot.entity.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserResponseRepository extends JpaRepository<UserResponse, Integer> {
}
