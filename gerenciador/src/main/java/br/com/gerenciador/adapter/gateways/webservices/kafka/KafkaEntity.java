package br.com.gerenciador.adapter.gateways.webservices.kafka;

import br.com.gerenciador.dataprovider.entity.DespesaDpEntity;
import br.com.gerenciador.dataprovider.entity.Tipo;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

public class KafkaEntity {
    private Long id;
    private String nome;
    private LocalDate dataPagamento;
    private double valorPago;
    private String tipo;

    public KafkaEntity() {
    }

    public KafkaEntity(DespesaDpEntity dbEntity) {
        this.id = dbEntity.getId();
        this.nome = dbEntity.getNome();
        this.dataPagamento = dbEntity.getDataPagamento();
        this.valorPago = dbEntity.getValorPago();
        this.tipo = dbEntity.getTipo().name();
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

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"nome\":\"" + nome + '\"' +
                ", \"dataPagamento\":\"" + dataPagamento  + '\"' +
                ", \"valorPago\":" + valorPago +
                ", \"tipo\":\"" + tipo + '\"' +
                '}';
    }
}
