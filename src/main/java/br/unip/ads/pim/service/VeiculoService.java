package br.unip.ads.pim.service;

import br.unip.ads.pim.model.Veiculo;

public interface VeiculoService extends CrudService<Veiculo> {

	Iterable<Veiculo> buscarTodos(Boolean ehCliente);

}
