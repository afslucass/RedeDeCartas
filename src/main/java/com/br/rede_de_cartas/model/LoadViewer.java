package com.br.rede_de_cartas.model;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.rede_de_cartas.bean.LetterBean;
import com.br.rede_de_cartas.database.dao.MessageDao;
import com.br.rede_de_cartas.database.dao.UserDao;
import com.br.rede_de_cartas.database.table.MessageTable;
import com.br.rede_de_cartas.database.table.UserTable;
import com.br.rede_de_cartas.model.interfaces.ModelInterface;

public class LoadViewer implements ModelInterface {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        
        String id = request.getParameter("id");

        MessageTable message = new MessageDao((EntityManagerFactory)request.getAttribute("factory")).getMessageById(Long.parseLong(id));

        UserTable user = new UserDao((EntityManagerFactory)request.getAttribute("factory")).getUserByNick(message.getNick());

        LetterBean bean = new LetterBean();
        bean.setId(Long.parseLong(id));
        bean.setImage(new String(user.getFoto()));
        bean.setMessage(message.getMessage());
        bean.setNick(message.getNick());

        request.setAttribute("attributes", bean);
        request.setAttribute("nome", user.getNome());

        return "WEB-INF/jsp/visualizar2.jsp";
    }
}