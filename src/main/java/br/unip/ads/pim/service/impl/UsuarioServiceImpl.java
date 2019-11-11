package br.unip.ads.pim.service.impl;

import static org.springframework.util.StringUtils.isEmpty;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unip.ads.pim.model.Usuario;
import br.unip.ads.pim.repository.UsuarioRepository;
import br.unip.ads.pim.service.BaseCrudService;
import br.unip.ads.pim.service.UsuarioService;
import br.unip.ads.pim.util.NegocioException;

@Service
public class UsuarioServiceImpl extends BaseCrudService<Usuario> implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public UsuarioRepository getRepository() {
		return this.repository;
	}
	
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
			usuario = repository.buscarPorEmailSenha(email, senha);
		} else {
			usuario = repository.buscarPorCpfSenha(cpf, senha);
		}
		
		// Valida se as credenciais são validas
		if (usuario.isPresent()) {
			return usuario.get();
		} else {
			throw new NegocioException("Credencial invalida.");
		}
	}

	@Override
	public void inserir(Usuario entidade) {
		// TODO Implementar as regras de negocio de Usuario
		super.inserir(entidade);
	}
}
