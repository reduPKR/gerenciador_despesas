package br.com.gerenciador.dataprovider.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "despesa")
public class DespesaDpEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name="nome")
    private String nome;
    @NotNull
    @Column(name="data_pagamento")
    private LocalDate dataPagamento;
    @NotNull
    @Column(name="valor_pago")
    private double valorPago;
    @Enumerated(EnumType.STRING)
    @Column(name="tipo")
    private Tipo tipo;

    public DespesaDpEntity() {
    }

    public DespesaDpEntity(String nome, LocalDate dataPagamento, double valorPago, Tipo tipo) {
        this.nome = nome;
        this.dataPagamento = dataPagamento;
        this.valorPago = valorPago;
        this.tipo = tipo;
    }

    public DespesaDpEntity(Long id, String nome, LocalDate dataPagamento, double valorPago, Tipo tipo) {
        this.id = id;
        this.nome = nome;
        this.dataPagamento = dataPagamento;
        this.valorPago = valorPago;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public double getValorPago() {
        return valorPago;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
