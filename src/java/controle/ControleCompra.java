/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAO.CompraDAO;
import DAO.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.NotFoundException;
import modelo.Compra;
import modelo.Produto;
import static util.Consts.*;

/**
 *
 * @author rooque
 */
public class ControleCompra extends HttpServlet {

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
        //response.setContentType("text/html;charset=UTF-8");
        String acao = request.getParameter(ACAO);
        RequestDispatcher rd;
        try {
            switch (acao) {
                case ACAO_COMPRAR: {
                    rd = request.getRequestDispatcher(JSP_COMPRAR);
                    ArrayList<Produto> lp = new ArrayList<>();
                    boolean listar = ProdutoDAO.listar(lp);

                    if (!listar) {
                        throw new NoResultException("Lista de Produtos VAZIA!");
                    } else {
                        request.setAttribute(ATRI_LISTA_PRODUTO, lp);
                        rd.forward(request, response);
                    }

                    break;
                }

                case ACAO_FINALIZAR_COMPRA: {
                    Compra c = new Compra();
                    ArrayList<Produto> lp = new ArrayList<>();
                    String regex = "qtd|id|valor";
                    Pattern pattern = Pattern.compile(regex);

                    request.getParameterMap().forEach((String x, String[] y) -> {
                        Matcher matcher = pattern.matcher(x);
                        if ((!matcher.find()) && (!x.equals(ACAO))) {
                            Produto p = new Produto();
                            p.setNome(x);
                            int qtd = Integer.parseInt(request.getParameter("qtd_" + x));
                            if (qtd == 0) {
                                throw new NotFoundException("Itens selecionados devem conter quantidade diferente de 0!");
                            }

                            p.setQtd(qtd);
                            p.setId(Integer.parseInt(request.getParameter("id_" + x)));
                            p.setValor(Double.parseDouble(request.getParameter("valor_" + x)));
                            lp.add(p);
                        }
                    });

                    if (lp.isEmpty()) {
                        throw new NoResultException("Nenhum item selecionado!");
                    }

                    c.setProdutos(lp);
                    c.calcularTotal();

                    CompraDAO.cadastrar(c);

                    rd = request.getRequestDispatcher(JSP_OK);
                    request.setAttribute(ATRI_MSG, "Compra finalizada com sucesso!");
                    rd.forward(request, response);

                    break;
                }
                
                case ACAO_LISTAR:{
                    rd = request.getRequestDispatcher(JSP_LISTA);
                    
                    ArrayList<Compra> lc = CompraDAO.listar();
                    
                    request.setAttribute(ATTRI_LISTA_COMPRA, lc);
                    
                    rd.forward(request, response);
                    
                    break;
                }
                
                case ACAO_DEL_COMPRA:{
                    int id = Integer.parseInt(request.getParameter(COMPRA_ID));
                    CompraDAO.deletar(id);
                    rd = request.getRequestDispatcher(JSP_DEL);
                    rd.forward(request, response);
                    
                    break;
                }
                
                case ACAO_CADASTRAR_PRODUTO:{
                    String nome = request.getParameter(PRODUTO_NOME);
                    double valor = Double.parseDouble(request.getParameter(PRODUTO_VALOR));
                    ProdutoDAO.cadastrar(nome, valor);
                    rd = request.getRequestDispatcher(JSP_OK);
                    request.setAttribute(ATRI_MSG, "Produto Cadastrado!");
                    rd.forward(request, response);
                    break;
                }

                default: {
                    throw new NotFoundException("Acao Invalida!");
                    /*break;*/
                }

            }

        } catch (IOException | NoResultException | ServletException | NotFoundException | SQLException ex) {
            rd = request.getRequestDispatcher(JSP_ERRO);
            request.setAttribute(ATRI_MSG, ex.getMessage());
            rd.forward(request, response);
            ex.printStackTrace();
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
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
