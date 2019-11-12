package br.unip.ads.pim.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unip.ads.pim.model.Ocorrencia;
import br.unip.ads.pim.repository.OcorrenciaRepository;
import br.unip.ads.pim.service.BaseCrudService;
import br.unip.ads.pim.service.OcorrenciaService;
import br.unip.ads.pim.util.NegocioException;
import br.unip.ads.pim.util.SemResultadoException;

@Service
public class OcorrenciaServiceImpl extends BaseCrudService<Ocorrencia> implements OcorrenciaService {

	@Autowired
	private OcorrenciaRepository repository;
	
	@Override
	public OcorrenciaRepository getRepository() {
		return this.repository;
	}

	@Override
	public void inserir(Ocorrencia entidade) {
		entidade.setInicio(LocalDateTime.now());
		super.inserir(entidade);
	}

	@Override
	public void encerrar(Long id, Ocorrencia entidade) {
		entidade.setFim(LocalDateTime.now());
		Optional<Ocorrencia> entidadeBd = this.getRepository().findById(id);
		if (entidadeBd.isPresent()) {
			if (entidadeBd.get().getFim() != null) {
				throw new NegocioException("Essa ocorrencia já foi encerrada.");
			}
			this.getRepository().save(entidade);
		} else {
			throw new SemResultadoException();
		}
	}

	@Override
	public Iterable<Ocorrencia> buscarTodos(Long idFuncionario, Long idVeiculo) {
		if (idFuncionario != null) {
			return this.getRepository().buscarPorIdUsuario(idFuncionario);
		} else if (idVeiculo != null) {
			return this.getRepository().buscarPorIdVeiculo(idVeiculo);
		} else {
			return super.buscarTodos();
		}
	}
}
