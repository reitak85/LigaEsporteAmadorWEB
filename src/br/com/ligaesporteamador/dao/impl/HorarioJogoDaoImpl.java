package br.com.ligaesporteamador.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.com.ligaesporteamador.bd.DataAccessService;
import br.com.ligaesporteamador.dao.HorarioJogoDao;
import br.com.ligaesporteamador.model.HorarioJogo;

@Repository
public class HorarioJogoDaoImpl extends DataAccessService<HorarioJogo>
		implements HorarioJogoDao {

	@Override
	public HorarioJogo saveHorarioJogo(HorarioJogo horarioJogo) throws Exception {
		return create(horarioJogo);
	}

	@Override
	public List<HorarioJogo> findHorarioJogos(HorarioJogo horarioJogo)
			throws Exception {

		Map<String, Object> params = new HashMap<String, Object>();

		String query = "SELECT H FROM HorarioJogo H WHERE H.quandraCampo.id = :QUADRA_ID";
		params.put("QUADRA_ID", horarioJogo.getQuandraCampo().getId());

		return createQueryById(query, params);
	}

}
