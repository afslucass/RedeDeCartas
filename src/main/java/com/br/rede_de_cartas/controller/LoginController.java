package com.br.rede_de_cartas.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.rede_de_cartas.model.Login;

@WebServlet("/login")
public class LoginController extends HttpServlet{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        
        String dispatcher_string = new Login().execute(request, response);

        RequestDispatcher dispatcher = request.getRequestDispatcher(dispatcher_string);
        dispatcher.forward(request, response);
    }
}