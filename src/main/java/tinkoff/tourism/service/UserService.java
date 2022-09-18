package tinkoff.tourism.service;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tinkoff.tourism.controller.exception.UserAlreadyExistsException;
import tinkoff.tourism.dao.UserRepository;
import tinkoff.tourism.model.User;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    private final PasswordEncoder encoder =
            PasswordEncoderFactories.createDelegatingPasswordEncoder();

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void addUser(User user) {
        if (!repository.isUserExists(user.getLogin())) {
            user.setPassword(encoder.encode(user.getPassword()));
            repository.addUser(user);
        } else {
            throw new UserAlreadyExistsException(String.format("User with login %s already exists", user.getLogin()));
        }
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        return repository.findById(id);
    }

    public List<User> findByName(String name) {
        return repository.findByName(name);
    }

    public User findByLogin(String login) {
        return repository.findByLogin(login);
    }

    public List<User> findByAuthority(String authority) {
        return repository.findByAuthority(authority);
    }

    public void updateUser(User user) {
        repository.updateUser(user);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public Boolean isUserExists(String login) {
        return repository.isUserExists(login);
    }

    public Boolean auth(String login, String password) {
        User requested = repository.findByLogin(login);
        if (requested == null) return false;
        return encoder.matches(password, requested.getPassword());
    }
}
