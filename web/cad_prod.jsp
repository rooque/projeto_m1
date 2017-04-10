<%-- 
    Document   : cad_prod
    Created on : 09/04/2017, 21:56:30
    Author     : rooque
--%>

<%@page import="static util.Consts.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Projeto M1 - Cadastro Produto</title>
    </head>
    <body>
        <h1>Cadastro Produto</h1>
        
         <form action="<%= CONTROLE_COMPRA %>" method="post">
             <p>Nome:<input type="text" name="<%= PRODUTO_NOME %>" required /></p>
             <p>Valor:<input type="number" step="0.01" name="<%= PRODUTO_VALOR %>" required /></p>
             <input type="submit" name="<%= ACAO %>" value="<%= ACAO_CADASTRAR_PRODUTO %>">
         </form>
    </body>
</html>
