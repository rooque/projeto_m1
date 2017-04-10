<%-- 
    Document   : comprar
    Created on : 07/04/2017, 17:08:18
    Author     : rooque
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="static util.Consts.*" %>

<% ArrayList<Produto> lp = (ArrayList<Produto>) request.getAttribute(ATRI_LISTA_PRODUTO); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Projeto M1 - Comprar</title>
    </head>
    <body>
    <center>
        <h1>Carrinho</h1>
        <p><a href="/projeto_m1/"><--HOME</a></p>
        
        <form action="<%= CONTROLE_COMPRA %>" method="post">
        
        <% for(Produto p: lp){  %>
        <p>
            <input type="checkbox" name="<%= p.getNome() %>" id="<%= p.getId() %>" /><%= p.getNome() + " - Preco: R$" + p.getValor() %>
            - Quantidade: <input type="number" min="0" max="5" value="0" name="<%= "qtd_" + p.getNome() %>"/>
            <input type="hidden" name="<%= "id_" + p.getNome() %>" value="<%= p.getId() %>" />
            <input type="hidden" name="<%= "valor_" + p.getNome() %>" value="<%= p.getValor() %>" />
        </p>
        <% } %>
        
        <input type="submit" name="<%= ACAO %>" value="<%= ACAO_FINALIZAR_COMPRA %>">
        </form>
    </center>
    </body>
</html>
