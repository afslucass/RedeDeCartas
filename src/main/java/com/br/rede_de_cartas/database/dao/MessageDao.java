package com.br.rede_de_cartas.database.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.br.rede_de_cartas.database.table.MessageTable;

public class MessageDao {
    EntityManagerFactory factory;
    EntityManager manager;

    public MessageDao(EntityManagerFactory factory){
        this.factory = factory;
        this.manager = factory.createEntityManager();
    }

    public MessageTable getMessageById(Long id){
        MessageTable message = manager.find(MessageTable.class, id);
        return message;
    }
    public ArrayList<?> getMessageList(){
        ArrayList<?> list = (ArrayList<?>) manager.createQuery("SELECT c FROM MessageTable AS c").getResultList();
        return list;
    }
    public void addMessage(MessageTable message){
        manager.getTransaction().begin();
        manager.persist(message);
        manager.getTransaction().commit();
    }
    public void removeMessage(MessageTable message){
        manager.getTransaction().begin();
        manager.remove(message);
        manager.getTransaction().commit();
    }
    public void updateMessage(MessageTable message){
        manager.getTransaction().begin();
        manager.merge(message);
        manager.getTransaction().commit();
    }
}