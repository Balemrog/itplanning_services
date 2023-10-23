package com.timetech.itplanning_services.service;

import com.timetech.itplanning_services.dao.UserRepository;
import com.timetech.itplanning_services.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Profile("default")
public class UserServiceImpl implements UserService{

    private final UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository repository){
        this.repository = repository;
    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        return repository.findByLogin(login);
    }

    @Override
    public List<User> getAllUser() {
        return repository.findAll();
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public boolean hasUserWithLogin(String login) {
        return repository.existsByLogin(login);
    }

    @Override
    public Optional<User> validLoginAndPassword(String login, String password) {
        return getUserByLogin(login).filter(user -> passwordEncoder.matches(password, user.getPassword()));
    }

//    @Override
//    public User registerNewUserAccount(UserDto accountDto) throws EmailExistsException {
//        if (emailExist(accountDto.getEmail())) {
//            throw new EmailExistsException(
//                    "There is an account with that email adress:" + accountDto.getEmail());
//        }
//        User user = new User();
//        user.setFirstName(accountDto.getFirstName());
//        user.setLastName(accountDto.getLastName());
//
//        user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
//
//        user.setEmail(accountDto.getEmail());
//        user.setRole(new Role(Integer.valueOf(1), user));
//        return repository.save(user);
//    }
}
