package com.br.rede_de_cartas.model;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.rede_de_cartas.database.dao.UserDao;
import com.br.rede_de_cartas.database.table.UserTable;
import com.br.rede_de_cartas.model.interfaces.ModelInterface;
import com.br.rede_de_cartas.util.SessionManager;

public class Login implements ModelInterface{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String nick = request.getParameter("nick");
        String senha = request.getParameter("senha");

        UserTable getUser = new UserDao((EntityManagerFactory)request.getAttribute("factory")).getUserByNameAndPassword(nick, senha);

        if(getUser == null){
            return "index.html";
        }

        new SessionManager(request).createSession(getUser);
        return "WEB-INF/jsp/home2.jsp";
    }
}