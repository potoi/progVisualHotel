/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.EnderecoDAO;
import dao.MunicipioDAO;
import dao.PessoaFisicaDAO;
import dao.PessoaJuridicaDAO;
import dao.PetDAO;
import dao.VeiculoDAO;
import java.util.ArrayList;
import model.Cliente;
import model.Item;
import model.Municipio;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.Pet;
import model.Veiculo;

/**
 *
 * @author Victor
 */
public class FicharioPessoaF {

    private PessoaFisicaDAO dao = new PessoaFisicaDAO();
    private PessoaJuridicaDAO daoJ = new PessoaJuridicaDAO();
    private EnderecoDAO endeDAO = new EnderecoDAO();
    private VeiculoDAO veicDAO = new VeiculoDAO();
    private PetDAO petDAO = new PetDAO();
    private MunicipioDAO muniDAO = new MunicipioDAO();

    public FicharioPessoaF() {
    }

    public String[] getColumnName() {
        String[] a = {"ID", "Cpf", "Nome", "Telefone Fixo", "Telefone Celular"};
        return a;
    }

    public String[][] getDataString() throws Exception {
        ArrayList<PessoaFisica> data = dao.listar();

        String[][] stringTotal;
        int quantCampos = 5;
        int i = 0;
        ArrayList<PessoaFisica> nData = new ArrayList<PessoaFisica>();
        for (Cliente c : data) {
            if (c instanceof PessoaFisica) {
                nData.add((PessoaFisica) c);
            }

        }

        stringTotal = new String[data.size()][quantCampos];
        for (PessoaFisica c : nData) {
            stringTotal[i][0] = Integer.toString(c.getId());
            stringTotal[i][1] = c.getCpf();
            stringTotal[i][2] = c.getNome();
            stringTotal[i][3] = c.getTelefoneFixo();
            stringTotal[i][4] = c.getTelefoneCelular();

            i++;

        }
        return stringTotal;
    }

    public String[] getColumnNameSmall() {
        String[] a = {"ID", "Cpf", "Nome"};
        return a;
    }

    public String[][] getDataStringSmall() throws Exception {
        ArrayList<PessoaFisica> data = dao.listar();

        String[][] stringTotal;
        int quantCampos = 3;
        int i = 0;
        ArrayList<PessoaFisica> nData = new ArrayList<PessoaFisica>();
        for (Cliente c : data) {
            if (c instanceof PessoaFisica) {
                nData.add((PessoaFisica) c);
            }

        }

        stringTotal = new String[data.size()][quantCampos];
        for (PessoaFisica c : nData) {
            stringTotal[i][0] = Integer.toString(c.getId());
            stringTotal[i][1] = c.getCpf();
            stringTotal[i][2] = c.getNome();
            i++;

        }
        return stringTotal;
    }

    public String[] getColumnNameJuridico() {
        String[] a = {"ID", "CNPJ", "Nome Fantasia", "Nome"};
        return a;
    }

    public String[][] getDataStringJuridico() throws Exception {

        ArrayList<PessoaJuridica> data = daoJ.listar();
        String[][] stringTotal;
        int quantCampos = 4;
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
            i++;

        }
        return stringTotal;
    }

    public void add(PessoaFisica e) throws Exception {
        e.getEnderecoResidencial().setMunicipio(muniDAO.incluir(e.getEnderecoResidencial().getMunicipio()));
        e.setEnderecoResidencial(endeDAO.incluir(e.getEnderecoResidencial()));
        e.setId(dao.incluir(e).getId());
        for (Veiculo veic : e.getVeiculos()) {
            if (veic.getId() == 0) {
                veic.setIdF(e.getId());
                veicDAO.incluir(veic);
            }

        }
        for (Pet pet : e.getPets()) {
            if (pet.getId() == 0) {
                pet.setIdF(e.getId());
                petDAO.incluir(pet);
            }

        }

    }

    /*
    public int findIndex(int id) {
        
        int i = 0;
        for (Item item : arrayItem) {
            if (item instanceof PessoaFisica pessoafisica) {
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

    public PessoaFisica achar(int index) throws Exception {
        PessoaFisica pessoafisica = dao.consulta(index);
        pessoafisica.setEnderecoResidencial(endeDAO.consulta(pessoafisica.getEnderecoResidencial().getId()));
        pessoafisica.getEnderecoResidencial().setMunicipio(muniDAO.consulta(pessoafisica.getEnderecoResidencial().getMunicipio().getId()));

        Veiculo[] arr = new Veiculo[veicDAO.listarF(index).size()];
        pessoafisica.setVeiculos(veicDAO.listarF(index).toArray(arr));

        Pet[] arr2 = new Pet[petDAO.listarF(index).size()];
        pessoafisica.setPets(petDAO.listarF(index).toArray(arr2));

        return pessoafisica;
    }

    public void alterar(PessoaFisica pessoafisica, int id) throws Exception {
        dao.alterar(pessoafisica, id);
        endeDAO.alterar(pessoafisica.getEnderecoResidencial(), pessoafisica.getEnderecoResidencial().getId());
        muniDAO.alterar(pessoafisica.getEnderecoResidencial().getMunicipio(), pessoafisica.getEnderecoResidencial().getMunicipio().getId());
        for (Veiculo veic : pessoafisica.getVeiculos()) {
            if (veic.getId() == 0) {
                veic.setIdF(pessoafisica.getId());
                veicDAO.incluir(veic);
            } else {
                veicDAO.alterar(veic, veic.getId());
            }
        }
        for (Pet pet : pessoafisica.getPets()) {
            if (pet.getId() == 0) {
                pet.setIdF(pessoafisica.getId());
                petDAO.incluir(pet);
            } else {
                petDAO.alterar(pet, pet.getId());
            }
        }
    }
}
