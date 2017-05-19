<%-- 
    Document   : erro
    Created on : 07/04/2017, 23:49:34
    Author     : rooque
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="static util.Consts.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Projeto Erika - OK</title>
    </head>
    <body>
        <h1>OK</h1>
        <p><%=request.getAttribute(ATRI_MSG)%></p>
        <a href="/ProjetoErika">Inicio</a>
                
    </body>
</html>