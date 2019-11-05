package br.unip.ads.pim.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.unip.ads.pim.model.Veiculo;

public interface VeiculoRepository extends CrudRepository<Veiculo, Long> {

	@Query("FROM Veiculo v WHERE v.inativo = false")
	Iterable<Veiculo> findActives();
	
	// TODO Cria a query abaixo (ativos e disponíveis):
	//SELECT DISTINCT v.* FROM veiculo v 
	//WHERE v.inativo = 0 AND
	//	(SELECT COUNT(*) 
	//	FROM ocorrencia o 
	//    WHERE o.veiculo_id = v.id 
	//    AND o.fim IS NULL) = 0
}
