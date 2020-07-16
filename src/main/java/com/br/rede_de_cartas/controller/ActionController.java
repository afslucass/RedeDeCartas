
package com.br.rede_de_cartas.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.rede_de_cartas.util.SessionManager;

@WebServlet("/action")
public class ActionController extends HttpServlet{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private RequestDispatcher dispatcher = null;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mensagem = request.getParameter("mensagem");
        String redirecionador = "";

        if(mensagem == "to_vazando"){
            new SessionManager(request).deleteSession();
            redirecionador = "index.html";
        } else {
            redirecionador = "WEB-INF/jsp/escrever.jsp";
        }

        this.dispatcher = request.getRequestDispatcher(redirecionador);
        this.dispatcher.forward(request, response);
    }
}