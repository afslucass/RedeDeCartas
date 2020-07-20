package com.br.rede_de_cartas.database.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MessageTable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, length = 10000)
    private String message;
    private String nick;

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return this.id;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return this.message;
    }
    public void setNick(String nick) {
        this.nick = nick;
    }
    public String getNick() {
        return this.nick;
    }
}