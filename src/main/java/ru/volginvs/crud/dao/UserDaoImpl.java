package ru.volginvs.crud.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.volginvs.crud.model.User;
import ru.volginvs.crud.service.UserService;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public User getUserById(Long id) {
        return sessionFactory.getCurrentSession().createQuery("from User where id = :id ", User.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<User> getUserList() {
        return sessionFactory.getCurrentSession().createQuery("from User", User.class)
                .list();
    }

    @Override
    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void removeById(Long id) {
        User user = getUserById(id);
        sessionFactory.getCurrentSession().remove(user);
    }
}
