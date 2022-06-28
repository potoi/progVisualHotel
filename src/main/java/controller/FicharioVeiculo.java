/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.VeiculoDAO;
import java.util.ArrayList;
import model.Veiculo;

/**
 *
 * @author Victor
 */
public class FicharioVeiculo {

    public VeiculoDAO dao = new VeiculoDAO();

    public FicharioVeiculo() {
    }

    public String[] getColumnName() {
        String[] a = {"ID", "Marca", "Modelo", "Cor", "Placa", "Vaga Ocupada", "Proprietário"};
        return a;
    }

    public String[][] getDataString() throws Exception {
        ArrayList<Veiculo> data = dao.listar();
        String[][] stringTotal;
        int quantCampos = 5;
        stringTotal = new String[data.size()][quantCampos];
        int i = 0;

        for (Veiculo c : data) {

            stringTotal[i][0] = c.getMarca();
            stringTotal[i][1] = c.getModelo();
            stringTotal[i][2] = c.getCor();

            stringTotal[i][3] = c.getPlaca();

            stringTotal[i][4] = c.getVagaOcupada();

            i++;
        }

        return stringTotal;
    }

    public void add(Veiculo e) throws Exception {
        dao.incluir(e);

    }

    public String[][] listar() throws Exception {
        return dao.listarString();
    }

    /*
    public int findIndex(int id) {
        
        int i = 0;
        for (Item item : arrayItem) {
            if (item instanceof Veiculo veiculo) {
                if (veiculo.getIdentificador() == id) {
                    return i;
                }
                i++;
            }

        }
        return -1;

    }
     */
    public void remove(int index) throws Exception {
        dao.apagar(index);
    }

    public Veiculo achar(int index) throws Exception {
        Veiculo veiculo = dao.consulta(index);
        return veiculo;
    }

    public void alterar(Veiculo veiculo, int id) throws Exception {
        dao.alterar(veiculo, id);
    }
}
