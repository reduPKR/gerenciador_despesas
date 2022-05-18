package br.com.gerenciador.adapter.rest.mappers;

import br.com.gerenciador.adapter.rest.models.request.CadastrarDespesaRequest;
import br.com.gerenciador.core.usecase.models.input.CadastrarDespesaPortInput;
import br.com.gerenciador.core.usecase.models.input.TipoPortInput;
import org.springframework.stereotype.Component;

@Component
public class CadastrarDespesaRestMapper {
    public CadastrarDespesaPortInput convertToPort(CadastrarDespesaRequest request){
        TipoPortInput tipo = TipoPortInput.valueOf(request.getTipo());

        return  new CadastrarDespesaPortInput(
                request.getNome(),
                request.getDataPagamento(),
                request.getValorPago(),
                tipo
        );
    }
}
