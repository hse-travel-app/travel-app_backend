package tinkoff.tourism.dao;

import org.apache.ibatis.annotations.Mapper;
import tinkoff.tourism.model.User;

import java.util.List;

@Mapper
public interface UserRepository {
    void addUser(User user);

    List<User> findAll();

    User findById(Long id);

    List<User> findByName(String name);

    User findByLogin(String login);

    List<User> findByAuthority(String authority);

    void updateUser(User user);

    void delete(Long id);

    void deleteAll();

    User isUserExists(String login);
}
