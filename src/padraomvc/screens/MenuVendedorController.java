/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package padraomvc.screens;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import padraomvc.model.bean.Usuario;
import padraomvc.controller.ControllerUsuario;
import padraomvc.controller.ControllerVendedor;
import padraomvc.model.bean.Compra;
import padraomvc.model.bean.Produto;

public class MenuVendedorController implements Initializable {

    private Usuario user;

    @FXML
    private TextField usuEnt;

    @FXML
    private TextField passwordEnt;

    private final ControllerUsuario contUsu = new ControllerUsuario();

    @FXML
    private ComboBox<String> selectType;

    @FXML
    private TextField nameP;

    @FXML
    private TextField valueP;

    @FXML
    private TextField typeP;

    @FXML
    private ListView<String> productList;

    @FXML
    private ListView<String> salesList;

    @FXML
    private void changeUser(ActionEvent event) {
        String login = usuEnt.getText();
        String senha = passwordEnt.getText();
        String tipo = selectType.getValue();

        if (login.isEmpty() || senha.isEmpty() || tipo == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, preencha todos os campos.");
            alert.showAndWait();
            return;
        }

        try {
            Usuario usuario = new Usuario(login, senha, "ATIVO", tipo);
            contUsu.alterar(usuario);
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Sucesso");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Usuário alterado com sucesso.");
            successAlert.showAndWait();
        } catch (SQLException | ClassNotFoundException ex) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erro");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Erro ao alterar usuário: " + ex.getMessage());
            errorAlert.showAndWait();
        }
    }

    private void setHintText() {
        EntrarController previousScreen = new EntrarController();
        user = previousScreen.getUser();
        usuEnt.setPromptText(user.getLogin());
        passwordEnt.setPromptText(user.getSenha());
        selectType.setValue(user.getTipo());
    }

    @FXML
    private void createProduct(ActionEvent event) {
        String nomeProduto = nameP.getText();
        String valorProdutoStr = valueP.getText();
        String tipoProduto = typeP.getText();

        if (nomeProduto.isEmpty() || valorProdutoStr.isEmpty() || tipoProduto.isEmpty()) {
            mostrarAlertaErro("Por favor, preencha todos os campos.");
            return;
        }

        try {
            float valorProduto = Float.parseFloat(valorProdutoStr);
            Produto produto = new Produto(user.getId(), nomeProduto, valorProduto, tipoProduto);
            ControllerVendedor contPro = new ControllerVendedor();
            Produto proSaida = (Produto) contPro.inserir(produto);
            mostrarAlertaSucesso("Produto criado com sucesso: " + proSaida.toString());
            productList.getItems().clear();
            listarProdutos();
        } catch (NumberFormatException ex) {
            mostrarAlertaErro("Valor do produto inválido.");
        } catch (SQLException | ClassNotFoundException ex) {
            mostrarAlertaErro("Erro ao criar o produto: " + ex.getMessage());
        }
    }

    private void mostrarAlertaSucesso(String mensagem) {
        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
        successAlert.setTitle("Sucesso");
        successAlert.setHeaderText(null);
        successAlert.setContentText(mensagem);
        successAlert.showAndWait();
    }

    private void mostrarAlertaErro(String mensagem) {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("Erro");
        errorAlert.setHeaderText(null);
        errorAlert.setContentText(mensagem);
        errorAlert.showAndWait();
    }

    private void listarVendas() {
        try {
            ControllerVendedor contVen = new ControllerVendedor();
            List<Object> listaCompras = contVen.listarVendas(user);

            for (Object compraObject : listaCompras) {
                Compra compraSaida = (Compra) compraObject;
                salesList.getItems().add(compraSaida.toString());
            }
        } catch (SQLException | ClassNotFoundException ex) {
            mostrarAlertaErro("Erro ao listar as vendas: " + ex.getMessage());
        }
    }
    
    private void listarProdutos(){
         try {
            ControllerVendedor contVen = new ControllerVendedor();
            List<Object> products = contVen.listar(user);

            for (Object productObject : products) {
                Produto proSaida = (Produto) productObject;
                productList.getItems().add(proSaida.toString());
            }
        } catch (SQLException | ClassNotFoundException ex) {
            mostrarAlertaErro("Erro ao listar seus produtos: " + ex.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        selectType.getItems().addAll("vendedor", "comprador");
        setHintText();
        listarVendas();
        listarProdutos();
    }

}
