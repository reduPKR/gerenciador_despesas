package br.com.gerenciador.core.domain.ports.output;

import br.com.gerenciador.core.domain.entities.DespesaEntity;
import br.com.gerenciador.core.usecase.models.input.CadastrarDespesaPortInput;

public interface CadastrarDespesaPortOut {
    DespesaEntity cadastrar(CadastrarDespesaPortInput port);
}
