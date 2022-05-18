package br.com.gerenciador.core.usecase.models.input;


import java.time.LocalDate;

public class CadastrarDespesaPortInput {
    private String nome;
    private LocalDate dataPagamento;
    private double valorPago;
    private TipoPortInput tipo;

    public CadastrarDespesaPortInput() {
    }

    public CadastrarDespesaPortInput(String nome, LocalDate dataPagamento, double valorPago, TipoPortInput tipo) {
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

    public TipoPortInput getTipo() {
        return tipo;
    }
}
