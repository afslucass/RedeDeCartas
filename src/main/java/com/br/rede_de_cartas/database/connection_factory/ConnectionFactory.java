package com.br.rede_de_cartas.database.connection_factory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
    public EntityManagerFactory getConnection(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("rede_de_cartas");
        return factory;
    }
}