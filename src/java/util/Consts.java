/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author rooque
 */
public class Consts {
    
    // PGSQL CONFIGs
    public static final String PSQL_IP = "localhost";
    public static final String PSQL_PORT = "5432";
    public static final String PSQL_DB = "projeto_erika";
    public static final String PSQL_USER = "postgres";
    public static final String PSQL_PASS = "postgres";
    
    // Consultas SQL
     public static final String SELECT_ALL_PRODUTOS = "SELECT * FROM produtos";
     public static final String INSERT_COMPRA = "INSERT into compra (valor_total) values (?)";
     public static final String INSERT_PART_COMPRA = "INSERT into part_compra (id_compra,id_produto,qtd) values (?,?,?)";
     public static final String SELECT_COMPRA = "SELECT * FROM compra";
     public static final String SELECT_PART_COMPRA = "SELECT * FROM part_compra where id_compra=?";
     public static final String DELETE_COMPRA = "DELETE FROM compra WHERE id=?";
     public static final String DELETE_PART_COMPRA = "DELETE FROM part_compra WHERE id_compra=?";
     public static final String INSERT_PRODUTO = "INSERT into produtos (nome,valor) values (?,?)";
    
    // Controles
    public static final String CONTROLE_COMPRA = "ControleCompra";
    
    // ACOES
    public static final String ACAO = "acao";
    public static final String ACAO_LISTAR = "listar";
    public static final String ACAO_COMPRAR = "comprar";
    public static final String ACAO_DEL_COMPRA = "deletar";
    public static final String ACAO_FINALIZAR_COMPRA = "Finalizar_Comprar";
    public static final String ACAO_CADASTRAR_PRODUTO = "Cadastrar_Produto";
    
    // JSPs
    public static final String JSP_COMPRAR = "comprar.jsp";
    public static final String JSP_LISTA = "lista.jsp";
    public static final String JSP_OK = "ok.jsp";
    public static final String JSP_ERRO = "erro.jsp";
    public static final String JSP_DEL = "del.jsp";
    
    
    // Produto 
    public static final String PRODUTO_ID = "id";
    public static final String PRODUTO_NOME = "nome";
    public static final String PRODUTO_VALOR = "valor";
    public static final String PRODUTO_QTD = "qtd";
    
    // Compra
    public static final String COMPRA_ID = "id";
    public static final String COMPRA_VALOR = "valor_total";
    public static final String COMPRA_PART_ID_PRODUTO = "id_produto";
    public static final String COMPRA_PART_QTD = "qtd";
    
    
    // Attributes
    public static final String ATRI_LISTA_PRODUTO = "lista_produto";
    public static final String ATRI_MSG = "msg";
    public static final String ATTRI_LISTA_COMPRA = "lista_compra";
    
}
