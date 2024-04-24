/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package padraomvc.screens;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import padraomvc.PadraoMVC;
import padraomvc.controller.ControllerUsuario;
import padraomvc.model.bean.Usuario;

/**
 * FXML Controller class
 *
 * @author gustavo
 */
public class EntrarController {

    private static Usuario user;

    @FXML
    private TextField passEnt;

    @FXML
    private TextField usuEnt;

    @FXML
    private void login(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        FXMLLoader loader = null;
        user = validate();
        if (user != null) {
            System.out.println(user.getId());
            if("comprador".equals(user.getTipo())) {
                loader = new FXMLLoader(PadraoMVC.class.getResource("/padraomvc/xmls/MenuComprador.fxml"));
            }else {
                loader = new FXMLLoader(PadraoMVC.class.getResource("/padraomvc/xmls/MenuVendedor.fxml"));
            }
            Parent newScreen = loader.load();
            Stage stg = PadraoMVC.getStage();
            stg.setScene(new Scene(newScreen));
            stg.show();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Usuario ou senha incorretos");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, tente novamente.");
            alert.showAndWait();
        }
    }

    private Usuario validate() throws SQLException, ClassNotFoundException {
        Usuario usu = new Usuario(this.usuEnt.getText(), this.passEnt.getText());
        ControllerUsuario contUsu = new ControllerUsuario();
        return contUsu.persist(usu);
    }

    public Usuario getUser() {
        return user;
    }
    
    
}
