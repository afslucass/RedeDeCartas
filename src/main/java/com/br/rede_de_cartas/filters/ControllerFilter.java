package com.br.rede_de_cartas.filters;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.br.rede_de_cartas.database.connection_factory.ConnectionFactory;

@WebFilter("/controller")
public class ControllerFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        EntityManagerFactory factory = new ConnectionFactory().getConnection();
        request.setAttribute("factory", factory); 

        chain.doFilter(request, response);
        
        factory.close();
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }
    
}