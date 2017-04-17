create database sistemaPredial;
	use sistemaPredial;

CREATE table usuario(
	cpf varchar(15) NOT NULL,
    nome varchar(40),
    tipoFuncionario varchar(40),
    horario varchar(10),
    empresa varchar(30),
    senha varchar(20)
);



SELECT * FROM usuario;

