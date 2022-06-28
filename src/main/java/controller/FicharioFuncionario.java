/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.FuncionarioDAO;
import java.util.ArrayList;
import model.Item;
import model.Funcionario;

/**
 *
 * @author Victor
 */
public class FicharioFuncionario {

    private FuncionarioDAO dao = new FuncionarioDAO();

    public FicharioFuncionario() {
    }

    public String[] getColumnName() {
        String[] a = {"Id", "Matrícula", "Nome", "Profissão"};
        return a;
    }

    public String[][] getDataString() throws Exception {
        ArrayList<Funcionario> data = dao.listar();
        String[][] stringTotal;
        int quantCampos = 4;
        stringTotal = new String[data.size()][quantCampos];
        int i = 0;

        for (Funcionario c : data) {

            stringTotal[i][0] = Integer.toString(c.getId());

            stringTotal[i][1] = c.getMatricula();
            stringTotal[i][2] = c.getNome();
            stringTotal[i][3] = c.getProfissao();

            i++;

        }
        return stringTotal;
    }

    public void remove(int i) throws Exception {
        dao.apagar(i);
    }

    public void add(Funcionario e) throws Exception {
        dao.incluir(e);

    }

    public Funcionario achar(int index) throws Exception {
        Funcionario funcionario = dao.consulta(index);
        return funcionario;
    }

    public void alterar(Funcionario funcionario, int id) throws Exception {
        dao.alterar(funcionario, id);
    }

    public ArrayList<Funcionario> listar() throws Exception {
        return dao.listar();
    }
}
