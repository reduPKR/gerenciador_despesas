package br.com.gerenciador.adapter.gateways;

import br.com.gerenciador.adapter.gateways.webservices.CadastrarDespesaService;
import br.com.gerenciador.adapter.gateways.webservices.mappers.CadastrarDespesaWbMapper;
import br.com.gerenciador.adapter.gateways.webservices.models.DespesaResponse;
import br.com.gerenciador.core.domain.entities.DespesaEntity;
import br.com.gerenciador.core.domain.ports.output.CadastrarDespesaPortOut;
import br.com.gerenciador.core.usecase.models.input.CadastrarDespesaPortInput;
import org.springframework.stereotype.Component;

@Component
public class CadastrarDespesaGateway implements CadastrarDespesaPortOut {
    private final CadastrarDespesaWbMapper mapper;
    private final CadastrarDespesaService service;

    public CadastrarDespesaGateway(CadastrarDespesaWbMapper mapper, CadastrarDespesaService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @Override
    public DespesaEntity cadastrar(CadastrarDespesaPortInput port) {
        DespesaResponse despesaResponse = service.cadastrar(port);
        return mapper.toEntity(despesaResponse);
    }
}
