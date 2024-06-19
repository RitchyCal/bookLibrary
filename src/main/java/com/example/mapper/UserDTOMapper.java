package com.example.mapper;

import com.example.api.model.User;
import com.example.api.model.response.UserDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserDTOMapper implements Function<User, UserDTO> {
    @Override
    public UserDTO apply(User user){
        return new UserDTO(
                user.getUsername(),
                user.getUser_id()
        );
    }
}
