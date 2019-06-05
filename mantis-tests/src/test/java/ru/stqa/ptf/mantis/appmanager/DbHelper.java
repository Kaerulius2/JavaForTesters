package ru.stqa.ptf.mantis.appmanager;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.stqa.ptf.mantis.model.User;
import ru.stqa.ptf.mantis.model.Users;

import java.util.List;

public class DbHelper {

    private final SessionFactory sessionFactory;

    public DbHelper() {

        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
    }

    public User getAnyUserFromBD() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<User> result = session.createQuery( "from User where access_level<90" ).list();
        session.getTransaction().commit();
        session.close();
        User us = result.iterator().next();
        return new User().withId(us.getId()).withUsername(us.getUsername()).withEmail(us.getEmail()).withAccessLevel(us.getAccessLevel());
    }
}
