create table Agenda_TABLE
(
    nome            varchar(255) not null,
    sobrenome       varchar(255) not null,
    data            varchar(255) not null,
    genero          varchar(255) not null,
    data_nascimento varchar(255) not null,
    endereco        varchar(255) not null,
    provincia       varchar(255) not null,
    atendido        varchar(120) not null,
    numeroId        varchar(25)  not null,
    id              int auto_increment
        primary key,
    telefone        varchar(25)  not null,
    experiencia     varchar(255) not null,
    email           varchar(255) not null,
    planoSaude      varchar(255) not null,
    constraint Agenda_TABLE_pk
        unique (email)
);

create table Consultas_TABLE
(
    nome      varchar(255) not null,
    sobrenome varchar(255) not null,
    email     varchar(255) null,
    peso      double       not null,
    idade     int          not null,
    metas     varchar(255) null,
    objetivos varchar(255) null,
    id        int auto_increment
        primary key,
    altura    double       not null,
    dataC     varchar(180) not null
);

create table Funcionario_TABLE
(
    nome_func  varchar(255) not null,
    senha_func varchar(255) not null,
    idade_func int          not null,
    email_func varchar(255) not null,
    id_func    int auto_increment
        primary key
);

create table Vacinacao_TABLE
(
    id                 int auto_increment
        primary key,
    nome_pac           varchar(255) not null,
    sobrenome_pac      varchar(255) not null,
    identificao_pac    varchar(255) not null,
    dataNascimento_pac varchar(180) not null,
    genero_pac         varchar(50)  not null,
    email_pac          varchar(225) not null,
    provincia_pac      varchar(255) not null,
    planoSaude_pac     varchar(225) null,
    numeroPlano_pac    varchar(120) null,
    endereco           varchar(180) not null,
    telefone_pac       varchar(15)  not null,
    constraint Vacinacao_TABLE_pk2
        unique (identificao_pac),
    constraint Vacinacao_TABLE_pk3
        unique (email_pac)
);


