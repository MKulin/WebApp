package webApp.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import webApp.model.Human;

import java.util.List;

@org.springframework.stereotype.Repository
public class HumanRepositoryImpl implements Repository<Human> {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional
    public Human get(long id) {
        Human result = (Human)getSession().get(Human.class, id);
        return result;
    }

    @Override
    @Transactional
    public Human getByName(String name) {
        Human result = (Human) getSession().createQuery("select * from human where username = '" + name + "'");
        return result;
    }

    @Override
    @Transactional
    public void set(Human value) {
        getSession().save(value);
    }

    @Override
    @Transactional
    public void update(Human value) {
        Human forUpdate = get(value.getId());
        forUpdate.setFirstName(value.getFirstName());
        forUpdate.setLastName(value.getLastName());
        forUpdate.setUsername(value.getUsername());
        forUpdate.setEmail(value.getEmail());
        forUpdate.setPassword(value.getPassword());
        getSession().update(forUpdate);
    }

    @Override
    @Transactional
    public void delete(Human value) {
        Human forDelete = get(value.getId());
        if(forDelete != null)
            getSession().delete(forDelete);
    }

    @Override
    @Transactional
    public List<Human> list() {
        return getSession().createQuery("from human").list();
    }
}
