package br.unip.ads.pim.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.unip.ads.pim.model.Veiculo;

public interface VeiculoRepository extends CrudRepository<Veiculo, Long> {

	@Query("FROM Veiculo v WHERE v.inativo = false AND " + 
				"(SELECT COUNT(o) FROM Ocorrencia o "
				+ "WHERE o.veiculo.id = v.id "
				+ "AND o.fim IS NULL) = 0")
	Iterable<Veiculo> buscarDisponiveis();
}
