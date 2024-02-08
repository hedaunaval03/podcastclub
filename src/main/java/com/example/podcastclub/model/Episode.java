package com.example.podcastclub.model;

import java.sql.Date;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "episodes")
public class Episode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	@Column(nullable = false)
	private Date releaseDate;
	
	@Column(nullable = false)
	private String audioUrl;

}
