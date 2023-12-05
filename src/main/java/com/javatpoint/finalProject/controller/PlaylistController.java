
package com.javatpoint.finalProject.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.javatpoint.finalProject.model.Playlist;
import com.javatpoint.finalProject.repository.PlaylistRepository;
import com.javatpoint.finalProject.service.PlaylistService;

@CrossOrigin
@RestController
public class PlaylistController {

    @Autowired
    PlaylistService playlistService;

    @Autowired
    PlaylistRepository playlistRepository;
    
    @GetMapping("/playlist")
    private List<Playlist> getAllPlaylists() {
        return playlistService.getAllPlaylists();
    }

    // Ray recommended to instead call from the playlistRepository directly and then write the function
    // there
    @GetMapping("/playlist/playlistId/{playlistId}")
    private Playlist getPlaylist(@PathVariable("playlistId") int playlistId) {
        return playlistRepository.findById(playlistId);
    }
    
    // Added by Haider
    @GetMapping("/playlist/userId/{user_id}")
    private List<Playlist> getPlaylistByUser(@PathVariable("user_id") int user_id){
    	List<Playlist> userPlayLists = new ArrayList<Playlist>();
    	userPlayLists = playlistRepository.findAllByUserId(user_id);
    	return userPlayLists;
    }

    @DeleteMapping("/playlist/{playlistId}")
    private void deletePlaylist(@PathVariable("playlistId") int playlistId) {
        playlistService.delete(playlistId);
    }

    @PostMapping("/playlists")
    private int savePlaylist(@RequestBody Playlist playlist) {
        playlistService.saveOrUpdate(playlist);
        return playlist.getPlaylistId();
    }

    @PutMapping("/playlists")
    private Playlist update(@RequestBody Playlist playlist) {
        playlistService.saveOrUpdate(playlist);
        return playlist;
    }
}



