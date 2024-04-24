package padraomvc.screens;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import padraomvc.controller.ControllerComprador;
import padraomvc.model.bean.Usuario;
import padraomvc.controller.ControllerUsuario;
import padraomvc.controller.ControllerVendedor;
import padraomvc.model.bean.Compra;
import padraomvc.model.bean.Produto;

public class MenuCompradorController implements Initializable {

    private Usuario user;
    private final ControllerComprador contComp = new ControllerComprador();

    @FXML
    private TextField usuEnt;

    @FXML
    private TextField passwordEnt;

    private final ControllerUsuario contUsu = new ControllerUsuario();

    @FXML
    private ComboBox<String> selectType;

    @FXML
    private TextField idP;

    @FXML
    private ListView<String> productList;

    @FXML
    private ListView<String> shoppingList;

    private void mostrarAlertaErro(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    private void sucessAlert(Compra compra) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Compra concluida");
        alert.setHeaderText(compra.getNomeP() + ": " + compra.getValorP());
        alert.setContentText("Continue utilizando nosso servico");
        alert.showAndWait();
    }

    @FXML
    void shoppingProduct(ActionEvent event) {
        String inputId = idP.getText();
        if (inputId.isEmpty()) {
            mostrarAlertaErro("Por favor, insira o ID do produto.");
            return;
        }
        try {
            int idProduto = Integer.parseInt(inputId);
            ControllerVendedor contPro = new ControllerVendedor();
            Produto produto = (Produto) contPro.buscarProduto(idProduto);
            Compra compra = contComp.insert(produto, user.getId(), "pix");
            if (compra != null) {
                sucessAlert(compra);
                shoppingList.getItems().clear();
                listShopping();
            }
        } catch (NumberFormatException ex) {
            mostrarAlertaErro("ID do produto inválido.");
        } catch (SQLException | ClassNotFoundException ex) {
            mostrarAlertaErro("Erro ao buscar o produto: " + ex.getMessage());
        }
    }

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
        if (user != null) {
            usuEnt.setPromptText(user.getLogin());
            passwordEnt.setPromptText(user.getSenha());
            selectType.setValue(user.getTipo());
        }
    }

    private void listShopping() {
        try {
            List<Object> list = contComp.listarCompras(user);
            for (Object compraObject : list) {
                Compra compraSaida = (Compra) compraObject;
                shoppingList.getItems().add(compraSaida.toString());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuCompradorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MenuCompradorController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void listProduct() {
        List<Object> products;
        try {
            products = contComp.listar();
            for (Object proObj : products) {
                Produto proOut = (Produto) proObj;
                productList.getItems().add(proObj.toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuCompradorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuCompradorController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        selectType.getItems().addAll("vendedor", "comprador");
        setHintText();
        listShopping();
        listProduct();

    }

}
