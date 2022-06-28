/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.EnderecoDAO;
import dao.EquipamentoDAO;
import dao.FuncionarioDAO;
import dao.MunicipioDAO;
import dao.ServicoDAO;
import dao.PessoaFisicaDAO;
import dao.PessoaJuridicaDAO;
import dao.ProdutoDAO;
import dao.ServicoDAO;
import dao.VeiculoDAO;
import java.util.ArrayList;
import model.Cliente;
import model.Equipamento;
import model.Funcionario;
import model.Item;
import model.Municipio;
import model.Servico;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.Produto;
import model.Servico;
import model.Veiculo;

/**
 *
 * @author Victor
 */
public class FicharioServico {
    
    private ServicoDAO dao = new ServicoDAO();
    private ServicoDAO servicoDAO = new ServicoDAO();
    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    private EquipamentoDAO equipamentoDAO = new EquipamentoDAO();
    
    public FicharioServico() {
    }
    
    public String[] getColumnName() {
        String[] a = {"ID", "Descrição", "Preço"};
        return a;
    }
    
    public String[][] getDataString() throws Exception {
        ArrayList<Servico> data = dao.listar();
        
        String[][] stringTotal;
        int quantCampos = 3;
        int i = 0;
        
        stringTotal = new String[data.size()][quantCampos];
        for (Servico c : data) {
            stringTotal[i][0] = Integer.toString(c.getIdentificador());
            stringTotal[i][1] = c.getDescricao();
            stringTotal[i][2] = "R$ " + Double.toString(c.getPreco());
            
            i++;
            
        }
        return stringTotal;
    }
    
    public void add(Servico e) throws Exception {
        
        int i = dao.incluir(e);
        e.setIdentificador(i);
        if (e.getProfissionais() != null) {
            for (Funcionario func : e.getProfissionais()) {
                dao.incluirRelacaoFunc(func, e.getIdentificador());
                
            }
        }
        if (e.getEquipamento() != null) {
            for (Equipamento equip : e.getEquipamento()) {
                dao.incluirRelacaoEquip(equip, e.getIdentificador());
                
            }
        }
        
    }

    /*
    public int findIndex(int id) {
        
        int i = 0;
        for (Item item : arrayItem) {
            if (item instanceof Servico servico) {
                if (servico.getIdentificador() == id) {
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
    
    public Servico achar(int index) throws Exception {
        Servico servico = dao.consulta(index);
        ArrayList<Funcionario> arrayF = new ArrayList<>();
        ArrayList<Equipamento> arrayE = new ArrayList<>();
        
        for (Funcionario func : dao.listarFuncionario(index)) {
            arrayF.add(funcionarioDAO.consulta(func.getId()));
        }
        for (Equipamento equip : dao.listarEquipamento(index)) {
            arrayE.add(equipamentoDAO.consulta(equip.getIdentificador()));
            
        }
        Funcionario[] arr = new Funcionario[arrayF.size()];
        arr = arrayF.toArray(arr);
        servico.setProfissionais(arr);
        
        Equipamento[] arra = new Equipamento[arrayE.size()];
        arra = arrayE.toArray(arra);
        servico.setEquipamento(arra);
        
        return servico;
    }
    
    public void alterar(Servico servico, int id) throws Exception {
        dao.alterar(servico, id);
        
    }
    public ArrayList<Servico> listar() throws Exception{
       return dao.listar();
    }
}
