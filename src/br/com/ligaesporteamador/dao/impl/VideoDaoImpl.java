package br.com.ligaesporteamador.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.com.ligaesporteamador.bd.DataAccessService;
import br.com.ligaesporteamador.dao.VideoDao;
import br.com.ligaesporteamador.model.Video;

@Repository
public class VideoDaoImpl extends DataAccessService<Video> implements VideoDao {

	@Override
	public List<Video> findVideoHome() throws Exception {

		Map<String, Object> params = new HashMap<String, Object>();

		String query = "SELECT v FROM Video v WHERE lower(v.categoria) = lower(:categoria) "
				+ "and v.destaqueVideo = :destaqueVideo "
				+ "order by v.dataDeCriacao desc LIMIT 0, 4";

		params.put("categoria", "Profissional");
		params.put("destaqueVideo", new Boolean(true));

		return createQueryById(query, params);

	}

	@Override
	public void insertVideo(Video video) throws Exception {
		create(video);
	}

	@Override
	public List<Video> findHomeVideoAmador() throws Exception {

		Map<String, Object> params = new HashMap<String, Object>();

		String query = "SELECT v FROM Video v WHERE lower(v.categoria) = lower(:categoria) "
				+ "and v.destaqueVideo = :destaqueVideo "
				+ "order  by v.dataDeCriacao desc LIMIT 0, 4";
		
		params.put("categoria", "Amador");
		params.put("destaqueVideo", new Boolean(true));
		

		return createQueryById(query, params);
	}

	@Override
	public List<Video> findAllVideo(String nome) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();

		String query = "SELECT v FROM Video v WHERE lower(v.palavraChave) like lower(:palavraChave) order by v.dataDeCriacao desc";

		params.put("palavraChave", "%"+nome+"%");

		return createQueryById(query, params);
	}

	@Override
	public List<Video> findVideoFutebol() throws Exception {
		
		Map<String, Object> params = new HashMap<String, Object>();

		String query = "SELECT v FROM Video v WHERE lower(v.categoria) = lower(:categoria) "
				+ "and v.destaqueVideo = :destaqueVideo "
				+ "and lower(v.esporte.nome) = lower(:esporteNome)" 
				+ "order by v.dataDeCriacao desc LIMIT 0, 4";

		params.put("categoria", "Profissional");
		params.put("esporteNome", "futebol");
		params.put("destaqueVideo", new Boolean(true));

		return createQueryById(query, params);
	}

	@Override
	public List<Video> findVideoBasquete() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();

		String query = "SELECT v FROM Video v WHERE lower(v.categoria) = lower(:categoria) "
				+ "and v.destaqueVideo = :destaqueVideo "
				+ "and lower(v.esporte.nome) = lower(:esporteNome)"
				+ "order by v.dataDeCriacao desc LIMIT 0, 4";

		params.put("categoria", "Profissional");
		params.put("esporteNome", "basquete");
		params.put("destaqueVideo", new Boolean(true));

		return createQueryById(query, params);
	}

	@Override
	public List<Video> findVideoVolei() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();

		String query = "SELECT v FROM Video v WHERE lower(v.categoria) = lower(:categoria) "
				+ "and v.destaqueVideo = :destaqueVideo "
				+ "and lower(v.esporte.nome) = lower(:esporteNome)"
				+ "order by v.dataDeCriacao desc LIMIT 0, 4";

		params.put("categoria", "Profissional");
		params.put("esporteNome", "volei");
		params.put("destaqueVideo", new Boolean(true));

		return createQueryById(query, params);
	}

	@Override
	public List<Video> findVideoHandebol() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();

		String query = "SELECT v FROM Video v WHERE lower(v.categoria) = lower(:categoria) "
				+ "and v.destaqueVideo = :destaqueVideo "
				+ "and lower(v.esporte.nome) = lower(:esporteNome)"
				+ "order by v.dataDeCriacao desc LIMIT 0, 4";

		params.put("categoria", "Profissional");
		params.put("esporteNome", "handebol");
		params.put("destaqueVideo", new Boolean(true));

		return createQueryById(query, params);
	}

	@Override
	public List<Video> findVideoTenis() throws Exception {
		
		Map<String, Object> params = new HashMap<String, Object>();

		String query = "SELECT v FROM Video v WHERE lower(v.categoria) = lower(:categoria) "
				+ "and v.destaqueVideo = :destaqueVideo "
				+ "and lower(v.esporte.nome) = lower(:esporteNome)"
				+ "order by v.dataDeCriacao desc LIMIT 0, 4";

		params.put("categoria", "Profissional");
		params.put("esporteNome", "tenis");
		params.put("destaqueVideo", new Boolean(true));

		return createQueryById(query, params);
	}

	@Override
	public List<Video> findVideoRugby() throws Exception {
		
		Map<String, Object> params = new HashMap<String, Object>();

		String query = "SELECT v FROM Video v WHERE lower(v.categoria) = lower(:categoria) "
				+ "and v.destaqueVideo = :destaqueVideo "
				+ "and lower(v.esporte.nome) = lower(:esporteNome)"
				+ "order by v.dataDeCriacao desc LIMIT 0, 4";

		params.put("categoria", "Profissional");
		params.put("esporteNome", "rugby");
		params.put("destaqueVideo", new Boolean(true));

		return createQueryById(query, params);
	}

	@Override
	public List<Video> findVideoAmadorFutebol() throws Exception {
		
		Map<String, Object> params = new HashMap<String, Object>();

		String query = "SELECT v FROM Video v WHERE lower(v.categoria) = lower(:categoria) "
				+ "and v.destaqueVideo = :destaqueVideo "
				+ "and lower(v.esporte.nome) = lower(:esporteNome)"
				+ "order  by v.dataDeCriacao desc LIMIT 0, 4";
		
		params.put("categoria", "Amador");
		params.put("esporteNome", "futebol");
		params.put("destaqueVideo", new Boolean(true));
		

		return createQueryById(query, params);
	}

	@Override
	public List<Video> findVideoAmadorBasquete() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();

		String query = "SELECT v FROM Video v WHERE lower(v.categoria) = lower(:categoria) "
				+ "and v.destaqueVideo = :destaqueVideo "
				+ "and lower(v.esporte.nome) = lower(:esporteNome)"
				+ "order  by v.dataDeCriacao desc LIMIT 0, 4";
		
		params.put("categoria", "Amador");
		params.put("esporteNome", "basquete");
		params.put("destaqueVideo", new Boolean(true));
		

		return createQueryById(query, params);
	}

	@Override
	public List<Video> findVideoAmadorVolei() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();

		String query = "SELECT v FROM Video v WHERE lower(v.categoria) = lower(:categoria) "
				+ "and v.destaqueVideo = :destaqueVideo "
				+ "and lower(v.esporte.nome) = lower(:esporteNome)"
				+ "order  by v.dataDeCriacao desc LIMIT 0, 4";
		
		params.put("categoria", "Amador");
		params.put("esporteNome", "volei");
		params.put("destaqueVideo", new Boolean(true));
		

		return createQueryById(query, params);
	}

	@Override
	public List<Video> findVideoAmadorHandebol() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();

		String query = "SELECT v FROM Video v WHERE lower(v.categoria) = lower(:categoria) "
				+ "and v.destaqueVideo = :destaqueVideo "
				+ "and lower(v.esporte.nome) = lower(:esporteNome)"
				+ "order  by v.dataDeCriacao desc LIMIT 0, 4";
		
		params.put("categoria", "Amador");
		params.put("esporteNome", "handebol");
		params.put("destaqueVideo", new Boolean(true));
		

		return createQueryById(query, params);
	}

	@Override
	public List<Video> findVideoAmadorTenis() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();

		String query = "SELECT v FROM Video v WHERE lower(v.categoria) = lower(:categoria) "
				+ "and v.destaqueVideo = :destaqueVideo "
				+ "and lower(v.esporte.nome) = lower(:esporteNome)"
				+ "order  by v.dataDeCriacao desc LIMIT 0, 4";
		
		params.put("categoria", "Amador");
		params.put("esporteNome", "tenis");
		params.put("destaqueVideo", new Boolean(true));
		

		return createQueryById(query, params);
	}

	@Override
	public List<Video> findVideoAmadorRugby() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();

		String query = "SELECT v FROM Video v WHERE lower(v.categoria) = lower(:categoria) "
				+ "and v.destaqueVideo = :destaqueVideo "
				+ "and lower(v.esporte.nome) = lower(:esporteNome)"
				+ "order  by v.dataDeCriacao desc LIMIT 0, 4";
		
		params.put("categoria", "Amador");
		params.put("esporteNome", "rugby");
		params.put("destaqueVideo", new Boolean(true));
		

		return createQueryById(query, params);
	}

}
