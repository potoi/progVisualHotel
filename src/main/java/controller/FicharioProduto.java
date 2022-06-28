/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ProdutoDAO;
import java.util.ArrayList;
import model.Item;
import model.Produto;

/**
 *
 * @author Victor
 */
public class FicharioProduto {

    private ProdutoDAO dao = new ProdutoDAO();

    public FicharioProduto() {
    }

    public String[] getColumnName() {
        String[] a = {"Id", "Descrição", "Preço", "Marca", "Validade"};
        return a;
    }

    public String[][] getDataString() throws Exception {
        ArrayList<Produto> data = dao.listar();
        String[][] stringTotal;
        int quantCampos = 5;
        stringTotal = new String[data.size()][quantCampos];
        int i = 0;

        for (Item d : data) {
            if (d instanceof Produto c) {

                stringTotal[i][0] = Integer.toString(c.getIdentificador());

                stringTotal[i][1] = c.getDescricao();
                stringTotal[i][2] = "R$ "+Double.toString(c.getPreco());

                stringTotal[i][3] = c.getMarca();

                stringTotal[i][4] = Integer.toString(c.getValidade().
                        getDayOfMonth()) + "." + Integer.toString(c.getValidade().
                                getMonthValue()) + "." + Integer.toString(c.getValidade().getYear());

                i++;
            }
        }
        return stringTotal;
    }

    public void remove(int i) throws Exception {
        dao.apagar(i);
    }

    public void add(Produto e) throws Exception {
        dao.incluir(e);

    }

    public Produto achar(int index) throws Exception {
        Produto produto = dao.consulta(index);
        return produto;
    }

    public void alterar(Produto produto, int id) throws Exception {
        dao.alterar(produto, id);
    }

    public ArrayList<Produto> listar() throws Exception {
        return dao.listar();
    }
}
