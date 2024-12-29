# QuickCart

## Overview

QuickCart is a project designed to manage users, products, and purchases. The project is implemented in different branches using various technologies such as JSP, JavaFX, and Swing. The current branch contains the Swing implementation.

## Database Schema

The database schema for QuickCart is defined as follows:

```sql
create database ams20241;

create table ams20241.usuarios (
    id BIGINT NOT NULL AUTO_INCREMENT,
    login VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    status ENUM('ATIVO', 'INATIVO'),
    tipo ENUM('vendedor', 'comprador'),
    primary key (id)
);

create table ams20241.produtos(
    id BIGINT NOT NULL AUTO_INCREMENT,
    id_usuario BIGINT NOT NULL,
    nome_produto VARCHAR(255) NOT NULL,
    valor VARCHAR(255) NOT NULL,
    tipo_produto VARCHAR(255) NOT NULL,
    primary key (id),
    FOREIGN KEY (id_usuario) REFERENCES ams20241.usuarios(id)
);

create table ams20241.compras(
    id BIGINT NOT NULL AUTO_INCREMENT,
    id_usuario_comprador BIGINT NOT NULL,
    id_usuario_vendedor BIGINT NOT NULL,
    id_produto BIGINT NOT NULL,
    nome VARCHAR(255) NOT NULL,
    valor FLOAT NOT NULL,
    metodo_pagamento ENUM('boleto','pix')  NOT NULL,
    primary key (id),
    FOREIGN KEY (id_usuario_comprador) REFERENCES ams20241.usuarios(id),
    FOREIGN KEY (id_usuario_vendedor) REFERENCES ams20241.usuarios(id),
    FOREIGN KEY (id_produto) REFERENCES ams20241.produtos(id)
);

INSERT INTO `ams20241`.`usuarios` (`login`, `senha`, `status`, `tipo`) VALUES ('vender', '123', 'ATIVO', 'vendedor');
INSERT INTO `ams20241`.`usuarios` (`login`, `senha`, `status`, `tipo`) VALUES ('comprar', '123', 'ATIVO', 'comprador');
```

## Branches

- **JSP**: Contains the implementation using JavaServer Pages.
- **JavaFX**: Contains the implementation using JavaFX.
- **Swing**: Contains the current implementation using Swing.

## How to Run

1. Clone the repository.
2. Checkout to the desired branch.
3. Follow the instructions in the branch-specific README to set up and run the project.

---

# QuickCart

## Visão Geral

QuickCart é um projeto projetado para gerenciar usuários, produtos e compras. O projeto é implementado em diferentes branches usando várias tecnologias como JSP, JavaFX e Swing. A branch atual contém a implementação em Swing.

## Esquema do Banco de Dados

O esquema do banco de dados para o QuickCart é definido da seguinte forma:

```sql
create database ams20241;

create table ams20241.usuarios (
    id BIGINT NOT NULL AUTO_INCREMENT,
    login VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    status ENUM('ATIVO', 'INATIVO'),
    tipo ENUM('vendedor', 'comprador'),
    primary key (id)
);

create table ams20241.produtos(
    id BIGINT NOT NULL AUTO_INCREMENT,
    id_usuario BIGINT NOT NULL,
    nome_produto VARCHAR(255) NOT NULL,
    valor VARCHAR(255) NOT NULL,
    tipo_produto VARCHAR(255) NOT NULL,
    primary key (id),
    FOREIGN KEY (id_usuario) REFERENCES ams20241.usuarios(id)
);

create table ams20241.compras(
    id BIGINT NOT NULL AUTO_INCREMENT,
    id_usuario_comprador BIGINT NOT NULL,
    id_usuario_vendedor BIGINT NOT NULL,
    id_produto BIGINT NOT NULL,
    nome VARCHAR(255) NOT NULL,
    valor FLOAT NOT NULL,
    metodo_pagamento ENUM('boleto','pix')  NOT NULL,
    primary key (id),
    FOREIGN KEY (id_usuario_comprador) REFERENCES ams20241.usuarios(id),
    FOREIGN KEY (id_usuario_vendedor) REFERENCES ams20241.usuarios(id),
    FOREIGN KEY (id_produto) REFERENCES ams20241.produtos(id)
);

INSERT INTO `ams20241`.`usuarios` (`login`, `senha`, `status`, `tipo`) VALUES ('vender', '123', 'ATIVO', 'vendedor');
INSERT INTO `ams20241`.`usuarios` (`login`, `senha`, `status`, `tipo`) VALUES ('comprar', '123', 'ATIVO', 'comprador');
```

## Branches

- **JSP**: Contém a implementação usando JavaServer Pages.
- **JavaFX**: Contém a implementação usando JavaFX.
- **Swing**: Contém a implementação atual usando Swing.

## Como Executar

1. Clone o repositório.
2. Faça checkout para a branch desejada.
3. Siga as instruções no README específico da branch para configurar e executar o projeto.