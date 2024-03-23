CREATE TABLE IF NOT EXISTS Agenda_TABLE(
    id INT AUTO_INCREMENT,
    nome VARCHAR(255),
    sobrenome VARCHAR(255),
    telefone VARCHAR(255),
    data VARCHAR(255),
    data_nascimento VARCHAR(255),
    endereco VARCHAR(255),
    provincia VARCHAR(255),
    atendido VARCHAR(255),
    numeroId VARCHAR(255),
    experiencia VARCHAR(255),
    email VARCHAR(255),
    planoSaude VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS Consultas_TABLE(
    id INT AUTO_INCREMENT,
    nome VARCHAR(255),
    sobrenome VARCHAR(255),
    email VARCHAR(255),
    peso VARCHAR(255),
    idade VARCHAR(255),
    metas VARCHAR(255),
    objetivos VARCHAR(255),
    altura VARCHAR(255),
    dataC VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS Funcionario_TABLE(
    id INT AUTO_INCREMENT,
    nome_func VARCHAR(255),
    senha_func VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS Vacinacao_TABLE(
    id INT AUTO_INCREMENT,
    nome_pac VARCHAR(255),
    sobrenome_pac VARCHAR(255),
    identificao_pac VARCHAR(255),
    dataNascimento_pac VARCHAR(255),
    genero_pac VARCHAR(255),
    email_pac VARCHAR(255),
    provincia_pac VARCHAR(255),
    planoSaude_pac VARCHAR(255),
    numeroPlano_pac VARCHAR(255),
    endereco VARCHAR(255),
    telefone_pac VARCHAR(255)
    );

ALTER TABLE Agenda_TABLE
ADD CONSTRAINT PK_AGENDA PRIMARY KEY (id);

ALTER TABLE Consultas_TABLE
ADD CONSTRAINT PK_CONSULTAS PRIMARY KEY (id);

ALTER TABLE Funcionario_TABLE
ADD CONSTRAINT PK_FUNC PRIMARY KEY (id);

ALTER TABLE Vacinacao_TABLE
ADD CONSTRAINT PK_VANC PRIMARY KEY (id);