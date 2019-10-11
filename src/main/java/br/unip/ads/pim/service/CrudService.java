package br.unip.ads.pim.service;

public interface CrudService<T> {
	
	Iterable<T> buscarTodos();

	T buscarUm(Long id);

	void inserir(T entidade);

	void alterar(Long id, T entidade);

	void deletar(Long id);
}
