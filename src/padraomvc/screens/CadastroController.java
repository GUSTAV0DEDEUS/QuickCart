package padraomvc.screens;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import padraomvc.PadraoMVC;
import padraomvc.model.bean.Usuario;
import padraomvc.model.bean.Type;
import padraomvc.controller.ControllerUsuario;

public class CadastroController implements Initializable {

    private ObservableList<Type> obsTypes;
    private ControllerUsuario contUsu = new ControllerUsuario();

    @FXML
    private TextField usuEnt;

    @FXML
    private TextField passEnt;

    @FXML
    private ComboBox<Type> selectType;

    @FXML
    public void register(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        FXMLLoader loader = null;
        String login = usuEnt.getText();
        String senha = passEnt.getText();
        Type selectedType = selectType.getValue();

        if (login.isEmpty() || senha.isEmpty() || selectedType == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, preencha todos os campos.");
            alert.showAndWait();
            return;
        }

        String tipo = selectedType.getType();
        Object newUser = new Usuario(login, senha, "ATIVO", tipo);
        Object insertedUser = contUsu.inserir(newUser);
        
        if(insertedUser != null){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Usuario cadastrado");
            alert.setHeaderText(null);
            alert.setContentText("Usuario criado com sucesso");
            alert.showAndWait();
            
            loader = new FXMLLoader(PadraoMVC.class.getResource("/padraomvc/xmls/Entrar.fxml"));
            Parent newScreen = loader.load();
            Stage stg = PadraoMVC.getStage();
            stg.setScene(new Scene(newScreen));
            stg.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadingTypes();
    }

    private void loadingTypes() {
        ObservableList<Type> types = FXCollections.observableArrayList(
            new Type(1, "vendedor"),
            new Type(2, "comprador")
        );

        obsTypes = types;
        selectType.setItems(obsTypes);
    }
}
