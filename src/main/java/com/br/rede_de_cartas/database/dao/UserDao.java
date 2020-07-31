package com.br.rede_de_cartas.database.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.br.rede_de_cartas.bean.LetterBean;
import com.br.rede_de_cartas.database.table.MessageTable;
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
    public UserTable getUserByNameAndPassword(String nick, String password){
        manager = factory.createEntityManager();
        Query query = (Query) manager.createQuery("SELECT c FROM UserTable AS c WHERE c.nick = :nick AND c.senha = :senha ");
        query.setParameter("nick", nick);
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

    public ArrayList<LetterBean> getImageAndNickFromArraylistNick(ArrayList<MessageTable> nicks){
        
        String sql = "SELECT c.nick, c.foto FROM UserTable AS c WHERE ";

        for( MessageTable nick : nicks ){
            sql = sql + "c.nick = :" + nick.getNick() + " OR ";
        }

        sql = sql.substring(0 , sql.length() - 4);

        manager = factory.createEntityManager();
        Query query = (Query) manager.createQuery(sql);

        for( MessageTable nick : nicks){
            query.setParameter(nick.getNick(), nick.getNick());
        }

        ArrayList<Object[]> list_bytes = (ArrayList<Object[]>) query.getResultList();
        ArrayList<LetterBean> list_bean = new ArrayList<>();

        for(int i = 0; i < list_bytes.size(); i++){
            LetterBean bean = new LetterBean();
            bean.setImage(new String((byte[])list_bytes.get(i)[1]));
            bean.setNick(list_bytes.get(i)[0].toString());
            list_bean.add(bean);
        }

        return list_bean;

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