CREATE TABLE UserDetail (
    userId INT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255) UNIQUE
);
-- -- Song Table
-- CREATE TABLE Songs (
--     songid INT PRIMARY KEY,
--     songname VARCHAR(255),
--     songartist VARCHAR(255),
--     songduration INT
-- );
-- -- Playlist Table
-- CREATE TABLE Playlist (
--     userId INT,
--     playlistId INT PRIMARY KEY,
--     playlistName VARCHAR(255),
--     playlistSize INT,
--     FOREIGN KEY (userid) REFERENCES UserDetail(userId)
-- );
-- -- Playlist_detail Table
-- CREATE TABLE Playlist_details (
--     userId INT,
--     playlistId INT,
--     songid INT,
--     PRIMARY KEY (userId, playlistId, songid),
--     FOREIGN KEY (userId) REFERENCES UserDetail(userId),
--     FOREIGN KEY (playlistId) REFERENCES Playlist(playlistId),
--     FOREIGN KEY (songid) REFERENCES Songs(songid)
-- );
