/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Victor
 */
public class Item {

    public Item(int identificador, String descricao, float preco) {
        this.identificador = identificador;
        this.descricao = descricao;
        this.preco = preco;

    }

    public Item(String descricao, float preco) {

        this.descricao = descricao;
        this.preco = preco;
    }

    public Item() {
    }

    protected int identificador;
    protected String descricao;
    protected float preco;

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

}
