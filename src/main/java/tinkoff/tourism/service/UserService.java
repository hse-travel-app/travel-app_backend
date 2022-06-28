package tinkoff.tourism.service;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;
import tinkoff.tourism.dao.UserRepository;
import tinkoff.tourism.model.User;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void addUser(User user) throws Exception {
        if (repository.isUserExists(user.getLogin()) == null) {
            user.setPassword(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(user.getPassword()));
            repository.addUser(user);
        } else {
            throw new Exception();
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

    public User isUserExists(String login) {
        return repository.isUserExists(login);
    }
}