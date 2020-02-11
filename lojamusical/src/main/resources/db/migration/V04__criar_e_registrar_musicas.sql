CREATE TABLE musica (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
	duracao INT NOT NULL,
	momento_criacao DATE DEFAULT CURRENT_DATE
);

INSERT INTO musica (nome, duracao) VALUES ('Unbelievers', 294);
INSERT INTO musica (nome, duracao) VALUES ('Torikago', 240);