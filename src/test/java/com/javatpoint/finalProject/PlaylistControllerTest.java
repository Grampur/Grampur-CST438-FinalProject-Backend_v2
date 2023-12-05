package com.javatpoint.finalProject; 

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javatpoint.finalProject.controller.PlaylistController;
import com.javatpoint.finalProject.model.Playlist;
import com.javatpoint.finalProject.service.PlaylistService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PlaylistController.class)
public class PlaylistControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlaylistService playlistService;

    @Autowired
    private ObjectMapper objectMapper;

    private List<Playlist> playlistList;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        Playlist playlist1 = new Playlist();
        playlist1.setPlaylistId(1);
        playlist1.setPlaylistName("Chill Beats");

        Playlist playlist2 = new Playlist();
        playlist2.setPlaylistId(2);
        playlist2.setPlaylistName("Workout Hits");

        playlistList = Arrays.asList(playlist1, playlist2);
    }

    @Test
    public void getAllPlaylistsTest() throws Exception {
        when(playlistService.getAllPlaylists()).thenReturn(playlistList);

        mockMvc.perform(get("/playlist"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].playlistName", is("Chill Beats")))
                .andExpect(jsonPath("$[1].playlistName", is("Workout Hits")));
    }

    @Test
    public void getPlaylistTest() throws Exception {
        final int playlistId = 1;
        final Playlist playlist = new Playlist();
        playlist.setPlaylistId(playlistId);
        playlist.setPlaylistName("Chill Beats");

        when(playlistService.getPlaylistById(playlistId)).thenReturn(playlist);

        mockMvc.perform(get("/playlist/{playlistId}", playlistId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.playlistName", is("Chill Beats")))
                .andExpect(jsonPath("$.playlistId", is(playlistId)));
    }

    @Test
    public void deletePlaylistTest() throws Exception {
        final int playlistId = 1;
        doNothing().when(playlistService).delete(playlistId);

        mockMvc.perform(delete("/playlist/{playlistId}", playlistId))
                .andExpect(status().isOk());
    }

    @Test
    public void savePlaylistTest() throws Exception {
        final Playlist playlist = new Playlist();
        playlist.setPlaylistName("New Playlist");

        mockMvc.perform(post("/playlists")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(playlist)))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(Integer.toString(playlist.getPlaylistId()))));
    }

    @Test
    public void updatePlaylistTest() throws Exception {
        final Playlist existingPlaylist = new Playlist();
        existingPlaylist.setPlaylistId(1);
        existingPlaylist.setPlaylistName("Chill Beats");

        mockMvc.perform(put("/playlists")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(existingPlaylist)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.playlistId", is(existingPlaylist.getPlaylistId())))
                .andExpect(jsonPath("$.playlistName", is("Chill Beats")));
    }
}