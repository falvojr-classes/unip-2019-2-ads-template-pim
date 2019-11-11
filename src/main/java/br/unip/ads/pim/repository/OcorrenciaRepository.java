package br.unip.ads.pim.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.unip.ads.pim.model.Ocorrencia;

public interface OcorrenciaRepository extends CrudRepository<Ocorrencia, Long> {

	@Query("FROM Ocorrencia o WHERE o.usuario.id = ?1")
	Optional<Ocorrencia> buscarPorIdUsuario(Long idUsuario);
	
	@Query("FROM Ocorrencia o WHERE o.veiculo.id = ?1")
	Optional<Ocorrencia> buscarPorIdVeiculo(Long idVeiculo);
}
