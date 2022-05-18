package br.com.gerenciador.adapter.gateways;

import br.com.gerenciador.adapter.gateways.webservices.CadastrarDespesaService;
import br.com.gerenciador.adapter.gateways.webservices.mappers.CadastrarDespesaWbMapper;
import br.com.gerenciador.adapter.gateways.webservices.models.DespesaResponse;
import br.com.gerenciador.core.domain.entities.DespesaEntity;
import br.com.gerenciador.core.usecase.models.input.CadastrarDespesaPortInput;
import br.com.gerenciador.core.usecase.models.input.TipoPortInput;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CadastrarDespesaGatewayTest {
    @Autowired
    private CadastrarDespesaWbMapper mapper;
    @Autowired
    private CadastrarDespesaService service;

    private CadastrarDespesaPortInput port;

    @BeforeAll
    void beforeAll(){
        LocalDate hoje = LocalDate.now();
        port = new CadastrarDespesaPortInput("Energia",hoje,350.0, TipoPortInput.Energia);
    }

    @Test
    void cadastrar() {
        DespesaResponse despesaResponse = service.cadastrar(port);
        DespesaEntity entity = mapper.toEntity(despesaResponse);

        LocalDate data = LocalDate.now();

        assertNotEquals(null, entity.getId());
        assertEquals("Energia", entity.getNome());
        assertEquals(data, entity.getDataPagamento());
        assertEquals(350.0, entity.getValorPago());
    }
}