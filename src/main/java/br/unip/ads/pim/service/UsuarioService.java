package br.unip.ads.pim.service;

import br.unip.ads.pim.model.Usuario;

public interface UsuarioService extends CrudService<Usuario> {
	
	Usuario logar(Usuario credenciais);
}
