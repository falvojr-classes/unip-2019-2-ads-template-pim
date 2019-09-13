package br.unip.ads.pim.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
public class Ocorrencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String titulo;

	@Column
	private String descricao;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Column(nullable = false)
	private LocalDateTime inicio;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Column
	private LocalDateTime fim;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Veiculo veiculo;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Usuario usuario;
	
}
