<%-- 
    Document   : index
    Created on : 07/04/2017, 15:58:30
    Author     : rooque
--%>

<%@page import="static util.Consts.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Projeto M1</title>
    </head>
    <body>
    <center>
        <h1>Projeto M1</h1>    
        <p><a href="<%= CONTROLE_COMPRA %>?<%= ACAO %>=<%= ACAO_COMPRAR %>">Ir as Compras</a></p>
        <p><a href="<%= CONTROLE_COMPRA %>?<%= ACAO %>=<%= ACAO_LISTAR %>">Listar Compras</a></p>
        <p><a href="cad_prod.jsp">Cadastrar Produto</a></p>
    </center>

    </body>
</html>
