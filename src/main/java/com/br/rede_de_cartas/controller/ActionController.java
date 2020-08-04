
package com.br.rede_de_cartas.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.rede_de_cartas.model.LoadHome;
import com.br.rede_de_cartas.model.LoadViewer;
import com.br.rede_de_cartas.model.SendLetter;
import com.br.rede_de_cartas.util.SessionManager;

@WebServlet("/action")
public class ActionController extends HttpServlet{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private RequestDispatcher dispatcher = null;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String mensagem = request.getParameter("mensagem");
        String redirecionador = "";

        System.out.println(mensagem);
        
        if(mensagem.equals("criar")){
            redirecionador = new SendLetter().execute(request, response);
        } else if(mensagem.equals("mostrar")){
            redirecionador = new LoadHome().execute(request, response);
        } else if(mensagem.equals("visualizar")){
            redirecionador = new LoadViewer().execute(request, response);
        }

        RequestDispatcher disp = request.getRequestDispatcher(redirecionador);
        disp.forward(request, response);
        //response.sendRedirect("sendredirectget?redirecionador=" + redirecionador);
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String mensagem = request.getParameter("mensagem");
        String redirecionador = "";

        if(mensagem.equals("sair")){
            new SessionManager(request).deleteSession();
            redirecionador = "index.html";
        } else if(mensagem.equals("escrever")){
            redirecionador = "WEB-INF/jsp/escrever.jsp";
        }

        this.dispatcher = request.getRequestDispatcher(redirecionador);
        this.dispatcher.forward(request, response);
        
        // Nunca exponha o valor de 'redirecionador' na url como vc esta agr:
        // response.sendRedirect("sendredirectget?redirecionador=" + redirecionador);
    }
}