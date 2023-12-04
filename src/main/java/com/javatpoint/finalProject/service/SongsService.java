package com.javatpoint.finalProject.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatpoint.finalProject.model.Songs;
import com.javatpoint.finalProject.repository.SongsRepository;

@Service
public class SongsService {

    @Autowired
    SongsRepository songsRepository;

    public List<Songs> getAllSongs() {
        List<Songs> songs = new ArrayList<Songs>();
        songsRepository.findAll().forEach(songs1 -> songs.add(songs1));
        return songs;
    }

    public Songs getSongsById(int id) {
        return songsRepository.findById(id).get();
    }

    public void saveOrUpdate(Songs songs) {
        songsRepository.save(songs);
    }

    public void delete(int id) {
        songsRepository.deleteById(id);
    }

    public void update(Songs songs, int songid) {
        songsRepository.save(songs);
    }
}
