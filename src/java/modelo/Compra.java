/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author rooque
 */
public class Compra {
    private int id;
    private double total;
    private ArrayList<Produto> produtos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public double getTotal() {
        return total;
    }
    
    public void calcularTotal(){
        for (Produto p : produtos)
            total+=(p.getValor() * p.getQtd());
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    public Compra() {}
    
}
