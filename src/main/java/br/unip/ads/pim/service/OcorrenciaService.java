package br.unip.ads.pim.service;

import br.unip.ads.pim.model.Ocorrencia;

public interface OcorrenciaService extends CrudService<Ocorrencia> {

	void encerrar(Long id, Ocorrencia entidade);

}
