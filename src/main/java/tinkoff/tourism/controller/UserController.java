package tinkoff.tourism.controller;

import org.springframework.web.bind.annotation.*;
import tinkoff.tourism.model.User;
import tinkoff.tourism.service.UserService;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void addUser(@RequestBody @Valid User user) {
        service.addUser(user);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public User getUser(@RequestParam("id") Long id) {
        return service.findById(id);
    }

    @GetMapping(value = "all", produces = APPLICATION_JSON_VALUE)
    public List<User> getUsers() {
        return service.findAll();
    }

    @GetMapping(value = "name", produces = APPLICATION_JSON_VALUE)
    public List<User> getUsersByName(@RequestParam("name") String name) {
        return service.findByName(name);
    }

    @GetMapping(value = "login", produces = APPLICATION_JSON_VALUE)
    public User getUserByLogin(@RequestParam("login") String login) {
        return service.findByLogin(login);
    }

    @GetMapping(value = "authority", produces = APPLICATION_JSON_VALUE)
    public List<User> getUsersByAuthority(@RequestParam("authority") String authority) {
        return service.findByAuthority(authority);
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public void updateUser(@RequestBody @Valid User user) {
        service.updateUser(user);
    }

    @DeleteMapping
    public void deleteUser(@RequestParam("id") Long id) {
        service.delete(id);
    }

    @DeleteMapping(value = "all")
    public void deleteUsers() {
        service.deleteAll();
    }

    @GetMapping(value = "exists")
    public Boolean isUserExists(@RequestParam("login") String login) {
        return service.isUserExists(login);
    }
}
