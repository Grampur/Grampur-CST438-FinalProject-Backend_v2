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

import com.javatpoint.finalProject.model.Songs;
import com.javatpoint.finalProject.service.SongsService;

@RestController
public class SongsController {

    @Autowired
    SongsService songsService;

    @GetMapping("/song")
    private List<Songs> getAllSongs() {
        return songsService.getAllSongs();
    }

    @GetMapping("/song/{songid}")
    private Songs getSongs(@PathVariable("songid") int songid) {
        return songsService.getSongsById(songid);
    }

    @DeleteMapping("/song/{songid}")
    private void deleteSong(@PathVariable("songid") int songid) {
        songsService.delete(songid);
    }

    @PostMapping("/songs")
    private int saveSong(@RequestBody Songs songs) {
        songsService.saveOrUpdate(songs);
        System.out.println("CAN YOU WORK??");
        return songs.getSongid();
    }

    @PutMapping("/songs")
    private Songs update(@RequestBody Songs songs) {
        songsService.saveOrUpdate(songs);
        return songs;
    }
}