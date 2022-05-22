/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author Victor
 */
public class Produto extends Item {

    public Produto(String marca, LocalDate validade, int identificador, String descricao, float preco) {
        super(identificador, descricao, preco);
        this.marca = marca;
        this.validade = validade;
    }
        public Produto(String marca, LocalDate validade, String descricao, float preco) {
        super(descricao, preco);
        this.marca = marca;
        this.validade = validade;
    }
 
    public Produto() {
        super();
    }

    private String marca;
    private LocalDate validade;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

}
