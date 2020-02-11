CREATE TABLE album_artista (
	album_id INTEGER NOT NULL references album(id),
	artista_id INTEGER NOT NULL references artista(id)
);

ALTER TABLE album_artista ADD CONSTRAINT "ID_PKEY" PRIMARY KEY (album_id,artista_id);

INSERT INTO album_artista (album_id, artista_id) VALUES ('3', '1');
INSERT INTO album_artista (album_id, artista_id) VALUES ('4', '3');
INSERT INTO album_artista (album_id, artista_id) VALUES ('4', '4');
INSERT INTO album_artista (album_id, artista_id) VALUES ('2', '2');