/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Victor
 */
public class Servico extends Item {

    public Servico(Funcionario[] profissionais, Equipamento[] equipamento, int identificador, String descricao, double preco) {
        super(identificador, descricao, preco);
        this.profissionais = profissionais;
        this.equipamento = equipamento;
    }

    public Funcionario[] getProfissionais() {
        return profissionais;
    }

    public void setProfissionais(Funcionario[] profissionais) {
        this.profissionais = profissionais;
    }

    public Equipamento[] getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento[] equipamento) {
        this.equipamento = equipamento;
    }
    
   private Funcionario[] profissionais;
   private Equipamento[] equipamento;
    
}
