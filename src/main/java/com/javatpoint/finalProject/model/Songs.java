package com.javatpoint.finalProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Songs")
public class Songs {

    @Id
    @Column
    private int songid;

    @Column
    private String songname;

    @Column
    private String songartist;

    @Column
    private int songduration;

	public int getSongid() {
		return songid;
	}

	public void setSongid(int songid) {
		this.songid = songid;
	}

	public String getSongname() {
		return songname;
	}

	public void setSongname(String songname) {
		this.songname = songname;
	}

	public String getSongartist() {
		return songartist;
	}

	public void setSongartist(String songartist) {
		this.songartist = songartist;
	}

	public int getSongduration() {
		return songduration;
	}

	public void setSongduration(int songduration) {
		this.songduration = songduration;
	}

		
  
}
