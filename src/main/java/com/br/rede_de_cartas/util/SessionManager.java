package com.br.rede_de_cartas.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.br.rede_de_cartas.database.table.UserTable;

public class SessionManager {
    HttpServletRequest request = null;
    HttpSession session = null;

    public SessionManager(HttpServletRequest request){
        this.request = request;
        session = request.getSession();
    }

    public void createSession(UserTable user){
        session.setMaxInactiveInterval(10000);
        
        String image = new String(user.getFoto());
        user.setSenha(null);
        user.setFoto(null);

        session.setAttribute("user_attributes", user);
        session.setAttribute("user_image", image);
    }

    public void deleteSession(){
        
        session.invalidate();
    }
}