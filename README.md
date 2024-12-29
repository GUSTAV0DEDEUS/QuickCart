# How to Run the JSP Project

## English

### Prerequisites
1. **Java Development Kit (JDK)**: Ensure you have JDK installed.
2. **Apache Tomcat**: Install and configure Apache Tomcat.
3. **MySQL**: Install MySQL and create the necessary database and tables.

### Steps

1. **Clone the Repository**:
    ```sh
    git clone https://github.com/yourusername/QuickCart.git
    cd QuickCart
    ```

2. **Import the Database**:
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

3. **Configure the Project**:
    - Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse).
    - Configure the database connection in the `context.xml` file located in `web/META-INF`.

4. **Deploy the Project**:
    - Deploy the project to Apache Tomcat.

5. **Run the Project**:
    - Access the application via `http://localhost:8080/QuickCartWeb`.

---

## Português

### Pré-requisitos
1. **Java Development Kit (JDK)**: Certifique-se de ter o JDK instalado.
2. **Apache Tomcat**: Instale e configure o Apache Tomcat.
3. **MySQL**: Instale o MySQL e crie o banco de dados e tabelas necessários.

### Passos

1. **Clonar o Repositório**:
    ```sh
    git clone https://github.com/yourusername/QuickCart.git
    cd QuickCart
    ```

2. **Importar o Banco de Dados**:
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

3. **Configurar o Projeto**:
    - Abra o projeto na sua IDE preferida (por exemplo, IntelliJ IDEA, Eclipse).
    - Configure a conexão com o banco de dados no arquivo `context.xml` localizado em `web/META-INF`.

4. **Implantar o Projeto**:
    - Implemente o projeto no Apache Tomcat.

5. **Executar o Projeto**:
    - Acesse a aplicação via `http://localhost:8080/QuickCartWeb`.