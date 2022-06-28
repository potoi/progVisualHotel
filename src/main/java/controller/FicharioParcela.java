/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ParcelaDAO;
import java.util.ArrayList;
import model.Item;
import model.Parcela;

/**
 *
 * @author Victor
 */
public class FicharioParcela {

    private ParcelaDAO dao = new ParcelaDAO();

    public FicharioParcela() {
    }

    public void remove(int i) throws Exception {
        dao.apagar(i);
    }

    public void add(Parcela e) throws Exception {
        dao.incluir(e);

    }

    public Parcela achar(int index) throws Exception {
        Parcela parcela = dao.consulta(index);
        return parcela;
    }

    public void alterar(Parcela parcela, int id) throws Exception {
        dao.alterar(parcela, id);
    }

    public Parcela[] achaParcelas(int i) throws Exception {
        return dao.consultaFatura(i);
    }

}
