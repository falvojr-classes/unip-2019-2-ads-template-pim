package br.unip.ads.pim.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unip.ads.pim.model.Veiculo;
import br.unip.ads.pim.repository.VeiculoRepository;
import br.unip.ads.pim.service.BaseCrudService;
import br.unip.ads.pim.service.VeiculoService;
import br.unip.ads.pim.util.SemResultadoException;

@Service
public class VeiculoServiceImpl extends BaseCrudService<Veiculo> implements VeiculoService {

	@Autowired
	private VeiculoRepository repository;
	
	@Override
	public VeiculoRepository getRepository() {
		return this.repository;
	}

	@Override
	public Iterable<Veiculo> buscarTodos() {
		return this.getRepository().findActives();
	}
	
	@Override
	public void deletar(Long id) {
		Optional<Veiculo> entidade = this.getRepository().findById(id);
		if (entidade.isPresent()) {
			entidade.get().setInativo(true);
			this.getRepository().save(entidade.get());
		} else {
			throw new SemResultadoException();
		}
	}
}
