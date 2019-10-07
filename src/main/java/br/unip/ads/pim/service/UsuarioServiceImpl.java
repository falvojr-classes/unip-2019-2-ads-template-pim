package br.unip.ads.pim.service;

import static org.springframework.util.StringUtils.isEmpty;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unip.ads.pim.model.Usuario;
import br.unip.ads.pim.repository.UsuarioRepository;
import br.unip.ads.pim.util.NegocioException;
import br.unip.ads.pim.util.SemResultadoException;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public Usuario logar(Usuario credenciais) {
		String email = credenciais.getEmail();
		String cpf = credenciais.getCpf();
		String senha = credenciais.getSenha();
		
		// Aplica as regras de negocio iniciais:
		if (isEmpty(email) && isEmpty(cpf)) {
			throw new NegocioException("CPF ou Email obrigatorios.");
		}
		if (isEmpty(senha)) {
			throw new NegocioException("Senha obrigatoria.");
		}
		
		// Consulta as credenciais no banco de dados
		Optional<Usuario> usuario;
		if (!isEmpty(email)) {
			usuario = repository.findByEmailAndSenha(email, senha);
		} else {
			usuario = repository.findByCpfAndSenha(cpf, senha);
		}
		
		// Valida se as credenciais são validas
		if (usuario.isPresent()) {
			return usuario.get();
		} else {
			throw new NegocioException("Credencial invalida.");
		}
	}

	@Override
	public Iterable<Usuario> buscarTodos() {
		return repository.findAll();
	}

	@Override
	public Usuario buscarUm(Long id) {
		Optional<Usuario> usuario = repository.findById(id);
		if (usuario.isPresent()) {
			return usuario.get();
		} else {
			throw new SemResultadoException();
		}
	}

	@Override
	public void inserir(Usuario usuario) {
		//TODO Incluir regras de negocio para inclusao de Usuario
		repository.save(usuario);
	}

	@Override
	public void alterar(Long id, Usuario usuario) {
		Optional<Usuario> usuarioBd = repository.findById(id);
		if (usuarioBd.isPresent()) {
			repository.save(usuario);
		} else {
			throw new SemResultadoException();
		}
	}

	@Override
	public void deletar(Long id) {
		Optional<Usuario> usuario = repository.findById(id);
		if (usuario.isPresent()) {
			repository.delete(usuario.get());
		} else {
			throw new SemResultadoException();
		}
	}

}
