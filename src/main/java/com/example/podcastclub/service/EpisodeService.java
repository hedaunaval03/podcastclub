package com.example.podcastclub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.podcastclub.model.Episode;
import com.example.podcastclub.repository.EpisodeRepository;

@Service
public class EpisodeService {
	
	@Autowired
	private EpisodeRepository episodeRepository;
	
	
	public List<Episode> getAllEpisodes(){
		return episodeRepository.findAll();
	}
	
	public Episode getEpisodeById(Long id) {
		return episodeRepository.getById(id);
	}
	
	public Episode createEpisode(Episode episode) {
		return episodeRepository.save(episode);
	}
	
	public Episode updateEpisode(Long id,Episode episode) {
		if(episodeRepository.existsById(id)) {
			episode.setId(id);
			return episodeRepository.save(episode);
		}
		return null;
	}
	
	public void deleteEpisode(Long id){
		episodeRepository.deleteById(id);
	}

}
