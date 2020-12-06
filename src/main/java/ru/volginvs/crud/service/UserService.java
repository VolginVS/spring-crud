package ru.volginvs.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.volginvs.crud.dao.UserDao;
import ru.volginvs.crud.model.User;

import java.util.List;

public interface UserService {

    public void save(User user);
    public User getUserById(Long id);
    public List<User> getUserList();
    public void update(User user);
    public void removeById(Long id);
}
