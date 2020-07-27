package com.br.rede_de_cartas.model;

import java.io.IOException;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.br.rede_de_cartas.database.dao.MessageDao;
import com.br.rede_de_cartas.database.table.MessageTable;
import com.br.rede_de_cartas.database.table.UserTable;
import com.br.rede_de_cartas.model.interfaces.ModelInterface;
 
public class SendLetter implements ModelInterface{
    
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		UserTable user = (UserTable)session.getAttribute("user_attributes");

        MessageTable message = new MessageTable();
        message.setNick(user.getNick());
		message.setMessage(request.getParameter("text"));
		
		new MessageDao((EntityManagerFactory) request.getAttribute("factory")).addMessage(message);

		return "WEB-INF/jsp/home.jsp";
	}
    
}