package br.unip.ads.pim.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unip.ads.pim.model.Veiculo;
import br.unip.ads.pim.repository.VeiculoRepository;
import br.unip.ads.pim.service.BaseCrudService;
import br.unip.ads.pim.service.VeiculoService;

@Service
public class VeiculoServiceImpl extends BaseCrudService<Veiculo> implements VeiculoService {

	@Autowired
	private VeiculoRepository repository;
	
	@Override
	public VeiculoRepository getRepository() {
		return this.repository;
	}

}
