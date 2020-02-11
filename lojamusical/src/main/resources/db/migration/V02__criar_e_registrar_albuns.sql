CREATE TABLE album (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
	ano INT NOT NULL,
	momento_criacao DATE DEFAULT CURRENT_DATE
);

INSERT INTO album (nome, ano) VALUES ('Penny Rain', 2019);
INSERT INTO album (nome, ano) VALUES ('DARLING in the FRANXX ENDING vol.2', 2018);
INSERT INTO album (nome, ano) VALUES ('Kisses', 2019);
INSERT INTO album (nome, ano) VALUES ('UnChild', 2014);