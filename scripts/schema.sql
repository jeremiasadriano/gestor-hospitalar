CREATE TABLE IF NOT EXISTS Agenda_TABLE(
    nome            VARCHAR(255) NOT NULL,
    sobrenome       VARCHAR(255) NOT NULL,
    `data`          VARCHAR(255) NOT NULL,
    genero          VARCHAR(255) NOT NULL,
    data_nascimento VARCHAR(255) NOT NULL,
    endereco        VARCHAR(255) NOT NULL,
    provincia       VARCHAR(255) NOT NULL,
    atendido        VARCHAR(120) NOT NULL,
    numeroId        VARCHAR(25)  NOT NULL,
    id              INT AUTO_INCREMENT,
    telefone        VARCHAR(25)  NOT NULL,
    experiencia     VARCHAR(255) NOT NULL,
    email           VARCHAR(255) NOT NULL,
    planoSaude      VARCHAR(255) NOT NULL,
    CONSTRAINT Agenda_TABLE_pk
        UNIQUE (email)
);

create TABLE Consultas_TABLE(
    nome      VARCHAR(255) NOT NULL,
    sobrenome VARCHAR(255) NOT NULL,
    email     VARCHAR(255) null,
    peso      double       NOT NULL,
    idade     INT          NOT NULL,
    metas     VARCHAR(255) null,
    objetivos VARCHAR(255) null,
    id        INT AUTO_INCREMENT,
    altura    double       NOT NULL,
    dataC     VARCHAR(180) NOT NULL
);

create TABLE Funcionario_TABLE(
    nome_func  VARCHAR(255) NOT NULL,
    senha_func VARCHAR(255) NOT NULL,
    idade_func INT          NOT NULL,
    email_func VARCHAR(255) NOT NULL,
    id_func    INT AUTO_INCREMENT 
);

create TABLE Vacinacao_TABLE(
    id                 INT AUTO_INCREMENT,
    nome_pac           VARCHAR(255) NOT NULL,
    sobrenome_pac      VARCHAR(255) NOT NULL,
    identificao_pac    VARCHAR(255) NOT NULL,
    dataNascimento_pac VARCHAR(180) NOT NULL,
    genero_pac         VARCHAR(50)  NOT NULL,
    email_pac          VARCHAR(225) NOT NULL,
    provincia_pac      VARCHAR(255) NOT NULL,
    planoSaude_pac     VARCHAR(225) null,
    numeroPlano_pac    VARCHAR(120) null,
    endereco           VARCHAR(180) NOT NULL,
    telefone_pac       VARCHAR(15)  NOT NULL,
    CONSTRAINT Vacinacao_TABLE_pk2
        UNIQUE (identificao_pac),
    CONSTRAINT Vacinacao_TABLE_pk3
        UNIQUE (email_pac)
);

ALTER TABLE Agenda_TABLE
ADD CONSTRAINT PK_AGENDA PRIMARY KEY (id);

ALTER TABLE Consultas_TABLE
ADD CONSTRAINT PK_CONSULTAS PRIMARY KEY (id);

ALTER TABLE Funcionario_TABLE
ADD CONSTRAINT PK_FUNC PRIMARY KEY (id);

ALTER TABLE Vacinacao_TABLE
ADD CONSTRAINT PK_VANC PRIMARY KEY (id);