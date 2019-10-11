package br.unip.ads.pim.service;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.unip.ads.pim.util.SemResultadoException;

public abstract class BaseCrudService<T> implements CrudService<T> {

	public abstract CrudRepository<T, Long> getRepository();
	
	@Override
	public Iterable<T> buscarTodos() {
		return this.getRepository().findAll();
	}

	@Override
	public T buscarUm(Long id) {
		Optional<T> entidade = this.getRepository().findById(id);
		if (entidade.isPresent()) {
			return entidade.get();
		} else {
			throw new SemResultadoException();
		}
	}

	@Override
	public void inserir(T entidade) {
		this.getRepository().save(entidade);
	}

	@Override
	public void alterar(Long id, T entidade) {
		Optional<T> entidadeBd = this.getRepository().findById(id);
		if (entidadeBd.isPresent()) {
			this.getRepository().save(entidade);
		} else {
			throw new SemResultadoException();
		}
	}

	@Override
	public void deletar(Long id) {
		Optional<T> entidade = this.getRepository().findById(id);
		if (entidade.isPresent()) {
			this.getRepository().delete(entidade.get());
		} else {
			throw new SemResultadoException();
		}
	}

}
