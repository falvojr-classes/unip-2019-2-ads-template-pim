package br.unip.ads.pim.controller;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.unip.ads.pim.model.Erro;
import br.unip.ads.pim.util.NegocioException;
import br.unip.ads.pim.util.SemResultadoException;

@Component
public abstract class BaseController {

	@ExceptionHandler(NegocioException.class)
	private ResponseEntity<Erro> tratarErroNegocial(NegocioException e) {
		Erro erro = new Erro(e.getMessage());
		return ResponseEntity.badRequest().body(erro);
	}
	
	@ExceptionHandler(SemResultadoException.class)
	private ResponseEntity<Erro> tratarSemResultado(SemResultadoException e) {
		return ResponseEntity.noContent().build();
	}
	
	@ExceptionHandler(Exception.class)
	private ResponseEntity<Erro> tratarErroInesperado(Exception e) {
		// Imprime no Console a pilha do erro.
		e.printStackTrace();
		// Envia para o cliente uma mensagem mais amena.
		Erro erro = new Erro("Ops, ocorreu um erro inesperado.");
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(erro);
	}

	protected URI criarUri(Long id) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(id)
				.toUri();
		return uri;
	}
}
