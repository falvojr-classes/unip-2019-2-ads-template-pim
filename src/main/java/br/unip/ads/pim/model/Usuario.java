package br.unip.ads.pim.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String senha;

	@Column(nullable = false, unique = true)
	private String cpf;

	@Column
	private String telefone;

	@Column
	private String logradouro;

	@Column
	private String complemento;

	@Column
	private String cep;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoUsuario tipo;

}
