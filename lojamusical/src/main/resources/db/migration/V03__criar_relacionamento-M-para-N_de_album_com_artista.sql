CREATE TABLE album_artista (
	album_id INT NOT NULL,
	artista_id INT NOT NULL,
	primary key (album_id, artista_id),
	INDEX fk_album_has_artista_artista1_idx (artista_id ASC),
  	INDEX fk_album_has_artista_album_idx (album_id ASC)
)

INSERT INTO album_artista (album_id, artista_id) VALUES ('3', '1');
INSERT INTO album_artista (album_id, artista_id) VALUES ('4', '3');
INSERT INTO album_artista (album_id, artista_id) VALUES ('4', '4');
INSERT INTO album_artista (album_id, artista_id) VALUES ('2', '2');