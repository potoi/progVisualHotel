/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.EnderecoDAO;
import java.util.ArrayList;
import model.Item;
import model.Endereco;

/**
 *
 * @author Victor
 */
public class FicharioEndereco {

    public EnderecoDAO dao = new EnderecoDAO();

    public FicharioEndereco() {
    }

    public String[] getColumnName() {
        String[] a = {"Id", "Logradouro", "Número", "Bairro", "Complemento", "CEP"};
        return a;
    }

    public String[][] getDataString() throws Exception {
        ArrayList<Endereco> data = dao.listar();
        String[][] stringTotal;
        int quantCampos = 6;
        stringTotal = new String[data.size()][quantCampos];
        int i = 0;

        for (Endereco c : data) {

            stringTotal[i][0] = Integer.toString(c.getId());

            stringTotal[i][1] = c.getLogradouro();
            stringTotal[i][2] = c.getNumero();
            stringTotal[i][3] = c.getBairro();
            stringTotal[i][4] = c.getComplemento();
            stringTotal[i][5] = c.getCep();

            i++;

        }
        return stringTotal;
    }

    public void remove(int i) throws Exception {
        dao.apagar(i);
    }

    public void add(Endereco e) throws Exception {
        dao.incluir(e);

    }

    public Endereco achar(int index) throws Exception {
        Endereco endereco = dao.consulta(index);
        return endereco;
    }

    public void alterar(Endereco endereco, int id) throws Exception {
        dao.alterar(endereco, id);
    }
}
