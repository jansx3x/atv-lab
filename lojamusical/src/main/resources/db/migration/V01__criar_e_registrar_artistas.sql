CREATE TABLE artista (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
	nacionalidade VARCHAR(100) NOT NULL,
	momento_criacao DATE DEFAULT CURRENT_DATE
);

INSERT INTO artista (nome, nacionalidade) VALUES ('Anitta', 'Brasil');
INSERT INTO artista (nome, nacionalidade) VALUES ('XX:me', 'Japão');
INSERT INTO artista (nome, nacionalidade) VALUES ('Aimer', 'Japão');
INSERT INTO artista (nome, nacionalidade) VALUES ('SawanoHiroyuki[nZk]', 'Japão');