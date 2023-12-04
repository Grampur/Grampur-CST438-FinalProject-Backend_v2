package com.javatpoint.springbootcrudoperation; // Adjust the package name accordingly

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.HttpStatus.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.javatpoint.finalProject.controller.SongsController;
import com.javatpoint.finalProject.model.Songs;
import com.javatpoint.finalProject.service.SongsService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SongsControllerTest {

    @Mock
    private SongsService songsService;

    @InjectMocks
    private SongsController songsController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
    
    

    @Test
    public void testGetAllSongs() {
    	Songs song1 = new Songs();
    	song1.setSongid(1);
    	song1.setSongname("Blowing Minds");
    	song1.setSongartist("Asap Mob");
    	song1.setSongduration(300);

    	Songs song2 = new Songs();
    	song2.setSongid(2);
    	song2.setSongname("Butterfly Effect");
    	song2.setSongartist("Travis Scott");
    	song2.setSongduration(200);
    	
        List<Songs> list = Arrays.asList(
                song1, song2
        );
        when(songsService.getAllSongs()).thenReturn(list);

        List<Songs> result = songsController.getAllSongs();

        assertEquals(2, result.size());
        verify(songsService, times(1)).getAllSongs();
    }

    @Test
    public void testGetSongById() {
        int songId = 1;
        Songs song = new Songs();
        song.setSongid(songId);
        song.setSongname("Test_Name");
        song.setSongartist("Test_Artist");
        song.setSongduration(300); // Duration in seconds, for example 5 minutes

        when(songsService.getSongsById(songId)).thenReturn(song);

        Songs result = songsController.getSongs(songId);

        assertNotNull(result);
        assertEquals(songId, result.getSongid());
        assertEquals("Test_Name", result.getSongname());
        assertEquals("Test_Artist", result.getSongartist());
        assertEquals(300, result.getSongduration());
        verify(songsService, times(1)).getSongsById(songId);
    }

    @Test
    public void testSaveSong() {
        Songs song = new Songs();
        song.setSongid(1);
        song.setSongname("Fly me to the moon");
        song.setSongartist("Frank Sinatra");
        song.setSongduration(250);

        doNothing().when(songsService).saveOrUpdate(any(Songs.class));

        songsController.saveSong(song);

        verify(songsService, times(1)).saveOrUpdate(song);
    }

    @Test
    public void testUpdateSong() {
        Songs song = new Songs();
        song.setSongid(1);
        song.setSongname("Fly me to the moon");
        song.setSongartist("Frank Sinatra");
        song.setSongduration(250);

        doNothing().when(songsService).saveOrUpdate(any(Songs.class));

        int result = songsController.saveSong(song);

        assertNotNull(result);
        verify(songsService, times(1)).saveOrUpdate(song);
    }

    @Test
    public void testDeleteSong() {
        int songId = 1;

        doNothing().when(songsService).delete(songId);

        songsController.deleteSong(songId);

        verify(songsService, times(1)).delete(songId);
    }
}