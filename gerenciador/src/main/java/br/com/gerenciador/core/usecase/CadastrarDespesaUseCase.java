package br.com.gerenciador.core.usecase;

import br.com.gerenciador.core.usecase.models.input.CadastrarDespesaPortInput;
import br.com.gerenciador.core.usecase.models.output.CadastrarDespesaPortOutput;
import br.com.gerenciador.core.usecase.result.UseCaseResult;

public interface CadastrarDespesaUseCase {
    UseCaseResult<CadastrarDespesaPortOutput> cadastrar(CadastrarDespesaPortInput port);
}
