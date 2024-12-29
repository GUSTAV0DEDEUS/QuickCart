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

