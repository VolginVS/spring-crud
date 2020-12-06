package ru.volginvs.crud.dao;

import ru.volginvs.crud.model.User;

import java.util.List;

public interface UserDao {

    public void save(User user);
    public User getUserById(Long id);
    public List<User> getUserList();
    public void update(User user);
    public void removeById(Long id);
}
