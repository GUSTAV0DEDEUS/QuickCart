## How to Run JavaFX Implementation

1. **Download and Install Java 8**:
    - Go to the [Oracle JDK 8 download page](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html).
    - Download the appropriate installer for your operating system.
    - Follow the installation instructions provided on the website.

2. **Download and Install JavaFX**:
    - Go to the [Gluon JavaFX download page](https://gluonhq.com/products/javafx/).
    - Download the JavaFX SDK for your operating system.
    - Extract the downloaded file to a directory of your choice.
    - Set the `PATH_TO_FX` environment variable to the `lib` directory of the extracted JavaFX SDK.

3. Clone the repository:
    ```sh
    git clone https://github.com/yourusername/QuickCart.git
    ```
4. Checkout to the JavaFX branch:
    ```sh
    cd QuickCart
    git checkout javafx
    ```
5. Import the SQL script to your database:
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
6. Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse).
7. Ensure you have the necessary dependencies installed (e.g., Java Development Kit).
8. Run the main class `Main.java` to start the application.

## Como Executar a Implementação JavaFX

1. **Baixar e Instalar o Java 8**:
    - Acesse a [página de download do Oracle JDK 8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html).
    - Baixe o instalador apropriado para o seu sistema operacional.
    - Siga as instruções de instalação fornecidas no site.

2. **Baixar e Instalar o JavaFX**:
    - Acesse a [página de download do Gluon JavaFX](https://gluonhq.com/products/javafx/).
    - Baixe o SDK do JavaFX para o seu sistema operacional.
    - Extraia o arquivo baixado para um diretório de sua escolha.
    - Defina a variável de ambiente `PATH_TO_FX` para o diretório `lib` do SDK do JavaFX extraído.

3. Clone o repositório:
    ```sh
    git clone https://github.com/yourusername/QuickCart.git
    ```
4. Faça checkout para a branch JavaFX:
    ```sh
    cd QuickCart
    git checkout javafx
    ```
5. Importe o script SQL para o seu banco de dados:
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
6. Abra o projeto na sua IDE preferida (por exemplo, IntelliJ IDEA, Eclipse).
7. Certifique-se de que você tem as dependências necessárias instaladas (por exemplo, Java Development Kit).
8. Execute a classe principal `Main.java` para iniciar a aplicação.
