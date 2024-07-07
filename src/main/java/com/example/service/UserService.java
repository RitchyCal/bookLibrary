package com.example.service;

import com.example.api.model.request.UserModel;
import com.example.api.model.response.UserDTO;
import com.example.exceptions.UserNotFoundException;
import com.example.mapper.UserDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.api.model.User;
import com.example.repo.UserRepository;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserDTOMapper userDTOMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, UserDTOMapper userDTOMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userDTOMapper = userDTOMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDTO getUser(long id) throws UserNotFoundException {
        return userRepository.findByUserid(id).map(userDTOMapper).orElseThrow(() ->new  UserNotFoundException(id));
    }
    public void createUser(UserModel entity) {
        User user = new User();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(entity.getPassword());
        user.setFirstname(entity.getFirstname());
        user.setLastname(entity.getLastname());
        user.setPassword(hashedPassword);
        user.setUsername(entity.getUsername());
        userRepository.save(user);
    }

    public void updateUser(Long userId, UserModel userModel){
        User user = userRepository.findByUserid(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        user.setUsername(userModel.getUsername());
        user.setEmail(userModel.getEmail());
        if(userModel.getPassword() != null &&  !userModel.getPassword().isEmpty()){
            user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        }

        userRepository.save(user);
    }

    public void deleteUser(Long userId){
        User user = userRepository.findByUserid(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        userRepository.delete(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
