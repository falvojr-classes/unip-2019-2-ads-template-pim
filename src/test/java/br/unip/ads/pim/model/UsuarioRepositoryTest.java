package br.unip.ads.pim.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.unip.ads.pim.repository.UsuarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Test
	public void insert() {
		Usuario usuario = new Usuario();
		usuario.setCpf("36289058851");
		usuario.setEmail("falvojr@gmail.com");
		usuario.setSenha("123456");
		usuario.setTipo(TipoUsuario.FUNCIONARIO);
		
		usuarioRepository.save(usuario);
	}
}
