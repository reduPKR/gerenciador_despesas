package br.com.gerenciador.adapter.gateways.webservices;

import br.com.gerenciador.adapter.gateways.webservices.models.DespesaResponse;
import br.com.gerenciador.core.usecase.models.input.CadastrarDespesaPortInput;

public interface CadastrarDespesaService {
    DespesaResponse cadastrar(CadastrarDespesaPortInput port);
}
