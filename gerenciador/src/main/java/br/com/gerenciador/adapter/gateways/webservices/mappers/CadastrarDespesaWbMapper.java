package br.com.gerenciador.adapter.gateways.webservices.mappers;

import br.com.gerenciador.adapter.gateways.webservices.models.DespesaResponse;
import br.com.gerenciador.core.domain.entities.DespesaEntity;
import br.com.gerenciador.core.domain.entities.TipoEntity;
import org.springframework.stereotype.Component;

@Component
public class CadastrarDespesaWbMapper {

    public DespesaEntity toEntity(DespesaResponse despesaResponse) {
        TipoEntity tipo = TipoEntity.valueOf(despesaResponse.getTipo().name());

        return new DespesaEntity(
                despesaResponse.getId(),
                despesaResponse.getNome(),
                despesaResponse.getDataPagamento(),
                despesaResponse.getValorPago(),
                tipo
        );
    }
}
