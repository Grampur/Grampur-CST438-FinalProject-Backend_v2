package com.javatpoint.finalProject.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatpoint.finalProject.model.Playlist;
import com.javatpoint.finalProject.repository.PlaylistRepository;

@Service
public class PlaylistService {

    @Autowired
    PlaylistRepository playlistRepository;

    public List<Playlist> getAllPlaylists() {
        List<Playlist> playlists = new ArrayList<>();
        playlistRepository.findAll().forEach(playlists::add);
        return playlists;
    }

    public Playlist getPlaylistById(int playlistId) {
        return playlistRepository.findById(playlistId).orElse(null);
    }

    public void saveOrUpdate(Playlist playlist) {
        playlistRepository.save(playlist);
    }

    public void delete(int playlistId) {
        playlistRepository.deleteById(playlistId);
    }

    public void update(Playlist playlist, int playlistId) {
        playlistRepository.save(playlist);
    }
}
