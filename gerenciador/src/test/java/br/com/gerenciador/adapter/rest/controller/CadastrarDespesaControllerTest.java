package br.com.gerenciador.adapter.rest.controller;

import br.com.gerenciador.adapter.rest.mappers.CadastrarDespesaRestMapper;
import br.com.gerenciador.adapter.rest.models.request.CadastrarDespesaRequest;
import br.com.gerenciador.core.usecase.CadastrarDespesaUseCase;
import br.com.gerenciador.core.usecase.models.input.CadastrarDespesaPortInput;
import br.com.gerenciador.core.usecase.models.input.TipoPortInput;
import br.com.gerenciador.core.usecase.models.output.CadastrarDespesaPortOutput;
import br.com.gerenciador.core.usecase.result.UseCaseResult;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CadastrarDespesaControllerTest {
    @Autowired
    private CadastrarDespesaRestMapper mapper;
    @Autowired
    private CadastrarDespesaUseCase useCase;

    private CadastrarDespesaRequest request;

    @BeforeAll
    void beforeAll(){
        LocalDate hoje = LocalDate.now();
        request = new CadastrarDespesaRequest("Energia",hoje,350.0, "Energia");
    }

    @Test
    void cadastrar() {
        CadastrarDespesaPortInput port = mapper.convertToPort(request);
        UseCaseResult<CadastrarDespesaPortOutput> response = useCase.cadastrar(port);
        CadastrarDespesaPortOutput result = response.getResult();

        LocalDate data = LocalDate.now();

        assertNotEquals(null, result.getId());
        assertEquals("Energia", result.getNome());
        assertEquals(data, result.getDataPagamento());
        assertEquals(350.0, result.getValorPago());
    }
}