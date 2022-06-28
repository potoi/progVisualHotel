/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.EnderecoDAO;
import dao.MunicipioDAO;
import dao.PessoaJuridicaDAO;
import dao.VeiculoDAO;
import java.util.ArrayList;
import model.Cliente;
import model.Item;
import model.Municipio;
import model.PessoaJuridica;
import model.Veiculo;

/**
 *
 * @author Victor
 */
public class FicharioPessoaJ {

    private PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
    private MunicipioDAO muniDAO = new MunicipioDAO();
    private EnderecoDAO endeDAO = new EnderecoDAO();
    private VeiculoDAO veicDAO = new VeiculoDAO();

    public FicharioPessoaJ() {
    }

    public String[] getColumnName() {
        String[] a = {"ID", "CNPJ", "Nome Fantasia", "Nome", "Telefone Fixo", "Telefone Comercial"};
        return a;
    }

    public String[][] getDataString() throws Exception {
        ArrayList<PessoaJuridica> data = dao.listar();

        String[][] stringTotal;
        int quantCampos = 6;
        int i = 0;
        ArrayList<PessoaJuridica> nData = new ArrayList<PessoaJuridica>();
        for (Cliente c : data) {
            if (c instanceof PessoaJuridica) {
                nData.add((PessoaJuridica) c);
            }

        }

        stringTotal = new String[data.size()][quantCampos];
        for (PessoaJuridica c : nData) {
            stringTotal[i][0] = Integer.toString(c.getId());
            stringTotal[i][1] = c.getCnpj();
            stringTotal[i][2] = c.getNomeFantasia();
            stringTotal[i][3] = c.getNome();
            stringTotal[i][4] = c.getTelefoneFixo();
            stringTotal[i][5] = c.getTelefoneComercial();

            i++;

        }
        return stringTotal;
    }

    public void add(PessoaJuridica e) throws Exception {

        e.getEnderecoComercial().setMunicipio(muniDAO.incluir(e.getEnderecoComercial().getMunicipio()));
        e.setEnderecoComercial(endeDAO.incluir(e.getEnderecoComercial()));
        e.setId(dao.incluir(e).getId());
        for (Veiculo veic : e.getVeiculos()) {
            if (veic.getId() == 0) {
                veic.setIdJ(e.getId());
                veicDAO.incluir(veic);
            }

        }

    }

    /*
    public int findIndex(int id) {
        
        int i = 0;
        for (Item item : arrayItem) {
            if (item instanceof PessoaJuridica pessoafisica) {
                if (pessoafisica.getIdentificador() == id) {
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

    public PessoaJuridica achar(int index) throws Exception {
        PessoaJuridica pessoafisica = dao.consulta(index);
        pessoafisica.setEnderecoComercial(endeDAO.consulta(pessoafisica.getEnderecoComercial().getId()));
        pessoafisica.getEnderecoComercial().setMunicipio(muniDAO.consulta(pessoafisica.getEnderecoComercial().getMunicipio().getId()));

        Veiculo[] arr = new Veiculo[veicDAO.listarF(index).size()];
        pessoafisica.setVeiculos(veicDAO.listarF(index).toArray(arr));

        return pessoafisica;
    }

    public void alterar(PessoaJuridica pessoafisica, int id) throws Exception {
        dao.alterar(pessoafisica, id);
        endeDAO.alterar(pessoafisica.getEnderecoComercial(), pessoafisica.getEnderecoComercial().getId());
        muniDAO.alterar(pessoafisica.getEnderecoComercial().getMunicipio(), pessoafisica.getEnderecoComercial().getMunicipio().getId());
        for (Veiculo veic : pessoafisica.getVeiculos()) {
            if (veic.getId() == 0) {
                veic.setIdJ(pessoafisica.getId());
                veicDAO.incluir(veic);
            } else {
                veicDAO.alterar(veic, veic.getId());
            }
        }
    }
}
