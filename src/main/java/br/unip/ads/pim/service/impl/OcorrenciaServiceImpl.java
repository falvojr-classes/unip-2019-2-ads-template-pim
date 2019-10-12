package br.unip.ads.pim.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unip.ads.pim.model.Ocorrencia;
import br.unip.ads.pim.repository.OcorrenciaRepository;
import br.unip.ads.pim.service.BaseCrudService;
import br.unip.ads.pim.service.OcorrenciaService;

@Service
public class OcorrenciaServiceImpl extends BaseCrudService<Ocorrencia> implements OcorrenciaService {

	@Autowired
	private OcorrenciaRepository repository;
	
	@Override
	public OcorrenciaRepository getRepository() {
		return this.repository;
	}

	@Override
	public void inserir(Ocorrencia entidade) {
		entidade.setInicio(LocalDateTime.now());
		super.inserir(entidade);
	}
}
