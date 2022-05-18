package br.com.gerenciador.dataprovider.repository;

import br.com.gerenciador.dataprovider.entity.DespesaDpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DespesaRepository extends JpaRepository<DespesaDpEntity,Long> {

}
