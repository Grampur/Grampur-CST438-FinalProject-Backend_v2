package com.javatpoint.finalProject.repository;

import org.springframework.data.repository.CrudRepository;

import com.javatpoint.finalProject.model.Songs;

public interface SongsRepository extends CrudRepository<Songs, Integer> {

}
