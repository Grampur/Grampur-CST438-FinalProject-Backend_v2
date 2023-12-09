-- -- dummy data for User table
-- INSERT INTO UserDetail (userid, name, email) VALUES (1, 'John Doe', 'john.doe@example.com');
-- INSERT INTO UserDetail (userid, name, email) VALUES (2, 'Jane Smith', 'jane.smith@example.com');

-- dummy data for Song table
INSERT INTO Songs (songid, songname, songartist, songduration) VALUES (1, 'Imagine', 'John Lennon', 187);
INSERT INTO Songs (songid, songname, songartist, songduration) VALUES (2, 'Bohemian Rhapsody', 'Queen', 355);

-- dummy data for Playlist table
INSERT INTO Playlist (userid, playlistid, playlistname, playlistsize) VALUES (1, 1, 'My Favorites', 2);

-- -- dummy data for Playlist_detail table
INSERT INTO Playlist_details (playlistid, songs_songid) VALUES (1, 1);
INSERT INTO Playlist_details (playlistid, songs_songid) VALUES (1, 2);
