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
public class Parcela {

    private int identificador;
    private LocalDate dataVencimento;
    private LocalDate dataPagamento;
    private double valor;
    private double jurosMoraAplicado;
    private double valorfinal;
    private int idFatura;

    public Parcela(int identificador, LocalDate dataVencimento, LocalDate dataPagamento, double valor, double jurosMoraAplicado, double valorfinal) {
        this.identificador = identificador;
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
        this.valor = valor;
        this.jurosMoraAplicado = jurosMoraAplicado;
        this.valorfinal = valorfinal;
    }

    public Parcela() {

    }

    public int getIdFatura() {
        return idFatura;
    }

    public void setIdFatura(int idFatura) {
        this.idFatura = idFatura;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getJurosMoraAplicado() {
        return jurosMoraAplicado;
    }

    public void setJurosMoraAplicado(double jurosMoraAplicado) {
        this.jurosMoraAplicado = jurosMoraAplicado;
    }

    public double getValorfinal() {
        return valorfinal;
    }

    public void setValorfinal(double valorfinal) {
        this.valorfinal = valorfinal;
    }

}
