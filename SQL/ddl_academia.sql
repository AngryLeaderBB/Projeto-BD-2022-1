-- limpando banco
DROP DATABASE IF EXISTS academia;

-- criando banco
CREATE DATABASE academia;
USE academia;

-- inserindo tabelas

-- ##########################################################################
CREATE TABLE Gerente(
	Cpf VARCHAR(11) NOT NULL,
    Nome VARCHAR(50) NOT NULL,
    Salario DECIMAL(10,2) NOT NULL,
	Sexo CHAR(1) NOT NULL,
    Telefone VARCHAR(11) NOT NULL,
	Data_nascimento DATE NOT NULL
);

ALTER TABLE Gerente ADD CONSTRAINT PK_GERENTE PRIMARY KEY (Cpf);

-- ##########################################################################

CREATE TABLE Plano(
	Id INT NOT NULL,
    Multa DECIMAL(10,2) NOT NULL,
    Duracao INT NOT NULL,
	Valor DECIMAL(10,2) NOT NULL	
);

ALTER TABLE Plano ADD CONSTRAINT PK_PLANO PRIMARY KEY (Id);


-- ##########################################################################
CREATE TABLE Professor(
	Cref VARCHAR(10) NOT NULL,
    Especialidade VARCHAR(30) NOT NULL,
    Data_nascimento DATE NOT NULL,
	Nome VARCHAR(50) NOT NULL,
    Carga_Horaria INT NOT NULL,
    Salario DECIMAL(10,2)  NOT NULL,
	Sexo CHAR(1) NOT NULL,
    Telefone VARCHAR(11)  NOT NULL
);

ALTER TABLE Professor ADD CONSTRAINT PK_PROFESSOR PRIMARY KEY (Cref);

-- ##########################################################################


CREATE TABLE Fornecedor(
	Cnpj VARCHAR(20) NOT NULL,
	Nome_empresa VARCHAR(20) NOT NULL,
	Telefone VARCHAR(11) NOT NULL
);


ALTER TABLE Fornecedor ADD CONSTRAINT PK_FORNECEDOR PRIMARY KEY (Cnpj);



-- ##########################################################################

CREATE TABLE Aluno(
	Cpf VARCHAR(11) NOT NULL,
    Data_nascimento DATE NOT NULL,
	Nome VARCHAR(50) NOT NULL,
    Sexo CHAR(1) NOT NULL,
	Telefone VARCHAR(11) NOT NULL,
	Status CHAR(1) NOT NULL,
	FOTO BLOB
);


ALTER TABLE Aluno ADD CONSTRAINT PK_ALUNO PRIMARY KEY(Cpf);

-- ##########################################################################

CREATE TABLE Contrato(
	Numero INT NOT NULL,
	Data_inicio DATE NOT NULL,
    Aluno_cpf VARCHAR(11) NOT NULL,
	Gerente_cpf VARCHAR(11) NOT NULL,
	Plano_id INT NOT NULL
);


ALTER TABLE Contrato ADD CONSTRAINT PK_CONTRATO PRIMARY KEY (Numero);
ALTER TABLE Contrato ADD CONSTRAINT FK_CONTRATO_ALUNO FOREIGN KEY(Aluno_cpf) REFERENCES Aluno(cpf);
ALTER TABLE Contrato ADD CONSTRAINT FK_CONTRATO_GERENTE FOREIGN KEY (Gerente_cpf) REFERENCES Gerente(Cpf);
ALTER TABLE Contrato ADD CONSTRAINT FK_CONTRATO_PLANO FOREIGN KEY (Plano_id) REFERENCES Plano(Id);


-- ##########################################################################

CREATE TABLE Avaliacao_fisica(
	Data DATE NOT NULL,
	Biceps DECIMAL(10,2) NOT NULL,
    Panturrilha DECIMAL(10,2) NOT NULL,
	Torax DECIMAL(10,2) NOT NULL,
	Triceps DECIMAL(10,2) NOT NULL,
	Cintura DECIMAL(10,2) NOT NULL,
	Perna DECIMAL(10,2) NOT NULL,
	Imc DECIMAL(10,2) NOT NULL,
    Altura DECIMAL(10,2) NOT NULL,
    Peso DECIMAL(10,2) NOT NULL,
    Peso_magro DECIMAL(10,2) NOT NULL,
	Body_fat DECIMAL(10,2) NOT NULL,
	Professor_cref VARCHAR(10) NOT NULL,
    Aluno_cpf VARCHAR(11) NOT NULL
);


ALTER TABLE Avaliacao_fisica ADD CONSTRAINT PKs_AVALIACAO UNIQUE(Data,Professor_cref,Aluno_cpf);
ALTER TABLE Avaliacao_fisica ADD CONSTRAINT FK_AVALIACAO_PROFESSOR FOREIGN KEY(Professor_cref) REFERENCES Professor(cref);
ALTER TABLE Avaliacao_fisica ADD CONSTRAINT FK_AVALIACAO_ALUNO FOREIGN KEY(Aluno_cpf) REFERENCES Aluno(cpf);


-- ##########################################################################

CREATE TABLE Treino(
	Data DATE NOT NULL,
	Duracao INT NOT NULL,
	Professor_cref VARCHAR(10) NOT NULL,
	Aluno_cpf VARCHAR(11) NOT NULL
);
	
ALTER TABLE Treino ADD CONSTRAINT PKS_TREINO UNIQUE (Data,Professor_cref,Aluno_cpf);
ALTER TABLE Treino ADD CONSTRAINT FK_TREINO_PROFESSOR FOREIGN KEY(Professor_cref) REFERENCES Professor(cref);
ALTER TABLE Treino ADD CONSTRAINT FK_TREINO_ALUNO FOREIGN KEY(Aluno_cpf) REFERENCES Aluno(cpf);



-- ##########################################################################

CREATE TABLE Modelo_equipamento(
	Nome VARCHAR(30) NOT NULL
);

ALTER TABLE Modelo_equipamento ADD CONSTRAINT PK_MODELO PRIMARY KEY(Nome);

-- ##########################################################################

CREATE TABLE Exercicio(
	Id INT NOT NULL,
	Series INT NOT NULL,
	Repeticoes INT NOT NULL,
    Nome VARCHAR(50) NOT NULL,
    Modelo_equipamento_nome VARCHAR(30) NOT NULL,
    Treino_data DATE NOT NULL,
    Treino_professor_cref VARCHAR(10) NOT NULL,
    Treino_aluno_cpf VARCHAR(11) NOT NULL    
);

ALTER TABLE Exercicio ADD CONSTRAINT PK_EXERCICIO PRIMARY KEY(Id);
ALTER TABLE Exercicio ADD CONSTRAINT FK_EXERCICIO_MODELO FOREIGN KEY(Modelo_equipamento_nome) REFERENCES Modelo_equipamento(Nome);
ALTER TABLE Exercicio ADD CONSTRAINT FK_EXERCICIO_DATA FOREIGN KEY(Treino_data) REFERENCES Treino(Data);
ALTER TABLE Exercicio ADD CONSTRAINT FK_EXERCICIO_CREF FOREIGN KEY(Treino_professor_cref) REFERENCES Treino(Professor_cref);
ALTER TABLE Exercicio ADD CONSTRAINT FK_EXERCICIO_CPF FOREIGN KEY(Treino_aluno_cpf) REFERENCES Treino(Aluno_cpf);



-- ##########################################################################


CREATE TABLE Equipamento(
	Id INT NOT NULL,
	Marca VARCHAR(10) NOT NULL,
    Modelo_equipamento_nome VARCHAR(30) NOT NULL,
	Fornecedor_cnpj VARCHAR(20) NOT NULL
);

ALTER TABLE Equipamento ADD CONSTRAINT PK_EQUIPAMENTO PRIMARY KEY(Id);
ALTER TABLE Equipamento ADD CONSTRAINT FK_EQUIPAMENTO_FORNECEDOR FOREIGN KEY (Fornecedor_cnpj) REFERENCES Fornecedor(Cnpj);
ALTER TABLE Equipamento ADD CONSTRAINT FK_EQUIPAMENTO_MODELO FOREIGN KEY(Modelo_equipamento_nome) REFERENCES Modelo_equipamento(Nome);

-- ##########################################################################



-- mostrando tabelas

# DESC Gerente;
# DESC Plano;
# DESC Contrato;
# DESC Professor;
# DESC Fornecedor;
# DESC Equipamento;
# DESC Exercicio;
# DESC Aluno;
# DESC Avaliacao_fisica;
# DESC Treino;
# DESC Modelo_equipamento;