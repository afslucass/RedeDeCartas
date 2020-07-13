package com.br.rede_de_cartas.model.interfaces;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ModelInterface {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;
}