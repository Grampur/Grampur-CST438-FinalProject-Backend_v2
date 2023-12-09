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

	@Column
    private int userid;
	
    @Id
    @Column
    private int playlistid;

    @Column
    private String playlistname;

    @Column
    private int playlistsize;
    
    @OneToMany
    @CollectionTable(name = "Playlist_details", joinColumns = @JoinColumn(name = "playlistid"))
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
        return playlistid;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistid = playlistId;
    }

    public int getUserId() {
        return userid;
    }

    public void setUserId(int userId) {
        this.userid = userId;
    }

    public String getPlaylistName() {
        return playlistname;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistname = playlistName;
    }

    public int getPlaylistSize() {
        return playlistsize;
    }

    public void setPlaylistSize(int playlistSize) {
        this.playlistsize = playlistSize;
    }
}
