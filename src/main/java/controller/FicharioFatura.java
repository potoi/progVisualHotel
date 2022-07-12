/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.FaturaDAO;
import java.util.ArrayList;
import model.Fatura;
import model.Parcela;

/**
 *
 * @author Victor
 */
public class FicharioFatura {

    private FaturaDAO dao = new FaturaDAO();
    private FicharioParcela ficharioP = new FicharioParcela();

    public FicharioFatura() {
    }

    public String[] getColumnName() {
        String[] a = {"IdConta", "Data de Liquidação", "Quantidade de Parcelas", "Tipo de pagamento"};
        return a;
    }

    public String[][] getDataString() throws Exception {
        ArrayList<Fatura> data = dao.listar();
        String[][] stringTotal;
        int quantCampos = 4;
        stringTotal = new String[data.size()][quantCampos];
        int i = 0;

        for (Fatura c : data) {

            stringTotal[i][0] = "" + c.getConta().getId();
            if (c.getDataLiquidacao() != null) {
                stringTotal[i][1] = Integer.toString(c.getDataLiquidacao().
                        getDayOfMonth()) + "." + Integer.toString(c.getDataLiquidacao().
                                getMonthValue()) + "." + Integer.toString(c.getDataLiquidacao().getYear());
            }
            stringTotal[i][2] = c.getQtdParcelas() + "";
            stringTotal[i][3] = c.getTipopagamento() + "";

            i++;

        }
        return stringTotal;
    }

    public void remove(int i) throws Exception {
        dao.apagar(i);
    }



    public void add(Fatura e) throws Exception {
        dao.incluir(e);
        for (Parcela p : e.getParcelas()) {
            ficharioP.add(p);
        }

    }

    public Fatura achar(int id) throws Exception {
        Fatura fatura = dao.consulta(id);
        fatura.setParcelas(ficharioP.achaParcelas(id));

        System.out.println(fatura.getParcelas().length);
        System.out.println(fatura.getParcelas()[1].getIdentificador());
        return fatura;
    }

    public void alterar(Fatura fatura, int id) throws Exception {
        dao.alterar(fatura, id);
        ficharioP.removeIdFatura(id);
        for (Parcela p : fatura.getParcelas()) {
            ficharioP.add(p);
        }

    }

    public ArrayList<Fatura> listar() throws Exception {
        return dao.listar();
    }
}
