package br.com.ligaesporteamador.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ligaesporteamador.dao.VideoDao;
import br.com.ligaesporteamador.model.Video;
import br.com.ligaesporteamador.service.VideoService;

@Service
public class VideoServiceImpl implements VideoService{

	@Autowired
	VideoDao videoDao;
	
	@Override
	public List<Video> findVideoHome() throws Exception {
		return videoDao.findVideoHome();
	}

	
	@Override
	public void insertVideo(Video video) throws Exception {
		videoDao.insertVideo(video);
	}


	@Override
	public List<Video> findHomeVideoAmador() throws Exception {
		return videoDao.findHomeVideoAmador();
	}


	@Override
	public List<Video> findAllVideo(String nome) throws Exception {
		return videoDao.findAllVideo(nome);
	}


	@Override
	public List<Video> findVideoFutebol() throws Exception {
		return videoDao.findVideoFutebol();
	}


	@Override
	public List<Video> findVideoBasquete() throws Exception {
		return videoDao.findVideoBasquete();
	}


	@Override
	public List<Video> findVideoVolei() throws Exception {
		return videoDao.findVideoVolei();
	}


	@Override
	public List<Video> findVideoHandebol() throws Exception {
		return videoDao.findVideoHandebol();
	}


	@Override
	public List<Video> findVideoTenis() throws Exception {
		return videoDao.findVideoTenis();
	}


	@Override
	public List<Video> findVideoRugby() throws Exception {
		return videoDao.findVideoRugby();
	}


	@Override
	public List<Video> findVideoAmadorFutebol() throws Exception {
		return videoDao.findVideoAmadorFutebol();
	}


	@Override
	public List<Video> findVideoAmadorBasquete() throws Exception {
		return null;
	}


	@Override
	public List<Video> findVideoAmadorVolei() throws Exception {
		return null;
	}


	@Override
	public List<Video> findVideoAmadorHandebol() throws Exception {
		return null;
	}


	@Override
	public List<Video> findVideoAmadorTenis() throws Exception {
		return null;
	}


	@Override
	public List<Video> findVideoAmadorRugby() throws Exception {
		return null;
	}

}
