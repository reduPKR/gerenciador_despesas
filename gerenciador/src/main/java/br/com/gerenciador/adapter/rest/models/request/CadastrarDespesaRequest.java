package br.com.gerenciador.adapter.rest.models.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

public class CadastrarDespesaRequest {
    @NotNull
    @NotEmpty
    private String nome;
    @PastOrPresent
    private LocalDate dataPagamento;
    @NotNull
    @Positive
    private double valorPago;
    @NotNull
    private String tipo;

    public CadastrarDespesaRequest() {
    }

    public CadastrarDespesaRequest(String nome, LocalDate dataPagamento, double valorPago, String tipo) {
        this.nome = nome;
        this.dataPagamento = dataPagamento;
        this.valorPago = valorPago;
        this.tipo = tipo;
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

    public String getTipo() {
        return tipo;
    }
}
