
insert into user_table
(alias, email, password, role) values 
('user', 'user@csumb.edu', '$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue','USER'),
('admin', 'admin@csumb.edu', '$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW' , 'ADMIN');


-- dummy data for Song table
INSERT INTO Songs (songid, songname, songartist, songduration) VALUES (1, 'Imagine', 'John Lennon', 187);
INSERT INTO Songs (songid, songname, songartist, songduration) VALUES (2, 'Bohemian Rhapsody', 'Queen', 355);

-- dummy data for Playlist table
INSERT INTO Playlist (userid, playlistid, playlistname, playlistsize) VALUES (1, 1, 'My Favorites', 2);

-- -- dummy data for Playlist_detail table
INSERT INTO Playlist_details (playlistid, songs_songid) VALUES (1, 1);
INSERT INTO Playlist_details (playlistid, songs_songid) VALUES (1, 2);
