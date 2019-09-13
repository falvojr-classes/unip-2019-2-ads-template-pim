package br.unip.ads.pim.repository;

import org.springframework.data.repository.CrudRepository;

import br.unip.ads.pim.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}
