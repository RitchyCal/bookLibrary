package service;

import org.springframework.stereotype.Service;

import api.model.User;
import repo.UserRepository;

@Service
public class UserService {
    // will be a db call to get user
   
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public User getUser(int id) {
        return userRepository.findById(id);
    }
    public void createUser(User entity) {
        userRepository.save(entity);
    }

}
