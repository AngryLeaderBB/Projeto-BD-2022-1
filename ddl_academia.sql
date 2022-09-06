-- limpando banco
DROP DATABASE IF EXISTS Academia;

-- criando banco
CREATE DATABASE Academia;
USE Academia;

-- inserindo tabelas

-- ##########################################################################
CREATE TABLE Gerente(
	Telefone INT NOT NULL,
	Nome VARCHAR(50) NOT NULL,
	Cpf VARCHAR(11) NOT NULL,
	Salario DECIMAL(10,2) NOT NULL,
	Sexo CHAR(1) NOT NULL,
	Idade INT NOT NULL
);

-- FLOAT -> DECIMAL
-- VARCHAR(20) -> VARCHAR(11)

ALTER TABLE Gerente ADD CONSTRAINT PK_GERENTE PRIMARY KEY (Cpf);

-- ##########################################################################

CREATE TABLE Plano(
	Id INT NOT NULL,
	Valor DECIMAL(10,2) NOT NULL,
	Multa DECIMAL(10,2) NOT NULL,
	Duracao INT NOT NULL
);

-- FLOAT de valor -> DECIMAL

ALTER TABLE Plano ADD CONSTRAINT PK_PLANO PRIMARY KEY (Id);


-- ##########################################################################
CREATE TABLE Professor(
	
	Nome VARCHAR(50) NOT NULL,
	Cref VARCHAR(10) NOT NULL,
	Cpf VARCHAR(11)  NOT NULL,
	Telefone VARCHAR(11)  NOT NULL,
	Salario DECIMAL(10,2)  NOT NULL,
	Endereco VARCHAR(45) NOT NULL,
	Sexo CHAR(1) NOT NULL,
	Rg INT NOT NULL,
	Especialidade VARCHAR(30) NOT NULL,
	Carga_Horaria INT NOT NULL,
	Data_nascimento DATE NOT NULL
);

-- FLOAT -> DECIMAL
-- TIME -> INT


ALTER TABLE Professor ADD CONSTRAINT PK_PROFESSOR PRIMARY KEY (Cref);

-- ##########################################################################


CREATE TABLE Fornecedor(
	Cnpj VARCHAR(20) NOT NULL,
	Nome_empresa VARCHAR(200) NOT NULL,
	Telefone VARCHAR(11) NOT NULL
);


ALTER TABLE Fornecedor ADD CONSTRAINT PK_FORNECEDOR PRIMARY KEY (Cnpj);



-- ##########################################################################

CREATE TABLE Aluno(
	Nome VARCHAR(50) NOT NULL,
	Telefone VARCHAR(11) NOT NULL,
	Matricula INT NOT null,
	Cpf CHAR(11) NOT NULL,
	Status VARCHAR(10) NOT NULL,
	Endereco VARCHAR(45) NOT NULL,
	Sexo CHAR(1) NOT NULL,
	Rg INT NOT NULL,
	PLANO_id INT NOT NULL,
	FOTO BINARY(23)
);


ALTER TABLE Aluno ADD CONSTRAINT PK_ALUNO PRIMARY KEY(Matricula);
ALTER TABLE Aluno ADD CONSTRAINT FK_ALUNO_PLANO FOREIGN KEY (Plano_id) REFERENCES Plano(Id);



-- ##########################################################################

CREATE TABLE Contrato(
	Numero INT NOT NULL,
	Data DATE NOT NULL,
	Gerente_cpf VARCHAR(11) NOT NULL,
	Plano_id INT NOT NULL
);


-- Já tem identificador, precisa de Plano_id como chave
-- Contrato não sabe quem é o aluno.

ALTER TABLE Contrato ADD CONSTRAINT PK_CONTRATO PRIMARY KEY (Numero);
ALTER TABLE Contrato ADD CONSTRAINT FK_CONTRATO_GERENTE FOREIGN KEY (Gerente_cpf) REFERENCES Gerente(Cpf);
ALTER TABLE Contrato ADD CONSTRAINT FK_CONTRATO_PLANO FOREIGN KEY (Plano_id) REFERENCES Plano(Id);


-- ##########################################################################

CREATE TABLE Avaliacao_fisica(
	Avaliacao_biceps DECIMAL(10,2) NOT NULL,
	Avaliacao_torax DECIMAL(10,2) NOT NULL,
	Avaliacao_triceps DECIMAL(10,2) NOT NULL,
	Avaliacao_cintura DECIMAL(10,2) NOT NULL,
	Avaliacao_perna DECIMAL(10,2) NOT NULL,
	Avaliacao_panturrilha DECIMAL(10,2) NOT NULL,
	Body_fat DECIMAL(10,2) NOT NULL,
	Peso DECIMAL(10,2) NOT NULL,
	Altura DECIMAL(10,2) NOT NULL,
	Imc DECIMAL(10,2) NOT NULL,
	Aluno_matricula INT NOT NULL,
	Professor_cref VARCHAR(10) NOT NULL
);


ALTER TABLE Avaliacao_fisica ADD CONSTRAINT PKS_AVALIACAO UNIQUE (Aluno_matricula,Professor_cref);
ALTER TABLE Avaliacao_fisica ADD CONSTRAINT FK_AVALIACAO_ALUNO FOREIGN KEY (Aluno_matricula) REFERENCES Aluno(Matricula);
ALTER TABLE Avaliacao_fisica ADD CONSTRAINT FK_AVALIACAO_PROFESSOR FOREIGN KEY (Professor_cref) REFERENCES Professor(Cref);


-- ##########################################################################

CREATE TABLE Treino(
	Duracao INT NOT NULL,
	Data_inicio DATE NOT NULL,
	Professor_cref VARCHAR(10) NOT NULL,
	Aluno_matricula INT NOT NULL
);




-- Trocado Datetime para Date
-- Data_inicio colocado como chave
ALTER TABLE Treino ADD CONSTRAINT PKS_TREINO UNIQUE (Data_inicio,Aluno_matricula,Professor_cref);
ALTER TABLE Treino ADD CONSTRAINT FK_TREINO_PROFESSOR FOREIGN KEY (Professor_cref) REFERENCES Professor(Cref);
ALTER TABLE Treino ADD CONSTRAINT FK_TREINO_ALUNO FOREIGN KEY (Aluno_matricula) REFERENCES Aluno(Matricula);



-- ##########################################################################


CREATE TABLE Exercicio(
	Id INT NOT NULL,
	Series INT NOT NULL,
	Repeticoes INT NOT NULL,
	Peso INT

);
-- incompleto, sem ligação com treino
-- peso considerado opcional

-- duvida:
-- tem id, precisa de treino?




ALTER TABLE Exercicio ADD CONSTRAINT PK_EXERCICIO PRIMARY KEY(Id);



-- ##########################################################################


CREATE TABLE Equipamento(
	Id INT NOT NULL,
	Marca VARCHAR(10) NOT NULL,
	Peso INT,
	Fornecedor_cnpj VARCHAR(20) NOT NULL	
);

ALTER TABLE Equipamento ADD CONSTRAINT PK_EQUIPAMENTO PRIMARY KEY(Id);
ALTER TABLE Equipamento ADD CONSTRAINT FK_EQUIPAMENTO_FORNECEDOR FOREIGN KEY (Fornecedor_cnpj) REFERENCES Fornecedor(Cnpj);

-- peso considerado opcional


-- ##########################################################################


CREATE TABLE Exercicio_equipamento(
	Exercicio_id INT NOT NULL,
	Equipamento_id INT NOT NULL
);


ALTER TABLE Exercicio_equipamento ADD CONSTRAINT PKS_EXERCICIO_EQUIPAMENTO UNIQUE (Exercicio_id,Equipamento_id);
ALTER TABLE Exercicio_equipamento ADD CONSTRAINT FK_EXERCICIO_EQUIPAMENTO_1 FOREIGN KEY (Exercicio_id) REFERENCES Exercicio(Id);
ALTER TABLE Exercicio_equipamento ADD CONSTRAINT FK_EXERCICIO_EQUIPAMENTO_2 FOREIGN KEY (Equipamento_id) REFERENCES Equipamento(Id);



-- mostrando tabelas

DESC Gerente;
DESC Plano;
DESC Contrato;
DESC Professor;
DESC Fornecedor;
DESC Equipamento;
DESC Exercicio;
DESC Exercicio_equipamento;
DESC Aluno;
DESC Avaliacao_fisica;
DESC Treino;