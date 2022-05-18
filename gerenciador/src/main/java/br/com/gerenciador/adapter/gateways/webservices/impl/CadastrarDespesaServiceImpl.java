package br.com.gerenciador.adapter.gateways.webservices.impl;

import br.com.gerenciador.adapter.gateways.webservices.CadastrarDespesaService;
import br.com.gerenciador.adapter.gateways.webservices.models.DespesaResponse;
import br.com.gerenciador.core.usecase.models.input.CadastrarDespesaPortInput;
import br.com.gerenciador.dataprovider.entity.DespesaDpEntity;
import br.com.gerenciador.dataprovider.mappers.CadastrarDespesaDpMapper;
import br.com.gerenciador.dataprovider.repository.DespesaRepository;
import org.springframework.stereotype.Service;

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
        DespesaDpEntity dbEntity = mapper.toDbEntity(port);
        repository.save(dbEntity);

        return mapper.toResponse(dbEntity);
    }
}
