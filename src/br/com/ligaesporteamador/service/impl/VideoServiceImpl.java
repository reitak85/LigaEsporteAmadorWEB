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

}
