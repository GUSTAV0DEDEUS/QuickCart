package padraomvc;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class PadraoMVC extends Application{
    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/padraomvc/xmls/MenuPrincipal.fxml"));
        Parent root = loader.load();
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();    
    }
    

    
    public static void main(String[] args) {
        Application.launch(PadraoMVC.class, args);
    }
    
    public static Stage getStage() {
        return stage;
    }
 
}

