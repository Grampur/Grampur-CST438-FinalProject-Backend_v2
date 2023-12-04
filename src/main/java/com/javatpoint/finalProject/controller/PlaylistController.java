
package com.javatpoint.finalProject.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatpoint.finalProject.model.Playlist;
import com.javatpoint.finalProject.service.PlaylistService;

@RestController
public class PlaylistController {

    @Autowired
    PlaylistService playlistService;

    @GetMapping("/playlist")
    private List<Playlist> getAllPlaylists() {
        return playlistService.getAllPlaylists();
    }

    @GetMapping("/playlist/{playlistId}")
    private Playlist getPlaylist(@PathVariable("playlistId") int playlistId) {
        return playlistService.getPlaylistById(playlistId);
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



