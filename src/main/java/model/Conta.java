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
public class Conta {

    public Conta(Item[] itens, LocalDate dataAbertura, LocalDate dataFechamento, double total, Cliente cliente, int quarto, int id) {
        this.itens = itens;
        this.dataAbertura = dataAbertura;
        this.dataFechamento = dataFechamento;
        this.total = total;
        this.cliente = cliente;
        this.quarto = quarto;
        this.id = id;
    }

    public Conta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private int id;
    private Item itens[];
    private LocalDate dataAbertura;
    private LocalDate dataFechamento;
    private double total;
    private Cliente cliente;
    private int quarto;

    
    public Item[] getItens() {
        return itens;
    }

    public void setItens(Item[] itens) {
        this.itens = itens;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDate getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(LocalDate dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getQuarto() {
        return quarto;
    }

    public void setQuarto(int quarto) {
        if (quarto < 1 || quarto > 15) {
            throw new IllegalArgumentException(quarto + " is out of range");
        }
        this.quarto = quarto;
    }

}
