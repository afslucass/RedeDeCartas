package com.br.rede_de_cartas.model;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.rede_de_cartas.database.dao.UserDao;
import com.br.rede_de_cartas.database.table.UserTable;
import com.br.rede_de_cartas.model.interfaces.ModelInterface;
import com.br.rede_de_cartas.util.CryptoString;
import com.br.rede_de_cartas.util.SessionManager;

@MultipartConfig
public class Register implements ModelInterface {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        InputStream part = null;
        
        part = request.getPart("nome").getInputStream();
        byte[] nome_bytes = new byte[part.available()];
        part.read(nome_bytes);
        String nome = new String(nome_bytes);
        
        part = request.getPart("sobrenome").getInputStream();
        byte[] sobrenome_bytes = new byte[part.available()];
        part.read(sobrenome_bytes);
        String sobrenome = new String(sobrenome_bytes);

        part = request.getPart("nick").getInputStream();
        byte[] nick_bytes = new byte[part.available()];
        part.read(nick_bytes);
        String nick = new String(nick_bytes);

        Calendar data = Calendar.getInstance();
        try {
            // O parametro ta retornando nulo:
            part = request.getPart("data").getInputStream();
            byte[] data_bytes = new byte[part.available()];
            part.read(data_bytes);
            String data_string = new String(data_bytes).replace("-", "/");
            
            SimpleDateFormat data_date = new SimpleDateFormat("yyyy/MM/dd");
            data.setTime(data_date.parse(data_string));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            throw new IOException();
        }

        part = request.getPart("image").getInputStream();
        byte[] foto = new byte[part.available()];
        part.read(foto);
        foto = Base64.getEncoder().encode(foto);

        part = request.getPart("email").getInputStream();
        byte[] email_bytes = new byte[part.available()];
        part.read(email_bytes);
        String email = new String(email_bytes);

        part = request.getPart("senha").getInputStream();
        byte[] senha_bytes = new byte[part.available()];
        part.read(senha_bytes);
        String senha = new String(senha_bytes);
        
        // String confirmasenha = request.getParameter("confirmaesenha");

        part.close();

        senha = new CryptoString().getEncode(senha);

        UserTable user = new UserTable();
        user.setNome(nome);
        user.setSobrenome(sobrenome);
        user.setData(data);
        user.setFoto(foto);
        user.setNick(nick);
        user.setSenha(senha);  
        user.setEmail(email);

        System.out.println(nome);
        
        
        UserDao dao = new UserDao((EntityManagerFactory) request.getAttribute("factory"));
        dao.addUser(user);
        UserTable user_para_autenticar = dao.getUserByNameAndPassword(nick, senha);

        new SessionManager(request).createSession(user_para_autenticar);

        return "WEB-INF/jsp/home2.jsp";
    }
    
}