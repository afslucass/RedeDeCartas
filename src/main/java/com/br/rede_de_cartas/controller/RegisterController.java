package com.br.rede_de_cartas.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.rede_de_cartas.model.Register;

@WebServlet("/register")
@MultipartConfig
public class RegisterController extends HttpServlet{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        String dispatcher_string = new Register().execute(request, response);

        RequestDispatcher dispatcher = request.getRequestDispatcher(dispatcher_string);
        dispatcher.forward(request, response);
        // response.sendRedirect("sendredirectget?redirecionador=" + dispatcher_string);
    }
}