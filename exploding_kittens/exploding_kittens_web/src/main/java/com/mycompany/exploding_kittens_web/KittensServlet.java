/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exploding_kittens_web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.exploding_kittens_core.Model.Engine;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Nicolas
 */
//@WebServlet(name = "KittensServlet", urlPatterns = {"/KittensServlet"})
public class KittensServlet extends HttpServlet {
    
    protected Engine game;
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet KittensServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet KittensServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //processRequest(request, response);
        //System.console().printf("doGet");
        if(request.getSession().getAttribute("gameEngine")==null){
            game = new Engine();
            request.getSession().setAttribute("player", game.getCurrentPlayer());
            request.getSession().setAttribute("gameEngine", game);
        }else{
            game = (Engine) request.getSession().getAttribute("gameEngine");
        }
        if(request.getParameter("SizeCards")!=null){
            System.out.println(request.getParameter("SizeCards"));
        }
        request.getSession().setAttribute("error", "");
        response.sendRedirect(request.getContextPath() + "/game.jsp" );
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<String> result=new ArrayList();
        int sizeCardsPlay=0;
        if(request.getParameter("SizeCards")!=null){
            sizeCardsPlay=Integer.parseInt(request.getParameter("SizeCards"));
            for(int i =0; i < sizeCardsPlay;i++){
                result.add(request.getParameter("c"+i));
            }
            
            if(request.getSession().getAttribute("gameEngine")!=null){
                game = (Engine) request.getSession().getAttribute("gameEngine");
                game = game.EngineServlet(result,game);
                request.getSession().setAttribute("gameEngine", game);
                request.getSession().setAttribute("player", game.getCurrentPlayer());
                
            }else{
                request.getSession().setAttribute("error", "game not define");
            }
        }
        response.sendRedirect(request.getContextPath() + "/game.jsp" );
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
