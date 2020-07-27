package com.br.rede_de_cartas.model;

import java.io.IOException;
import java.util.ArrayList;

import org.json.*;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.rede_de_cartas.bean.LetterBean;
import com.br.rede_de_cartas.database.dao.MessageDao;
import com.br.rede_de_cartas.database.dao.UserDao;
import com.br.rede_de_cartas.database.table.MessageTable;
import com.br.rede_de_cartas.model.interfaces.ModelInterface;

public class LoadHome implements ModelInterface {

    // @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
        
        ArrayList<MessageTable> list_message = (ArrayList<MessageTable>) new MessageDao((EntityManagerFactory)request.getAttribute("factory")).getMessageList();

        ArrayList<LetterBean> list_images = new UserDao((EntityManagerFactory) request.getAttribute("factory")).getImageAndNickFromArraylistNick(list_message);
        
        JSONObject json = new JSONObject();

        for(int i = 0 ; i < list_message.size() ; i++){
            json.put("attributes", list_message);
        }

        for(int i = 0 ; i < list_images.size() ; i++){
            json.put(list_images.get(i).getNick(), list_images.get(i).getImage());
        }

        request.setAttribute("attributes", json.toString());
 
        return "WEB-INF/jsp/listaJSON.jsp";
    }
    
}