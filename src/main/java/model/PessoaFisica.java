/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Victor
 */
public class PessoaFisica extends Cliente {

    private String cpf;

    public PessoaFisica(String cpf, int id, String nome, Endereco enderecoResidencial, Endereco enderecoComercial, Veiculo[] veiculos, String telefoneFixo, String telefoneCelular, String telefoneComercial) {
        super(id, nome, enderecoResidencial, enderecoComercial, veiculos, telefoneFixo, telefoneCelular, telefoneComercial);
        this.cpf = cpf;
    }

    public PessoaFisica(String cpf) {
        this.cpf = cpf;
    }

    public PessoaFisica() {

    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
