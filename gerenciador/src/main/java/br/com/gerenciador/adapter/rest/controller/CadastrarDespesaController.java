package br.com.gerenciador.adapter.rest.controller;

import br.com.gerenciador.adapter.rest.mappers.CadastrarDespesaRestMapper;
import br.com.gerenciador.adapter.rest.models.request.CadastrarDespesaRequest;
import br.com.gerenciador.core.usecase.CadastrarDespesaUseCase;
import br.com.gerenciador.core.usecase.models.input.CadastrarDespesaPortInput;
import br.com.gerenciador.core.usecase.models.output.CadastrarDespesaPortOutput;
import br.com.gerenciador.core.usecase.result.UseCaseError;
import br.com.gerenciador.core.usecase.result.UseCaseResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("despesa/novo")
public class CadastrarDespesaController {
    private final CadastrarDespesaRestMapper mapper;
    private final CadastrarDespesaUseCase useCase;

    public CadastrarDespesaController(CadastrarDespesaRestMapper mapper, CadastrarDespesaUseCase useCase) {
        this.mapper = mapper;
        this.useCase = useCase;
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@Validated @RequestBody CadastrarDespesaRequest request){
        CadastrarDespesaPortInput port = mapper.convertToPort(request);

        UseCaseResult<CadastrarDespesaPortOutput> response = useCase.cadastrar(port);

        if (response.getResult() != null){
            CadastrarDespesaPortOutput result = response.getResult();
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        }

        UseCaseError error = response.getError();
        return ResponseEntity.badRequest().body(error.getMessage());
    }
}
