package com.example.podcastclub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.podcastclub.model.Episode;
import com.example.podcastclub.service.EpisodeService;

@RestController
@RequestMapping("/api/episodes")
public class EpisodeController {
	
	@Autowired
	private EpisodeService episodeService;
	
	
	@GetMapping
	public ResponseEntity<List<Episode>> getAllEpisodes(){
		List<Episode> episodes = episodeService.getAllEpisodes();
		
		return ResponseEntity.ok(episodes);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Episode> getEpisodeById(@PathVariable Long id){
		
		Episode episode = episodeService.getEpisodeById(id);
		
		if(episode!=null) {
			return ResponseEntity.ok(episode);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Episode> createEpisode(@RequestBody Episode episode){
		Episode createdepisode = episodeService.createEpisode(episode);
		
		return new ResponseEntity<>(createdepisode,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Episode> updateEpisode(@PathVariable Long id,@RequestBody Episode episode){
		Episode updatedEpisode = episodeService.updateEpisode(id,episode);
		
		if(updatedEpisode!=null) {
			return ResponseEntity.ok(updatedEpisode);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEpisode(@PathVariable Long id){
		episodeService.deleteEpisode(id);
		return ResponseEntity.noContent().build();
	}
	
	

}
