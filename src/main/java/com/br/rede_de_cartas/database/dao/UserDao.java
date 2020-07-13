package com.br.rede_de_cartas.database.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.br.rede_de_cartas.database.table.UserTable;

import org.hibernate.query.Query;

public class UserDao {
    EntityManagerFactory factory;
    EntityManager manager;
    
    public UserDao(EntityManagerFactory factory){
        this.factory = factory;
    }

    public UserTable getUserById(Long id){
        manager = factory.createEntityManager();
        UserTable user = manager.find(UserTable.class, id);
        manager.close();
        return user;
    }
    public ArrayList<?> getUserList(){
        manager = factory.createEntityManager();
        ArrayList<?> list = (ArrayList<?>) manager.createQuery("SELECT c FROM UserTable AS c").getResultList();
        manager.close();
        return list;
    }
    public UserTable getUserByNameAndPassword(String name, String password){
        manager = factory.createEntityManager();
        Query query = (Query) manager.createQuery("SELECT c FROM UserTable AS c WHERE c.nome = :nick AND c.senha = :senha ");
        query.setParameter("nick", name);
        query.setParameter("senha", password);
        
        UserTable user = (UserTable)query.uniqueResult();
        manager.close();
        return user;
    }
    public void addUser(UserTable user){
        manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(user);
        manager.getTransaction().commit();
        manager.close();
    }
    public void removeUser(UserTable user){
        manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.remove(user);
        manager.getTransaction().commit();
        manager.close();
    }
    public void updateUser(UserTable user){
        manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.merge(user);
        manager.getTransaction().commit();
        manager.close();
    }
}