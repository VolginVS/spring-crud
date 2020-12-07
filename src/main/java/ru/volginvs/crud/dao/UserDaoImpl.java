package ru.volginvs.crud.dao;

import org.springframework.stereotype.Repository;
import ru.volginvs.crud.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.createQuery("from User where id = :id ", User.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<User> getUserList() {
        return entityManager.createQuery("from User", User.class)
                .getResultList();
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public void removeById(Long id) {
        User user = getUserById(id);
        entityManager.remove(user);
    }
}
