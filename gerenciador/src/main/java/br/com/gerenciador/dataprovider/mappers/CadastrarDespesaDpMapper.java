package br.com.gerenciador.dataprovider.mappers;

import br.com.gerenciador.adapter.gateways.webservices.models.DespesaResponse;
import br.com.gerenciador.adapter.gateways.webservices.models.TipoResponse;
import br.com.gerenciador.core.usecase.models.input.CadastrarDespesaPortInput;
import br.com.gerenciador.dataprovider.entity.DespesaDpEntity;
import br.com.gerenciador.dataprovider.entity.Tipo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class CadastrarDespesaDpMapper {

    public DespesaDpEntity toDbEntity(CadastrarDespesaPortInput port) {
        Tipo tipo = Tipo.valueOf(port.getTipo().name());

        return new DespesaDpEntity(
                port.getNome(),
                port.getDataPagamento(),
                port.getValorPago(),
                tipo
        );
    }

    public DespesaResponse toResponse(DespesaDpEntity dbEntity) {
        HttpStatus status = dbEntity.getId() != 0 ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR;
        TipoResponse tipo = TipoResponse.valueOf(dbEntity.getTipo().name());

        return new DespesaResponse(
                dbEntity.getId(),
                dbEntity.getNome(),
                dbEntity.getDataPagamento(),
                dbEntity.getValorPago(),
                tipo
        );
    }
}
