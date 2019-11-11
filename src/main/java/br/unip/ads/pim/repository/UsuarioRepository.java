package br.unip.ads.pim.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.unip.ads.pim.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	@Query("FROM Usuario u WHERE u.email = ?1 AND u.senha = ?2")
	Optional<Usuario> buscarPorEmailSenha(String email, String senha);
	
	@Query("FROM Usuario u WHERE u.cpf = ?1 AND u.senha = ?2")
	Optional<Usuario> buscarPorCpfSenha(String cpf, String senha);
}
