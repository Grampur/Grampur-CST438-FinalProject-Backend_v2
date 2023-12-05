package com.javatpoint.finalProject.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatpoint.finalProject.model.Playlist;
import com.javatpoint.finalProject.model.Songs;
import com.javatpoint.finalProject.repository.PlaylistRepository;
import com.javatpoint.finalProject.repository.SongsRepository;

@Service
public class PlaylistService {

    @Autowired
    PlaylistRepository playlistRepository;
    
    @Autowired
    SongsRepository songsRepository;
    

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
    
    public Playlist addingSongtoPlaylist(int playlistId,  int songId ) {
    	Playlist playlist = playlistRepository.findById(playlistId).orElse(null);
        Songs song = songsRepository.findById(songId).orElse(null);
        
        if (playlist != null && song != null) {
            playlist.addSong(song);
            playlistRepository.save(playlist);
        }
        
        return playlist;
    }
    
    public List<Songs> getPlaylistDetailsById(int playlistId) {
    	Playlist playlist = playlistRepository.findById(playlistId).orElse(null);
    	if(playlist == null) {
    		
    	}
    	return playlist.getAllSongs();
    	
    	
    	
    }
    
    public void deleteSongFromPlaylist (int playlistId, int songId) {
    	Playlist playlist = playlistRepository.findById(playlistId).orElse(null);
    	Songs song = songsRepository.findById(songId).orElse(null);
    	
    	if(playlist != null && song != null) {
    		playlist.deleteSong(song);
    		playlistRepository.save(playlist);
    	}
    	
    }
    
    
}
