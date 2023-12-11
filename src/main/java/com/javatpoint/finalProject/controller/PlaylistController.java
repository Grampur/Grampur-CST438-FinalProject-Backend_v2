
package com.javatpoint.finalProject.controller;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatpoint.finalProject.model.Playlist;
import com.javatpoint.finalProject.model.Songs;
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
    
    //POST /playlist/{playlistID}/song/{songid}
    @PostMapping("/playlist/{playlistId}/song/{songId}")
    private Playlist addSongtoPlaylist(@PathVariable("playlistId") int playlistId, @PathVariable("songId") int songId) {
    	
    	return playlistService.addingSongtoPlaylist(playlistId, songId);
    	
    }
    
    //GET /playlist/{playlistID}/songs
    @GetMapping("playlist/{playlistId}/songs")
    private List<Songs> getPlaylistDetails(@PathVariable("playlistId") int playlistId) {
    	return playlistService.getPlaylistDetailsById(playlistId);
    }
    
    
    //delete  /playlist/
    @DeleteMapping ("/playlist/{playlistId}/song/{songId}")
    private void deleteSongFromPlaylist(@PathVariable("playlistId") int playlistId, @PathVariable("songId") int songId) {
    	playlistService.deleteSongFromPlaylist(playlistId, songId);
    }
    
    
    @GetMapping("/user/playlists")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<Playlist>> getUserPlaylists(Principal principal) {
        // Assuming the User class has a method to get the username or ID
        String username = principal.getName();
        List<Playlist> playlists = playlistService.findByUserId(username);
        return ResponseEntity.ok(playlists);
    }
    
    
    
}



