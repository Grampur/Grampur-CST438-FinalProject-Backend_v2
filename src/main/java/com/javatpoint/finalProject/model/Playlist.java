package com.javatpoint.finalProject.model;

import javax.persistence.ElementCollection;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import java.util.List;

@Entity
@Table
public class Playlist {

    @Id
    @Column
    private int playlistId;

    @Column
    private int userId;

    @Column
    private String playlistName;

    @Column
    private int playlistSize;
    
    @OneToMany
    @CollectionTable(name = "playlist_details", joinColumns = @JoinColumn(name = "playlistId"))
    private List<Songs> songs;
    
    public void addSong(Songs song) {
    	songs.add(song);
    }
    
    public void deleteSong(Songs song) {
    	songs.remove(song);
    }
    
    public List<Songs> getAllSongs() {
    	return songs;
    }
    
    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public int getPlaylistSize() {
        return playlistSize;
    }

    public void setPlaylistSize(int playlistSize) {
        this.playlistSize = playlistSize;
    }
}
