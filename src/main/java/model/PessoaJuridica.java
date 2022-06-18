/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Victor
 */
public class PessoaJuridica extends Cliente {

    public PessoaJuridica(String cnpj, String nomeFantasia, int id, String nome, Endereco enderecoResidencial, Endereco enderecoComercial, Veiculo[] veiculos, String telefoneFixo, String telefoneCelular, String telefoneComercial) {
        super(id, nome, enderecoResidencial, enderecoComercial, veiculos, telefoneFixo, telefoneCelular, telefoneComercial);
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
    }

    public PessoaJuridica(String cnpj, String nomeFantasia) {
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
    }

    public PessoaJuridica() {

    }

    private String cnpj;
    private String nomeFantasia;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

}
