package br.com.gerenciador.adapter.gateways.webservices.impl;

import br.com.gerenciador.core.usecase.models.input.CadastrarDespesaPortInput;
import br.com.gerenciador.core.usecase.models.input.TipoPortInput;
import br.com.gerenciador.dataprovider.entity.DespesaDpEntity;
import br.com.gerenciador.dataprovider.mappers.CadastrarDespesaDpMapper;
import br.com.gerenciador.dataprovider.repository.DespesaRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CadastrarDespesaServiceImplTest {
    @Autowired
    private DespesaRepository repository;
    @Autowired
    private CadastrarDespesaDpMapper mapper;

    private CadastrarDespesaPortInput port;

    @BeforeAll
    void beforeAll(){
        LocalDate hoje = LocalDate.now();
        port = new CadastrarDespesaPortInput("Agua",hoje,250.0, TipoPortInput.Agua);
    }

    @AfterAll
    void afterAll() {
        repository.deleteAll();
    }

    @Test
    void cadastrar() {
        DespesaDpEntity dbEntity = mapper.toDbEntity(port);
        repository.save(dbEntity);

        LocalDate data = LocalDate.now();

        assertNotEquals(null, dbEntity.getId());
        assertEquals("Agua", dbEntity.getNome());
        assertEquals(data, dbEntity.getDataPagamento());
        assertEquals(250.0, dbEntity.getValorPago());
    }
}