<%-- 
    Document   : game
    Created on : 11 févr. 2016, 13:30:56
    Author     : Nicolas
--%>

<%@page import="com.mycompany.exploding_kittens_core.Model.Player"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>TITI</h1>
        <h1>
            <% Player p = (Player)request.getSession().getAttribute("player"); %>
            <%= p.name %>
            
        </h1>
    </body>
</html>
