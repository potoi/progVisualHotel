/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.MunicipioDAO;
import java.util.ArrayList;
import model.Item;
import model.Municipio;

/**
 *
 * @author Victor
 */
public class FicharioMunicipio {

    private MunicipioDAO dao = new MunicipioDAO();

    public FicharioMunicipio() {
    }

    public String[] getColumnName() {
        String[] a = {"Id", "Nome", "Estado", "País"};
        return a;
    }

    public String[][] getDataString() throws Exception {
        ArrayList<Municipio> data = dao.listar();
        String[][] stringTotal;
        int quantCampos = 5;
        stringTotal = new String[data.size()][quantCampos];
        int i = 0;

        for (Municipio c : data) {

            stringTotal[i][0] = Integer.toString(c.getId());

            stringTotal[i][1] = c.getNome();
            stringTotal[i][2] = c.getEstado();
            stringTotal[i][3] = c.getPais();

            i++;

        }
        return stringTotal;
    }

    public void remove(int i) throws Exception {
        dao.apagar(i);
    }

    public void add(Municipio e) throws Exception {
        dao.incluir(e);

    }

    public Municipio achar(int index) throws Exception {
        Municipio produto = dao.consulta(index);
        return produto;
    }

    public void alterar(Municipio produto, int id) throws Exception {
        dao.alterar(produto, id);
    }
}
