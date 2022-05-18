package br.com.gerenciador.core.domain.entities;

import org.springframework.http.HttpStatus;

import java.time.LocalDate;

public class DespesaEntity {
    private Long id;
    private String nome;
    private LocalDate dataPagamento;
    private double valorPago;
    private TipoEntity tipo;

    public DespesaEntity() {
    }

    public DespesaEntity(Long id, String nome, LocalDate dataPagamento, double valorPago, TipoEntity tipo) {
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

    public TipoEntity getTipo() {
        return tipo;
    }
}
