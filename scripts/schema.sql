CREATE TABLE IF NOT EXISTS Agenda_TABLE
(
    nome            VARCHAR(255) NOT NULL,
    sobrenome       VARCHAR(255) NOT NULL,
    `data`          VARCHAR(255) NOT NULL,
    genero          VARCHAR(255) NOT NULL,
    data_nascimento VARCHAR(255) NOT NULL,
    endereco        VARCHAR(255) NOT NULL,
    provincia       VARCHAR(255) NOT NULL,
    atendido        VARCHAR(120) NOT NULL,
    numeroId        VARCHAR(25)  NOT NULL,
    id              INT AUTO_INCREMENT PRIMARY KEY,
    telefone        VARCHAR(25)  NOT NULL,
    experiencia     VARCHAR(255) NOT NULL,
    email           VARCHAR(255) NOT NULL,
    planoSaude      VARCHAR(255) NOT NULL,
    CONSTRAINT Agenda_TABLE_pk
        UNIQUE (email)
);

CREATE TABLE IF NOT EXISTS Consultas_TABLE
(
    nome      VARCHAR(255) NOT NULL,
    sobrenome VARCHAR(255) NOT NULL,
    email     VARCHAR(255) NULL,
    peso      DOUBLE       NOT NULL,
    idade     INT          NOT NULL,
    metas     VARCHAR(255) NULL,
    objetivos VARCHAR(255) NULL,
    id        INT AUTO_INCREMENT PRIMARY KEY,
    altura    DOUBLE       NOT NULL,
    dataC     VARCHAR(180) NOT NULL
);

CREATE TABLE IF NOT EXISTS Funcionario_TABLE
(
    nome_func  VARCHAR(255) NOT NULL,
    senha_func VARCHAR(255) NOT NULL,
    idade_func INT          NOT NULL,
    email_func VARCHAR(255) NOT NULL,
    id_func    INT AUTO_INCREMENT PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS Vacinacao_TABLE
(
    id                 INT AUTO_INCREMENT PRIMARY KEY,
    nome_pac           VARCHAR(255) NOT NULL,
    sobrenome_pac      VARCHAR(255) NOT NULL,
    identificao_pac    VARCHAR(255) NOT NULL,
    dataNascimento_pac VARCHAR(180) NOT NULL,
    genero_pac         VARCHAR(50)  NOT NULL,
    email_pac          VARCHAR(225) NOT NULL,
    provincia_pac      VARCHAR(255) NOT NULL,
    planoSaude_pac     VARCHAR(225) NULL,
    numeroPlano_pac    VARCHAR(120) NULL,
    endereco           VARCHAR(180) NOT NULL,
    telefone_pac       VARCHAR(15)  NOT NULL,
    CONSTRAINT Vacinacao_TABLE_pk2
        UNIQUE (identificao_pac),
    CONSTRAINT Vacinacao_TABLE_pk3
        UNIQUE (email_pac)
);

INSERT INTO Funcionario_TABLE(nome_func, senha_func, idade_func, email_func) VALUE ('admin','admin',20,'admin@admin');