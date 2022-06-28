/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.EquipamentoDAO;
import java.util.ArrayList;
import model.Item;
import model.Equipamento;

/**
 *
 * @author Victor
 */
public class FicharioEquipamento {

    private EquipamentoDAO dao = new EquipamentoDAO();

    public FicharioEquipamento() {
    }

    public String[] getColumnName() {
        String[] a = {"Id", "Descrição"};
        return a;
    }

    public String[][] getDataString() throws Exception {
        ArrayList<Equipamento> data = dao.listar();
        String[][] stringTotal;
        int quantCampos = 2;
        stringTotal = new String[data.size()][quantCampos];
        int i = 0;

        for (Equipamento c : data) {

            stringTotal[i][0] = Integer.toString(c.getIdentificador());

            stringTotal[i][1] = c.getDescricao();

            i++;

        }
        return stringTotal;
    }

    public void remove(int i) throws Exception {
        dao.apagar(i);
    }

    public void add(Equipamento e) throws Exception {
        dao.incluir(e);

    }

    public Equipamento achar(int index) throws Exception {
        Equipamento produto = dao.consulta(index);
        return produto;
    }

    public void alterar(Equipamento produto, int id) throws Exception {
        dao.alterar(produto, id);
    }
 
    public ArrayList<Equipamento> listar() throws Exception {
        return dao.listar();
    }
}
