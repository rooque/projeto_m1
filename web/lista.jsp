<%-- 
    Document   : lista
    Created on : 07/04/2017, 17:09:32
    Author     : rooque
--%>

<%@page import="modelo.Produto"%>
<%@page import="modelo.Compra"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="static util.Consts.*" %>
<% ArrayList<Compra> lc = (ArrayList<Compra>)request.getAttribute(ATTRI_LISTA_COMPRA); %>
    

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Projeto M1 - Lista</title>
    </head>
    <body>
        <h1 style="text-align: center;">Lista</h1>
        <p style="text-align: center;"><a href="/projeto_m1/"><--HOME</a></p>
        
        <% for(Compra c: lc){ %>
        <div style="border:1px;border-color: black;border-style: dashed;margin: 5px;display: flex;text-align: center;flex-direction: column;align-items: center;justify-content: center;">
        <h3>ID Compra: <%= c.getId() %></h3>
        <table border="1">
            <tr>
                <td>Produto</td>
                <td>Valor</td>
                <td>Quantidade</td>
            </tr>
            <% for(Produto p: c.getProdutos()) { %>
              <tr>
                <td><%= p.getNome() %></td>
                <td>R$<%= p.getValor() %></td>
                <td><%= p.getQtd() %></td>
            </tr>
                    <%
        }
        %>
        <tr>
            <td>Total</td>
            <td colspan="2">R$<%= c.getTotal() %></td>
        </tr>
        </table>
            <p><a href="/projeto_m1/<%= CONTROLE_COMPRA %>?<%= ACAO %>=<%= ACAO_DEL_COMPRA %>&id=<%= c.getId() %>">Deletar</a></p>
       
        </div>
        <%
        }
        %>
        
        
    </body>
</html>
