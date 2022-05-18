package br.com.gerenciador.adapter.gateways.webservices.impl;

import br.com.gerenciador.adapter.gateways.webservices.CadastrarDespesaService;
import br.com.gerenciador.adapter.gateways.webservices.kafka.KafkaDispatcher;
import br.com.gerenciador.adapter.gateways.webservices.models.DespesaResponse;
import br.com.gerenciador.adapter.gateways.webservices.models.Topicos;
import br.com.gerenciador.core.usecase.models.input.CadastrarDespesaPortInput;
import br.com.gerenciador.dataprovider.entity.DespesaDpEntity;
import br.com.gerenciador.dataprovider.mappers.CadastrarDespesaDpMapper;
import br.com.gerenciador.dataprovider.repository.DespesaRepository;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class CadastrarDespesaServiceImpl implements CadastrarDespesaService {
    private final DespesaRepository repository;
    private final CadastrarDespesaDpMapper mapper;

    public CadastrarDespesaServiceImpl(DespesaRepository repository, CadastrarDespesaDpMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public DespesaResponse cadastrar(CadastrarDespesaPortInput port) {
        try{
            DespesaDpEntity dbEntity = mapper.toDbEntity(port);
            repository.save(dbEntity);

            enviarAnalise(dbEntity);
            
            return mapper.toResponse(dbEntity);
        }catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void enviarAnalise(DespesaDpEntity dbEntity) throws ExecutionException, InterruptedException{
        KafkaDispatcher dispatcher = new KafkaDispatcher<DespesaDpEntity>();
        dispatcher.send(Topicos.CALCULAR_DESPESA.name(), dbEntity.getId().toString(), dbEntity);
    }
}
