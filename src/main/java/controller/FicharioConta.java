/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.EnderecoDAO;
import dao.MunicipioDAO;
import dao.ContaDAO;
import dao.PessoaFisicaDAO;
import dao.PessoaJuridicaDAO;
import dao.ProdutoDAO;
import dao.ServicoDAO;
import dao.VeiculoDAO;
import java.util.ArrayList;
import model.Cliente;
import model.Item;
import model.Municipio;
import model.Conta;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.Produto;
import model.Servico;
import model.Veiculo;

/**
 *
 * @author Victor
 */
public class FicharioConta {

    private ContaDAO dao = new ContaDAO();
    private PessoaFisicaDAO pessoaFDAO = new PessoaFisicaDAO();
    private PessoaJuridicaDAO pessoaJDAO = new PessoaJuridicaDAO();
    private ProdutoDAO produtoDAO = new ProdutoDAO();
    private ServicoDAO servicoDAO = new ServicoDAO();

    public FicharioConta() {
    }

    public String[] getColumnName() {
        String[] a = {"ID", "Nome Proprietário", "Data Abertura", "Data Fechamento", "Total", "Quarto"};
        return a;
    }

    public String[][] getDataString() throws Exception {
        ArrayList<Conta> data = dao.listar();

        String[][] stringTotal;
        int quantCampos = 6;
        int i = 0;

        stringTotal = new String[data.size()][quantCampos];
        for (Conta c : data) {
            c = achar(c.getId());
            stringTotal[i][0] = Integer.toString(c.getId());
            if (c.getCliente() != null) {
                stringTotal[i][1] = c.getCliente().getNome();
            }

            stringTotal[i][2] = Integer.toString(c.getDataAbertura().
                    getDayOfMonth()) + "." + Integer.toString(c.getDataAbertura().
                            getMonthValue()) + "." + Integer.toString(c.getDataAbertura().getYear());
            if (c.getDataFechamento() != null) {
                stringTotal[i][3] = Integer.toString(c.getDataFechamento().
                        getDayOfMonth()) + "." + Integer.toString(c.getDataFechamento().
                                getMonthValue()) + "." + Integer.toString(c.getDataFechamento().getYear());
            }

            stringTotal[i][4] = Double.toString(c.getTotal());
            stringTotal[i][5] = Integer.toString(c.getQuarto());

            i++;

        }
        return stringTotal;
    }

    public void add(Conta e) throws Exception {
        e.setId(dao.incluir(e));

    }

    /*
    public int findIndex(int id) {
        
        int i = 0;
        for (Item item : arrayItem) {
            if (item instanceof Conta conta) {
                if (conta.getIdentificador() == id) {
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

    public Conta achar(int index) throws Exception {
        Conta conta = dao.consulta(index);
        if (conta.getCliente() instanceof PessoaFisica) {
            conta.setCliente(pessoaFDAO.consulta(conta.getCliente().getId()));
        }
        if (conta.getCliente() instanceof PessoaJuridica) {
            conta.setCliente(pessoaJDAO.consulta(conta.getCliente().getId()));
        }

        Item[] arr = new Item[dao.listarProduto(index).size() + dao.listarServico(index).size()];

        ArrayList<Item> array = new ArrayList<>();
        for (Produto prod : dao.listarProduto(index)) {
            array.add((Item) produtoDAO.consulta(prod.getIdentificador()));
        }
        for (Servico serv : dao.listarServico(index)) {

            array.add((Item) servicoDAO.consulta(serv.getIdentificador()));
        }
        conta.setItens(array.toArray(arr));

        return conta;
    }

    public void alterar(Conta e, int id) throws Exception {
        dao.alterar(e, id);
        if (e.getItens() != null) {
            for (Item i : e.getItens()) {
                if (i instanceof Produto p) {
                    dao.insertProduto(p, e.getId());
                }

            }
        }
        if (e.getItens() != null) {
            for (Item i : e.getItens()) {
                if (i instanceof Servico s) {
                    dao.insertServico(s, e.getId());
                }

            }
        }

    }
}
