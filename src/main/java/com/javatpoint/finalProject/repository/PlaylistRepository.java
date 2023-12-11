package com.javatpoint.finalProject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.javatpoint.finalProject.model.Playlist;

public interface PlaylistRepository extends CrudRepository<Playlist, Integer> {
    List<Playlist> findByUserid(String userid);
}
