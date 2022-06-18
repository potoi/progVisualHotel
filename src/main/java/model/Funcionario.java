/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Victor
 */
public class Funcionario {

    public Funcionario(String matricula, String nome, String profissao) {
        this.matricula = matricula;
        this.nome = nome;
        this.profissao = profissao;
    }

    public Funcionario() {
   
    }
    private String matricula;
    private String nome;
    private String profissao;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

}
