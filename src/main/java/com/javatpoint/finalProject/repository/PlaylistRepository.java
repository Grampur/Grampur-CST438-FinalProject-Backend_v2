package com.javatpoint.finalProject.repository;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

import com.javatpoint.finalProject.model.Playlist;

public interface PlaylistRepository extends CrudRepository<Playlist, Integer> {

	//write find by methods where you would put sql access
	//look at the old assignments
	public Playlist findById(int playlist_id);

	List<Playlist> findAllByUserId(int user_id);
}
