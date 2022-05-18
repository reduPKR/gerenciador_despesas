package br.com.gerenciador.core.usecase.models.output;

import br.com.gerenciador.core.usecase.models.input.TipoPortInput;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

public class CadastrarDespesaPortOutput {
    private Long id;
    private String nome;
    private LocalDate dataPagamento;
    private double valorPago;
    private TipoPortOutput tipo;

    public CadastrarDespesaPortOutput() {
    }

    public CadastrarDespesaPortOutput(Long id, String nome, LocalDate dataPagamento, double valorPago, TipoPortOutput tipo) {
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

    public TipoPortOutput getTipo() {
        return tipo;
    }
}
