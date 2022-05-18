package br.com.gerenciador.core.usecase.mappers;


import br.com.gerenciador.core.domain.entities.DespesaEntity;
import br.com.gerenciador.core.usecase.models.output.CadastrarDespesaPortOutput;
import br.com.gerenciador.core.usecase.models.output.TipoPortOutput;
import org.springframework.stereotype.Component;

@Component
public class CadastrarDespesaUseCaseMapper {
    public CadastrarDespesaPortOutput toOutput(DespesaEntity entity){
        TipoPortOutput tipo = TipoPortOutput.valueOf(entity.getTipo().name());

        return new CadastrarDespesaPortOutput(
                entity.getId(),
                entity.getNome(),
                entity.getDataPagamento(),
                entity.getValorPago(),
                tipo
        );
    }
}
