package br.com.gerenciador.adapter.gateways.webservices.models;

import org.springframework.http.HttpStatus;

import java.time.LocalDate;

public class DespesaResponse {
    private Long id;
    private String nome;
    private LocalDate dataPagamento;
    private double valorPago;
    private TipoResponse tipo;

    public DespesaResponse() {
    }

    public DespesaResponse(Long id, String nome, LocalDate dataPagamento, double valorPago, TipoResponse tipo) {
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

    public TipoResponse getTipo() {
        return tipo;
    }
}
