package Registro_InicioSesion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Javier
 */
@WebServlet(urlPatterns = {"/ServletRegistrarse"})
public class ServletRegistarse extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
        HttpSession session = req.getSession();
        
        
        String registradoConExito = (String) session.getAttribute("registradoConExito");
        if (registradoConExito == null) { //Todavia no se ha creado ninguno
            session.setAttribute("registradoConExito", "false");
        }
        
        RequestDispatcher rd = req.getRequestDispatcher("IniciarSesion.jsp");
        rd.forward(req, res);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
