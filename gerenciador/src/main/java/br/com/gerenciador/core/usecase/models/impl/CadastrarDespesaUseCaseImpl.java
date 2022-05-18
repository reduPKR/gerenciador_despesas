package br.com.gerenciador.core.usecase.models.impl;

import br.com.gerenciador.core.domain.entities.DespesaEntity;
import br.com.gerenciador.core.domain.ports.output.CadastrarDespesaPortOut;
import br.com.gerenciador.core.usecase.CadastrarDespesaUseCase;
import br.com.gerenciador.core.usecase.mappers.CadastrarDespesaUseCaseMapper;
import br.com.gerenciador.core.usecase.models.input.CadastrarDespesaPortInput;
import br.com.gerenciador.core.usecase.models.output.CadastrarDespesaPortOutput;
import br.com.gerenciador.core.usecase.result.UseCaseError;
import br.com.gerenciador.core.usecase.result.UseCaseResult;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CadastrarDespesaUseCaseImpl implements CadastrarDespesaUseCase {
    private final CadastrarDespesaPortOut cadastrarDespesaPortOut;
    private final CadastrarDespesaUseCaseMapper mapper;

    public CadastrarDespesaUseCaseImpl(CadastrarDespesaPortOut cadastrarDespesaPortOut, CadastrarDespesaUseCaseMapper mapper) {
        this.cadastrarDespesaPortOut = cadastrarDespesaPortOut;
        this.mapper = mapper;
    }

    @Override
    public UseCaseResult<CadastrarDespesaPortOutput> cadastrar(CadastrarDespesaPortInput port) {

        try{
            DespesaEntity entity = cadastrarDespesaPortOut.cadastrar(port);

            if (entity != null){
                return new UseCaseResult<>(mapper.toOutput(entity));
            }

            return new UseCaseResult<>(
                    new UseCaseError("Erro inesperado ao cadastrar",
                        null
                    ));
        }catch (Exception ex){
            return new UseCaseResult<>(
                    new UseCaseError(ex.getMessage(), ex)
            );
        }
    }
}
