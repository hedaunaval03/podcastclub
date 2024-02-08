package com.example.podcastclub.repository;

import java.util.List;

import org.apache.tomcat.util.security.PrivilegedGetTccl;
import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.podcastclub.model.Episode;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Long>{
	
	
	

}
