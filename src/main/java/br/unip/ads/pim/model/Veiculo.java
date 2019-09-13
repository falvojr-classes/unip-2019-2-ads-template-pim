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
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, unique = true)
	private String placa;

	@Column(nullable = false)
	private String marca;

	@Column(nullable = false)
	private String modelo;

	@Column(nullable = false)
	private Integer ano;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoVeiculo tipo;

}
