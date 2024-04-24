/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package padraomvc.screens;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import padraomvc.PadraoMVC;
import padraomvc.model.bean.Usuario;

/**
 * FXML Controller class
 *
 * @author gustavo
 */
public class MenuPrincipalController implements Initializable {

    static Usuario user;

    @FXML
    private TextField indexMenu;

    @FXML
    private void actionButton(ActionEvent event) {
        System.out.println("Voce clicoouu... " + indexMenu.getText());
        try{
            switchScene(Integer.parseInt(indexMenu.getText()));
        }catch(IOException e){
            System.out.println("Erro switchScene MenuPrincipal \n" + e);
        }
    }

    private void switchScene(int index) throws IOException {
        Parent newScreen;
        FXMLLoader loader = null;
        Stage stg;
        switch (index) {
            case 1:
                loader = new FXMLLoader(PadraoMVC.class.getResource("/padraomvc/xmls/Cadastro.fxml"));
                newScreen = loader.load();
                stg = PadraoMVC.getStage();
                stg.setScene(new Scene(newScreen));
                stg.show();
                break;
            case 2:
                loader = new FXMLLoader(PadraoMVC.class.getResource("/padraomvc/xmls/Entrar.fxml"));
                newScreen = loader.load();
                stg = PadraoMVC.getStage();
                stg.setScene(new Scene(newScreen));
                stg.show();
                break;
            case 0:
                System.exit(0);
            default:
                openAlert();
                break;
        }
        
        
    }

    private void openAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Opcao nao encontrada");
        alert.setContentText("Selecione uma opcao valida");
        alert.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}

/**
 public static void entrar() throws SQLException, ClassNotFoundException {
        user = ManterUsuario.persist();
        if (ManterUsuario.validar(user.getLogin(), user.getSenha())) {
           if("vendedor".equals(user.getTipo())){
               menuVendedor();
           }else{
               menuComprador();
           }
           
        } else {
            JOptionPane.showMessageDialog(null, "Usuário Inválido");
        }
    }

    public static void cadastro() throws SQLException, ClassNotFoundException {
        ManterUsuario mu = new ManterUsuario();
        mu.inserir();
    }

    public static void menuVendedor() throws SQLException, ClassNotFoundException {
        
        boolean sair = false;

        while (!sair) {
            String msg = " 0 - Sair \n 1 - Usuário \n 2 - Produto \n Salve vendedor";
            int opcao = Integer.parseInt(JOptionPane.showInputDialog(msg));

            switch (opcao) {
                case 0 : {
                    int confirmarSair = JOptionPane.showConfirmDialog(null, "Deseja Sair?");
                    if (confirmarSair == JOptionPane.YES_OPTION) {
                        sair = true;
                    }
                }
                case 1 : {
                    ManterUsuario mu = new ManterUsuario();
                    mu.menu();
                }
                case 2 : {
                    ManterProduto mp = new ManterProduto();
                    mp.setVendedorEntrada(user);
                    mp.menu();
                }
                default :
                    JOptionPane.showMessageDialog(null, "Opção inválida");
            }

        }
    }
    
    public static void menuComprador() throws SQLException, ClassNotFoundException {
        
        boolean sair = false;

        while (!sair) {
            String msg = " 0 - Sair \n 1 - Usuário \n 2 - Produto \n salve Comprador";
            int opcao = Integer.parseInt(JOptionPane.showInputDialog(msg));

            switch (opcao) {
                case 0 : {
                    int confirmarSair = JOptionPane.showConfirmDialog(null, "Deseja Sair?");
                    if (confirmarSair == JOptionPane.YES_OPTION) {
                        sair = true;
                    }
                }
                case 1 : {
                    ManterUsuario mu = new ManterUsuario();
                    mu.menu();
                }
                case 2 : {
                    ManterCompra mc = new ManterCompra();
                    mc.setCompradorEntrada(user);
                    mc.menu();
                }
                default :
                    JOptionPane.showMessageDialog(null, "Opção inválida");
            }

        }
    }
 */
