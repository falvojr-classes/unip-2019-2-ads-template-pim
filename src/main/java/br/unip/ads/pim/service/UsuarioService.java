package br.unip.ads.pim.service;

import br.unip.ads.pim.model.Usuario;

public interface UsuarioService {
	Usuario logar(Usuario credenciais);

	Iterable<Usuario> buscarTodos();

	Usuario buscarUm(Long id);

	void inserir(Usuario usuario);

	void alterar(Long id, Usuario usuario);

	void deletar(Long id);
}
