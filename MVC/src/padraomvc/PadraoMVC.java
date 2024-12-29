package padraomvc;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import padraomvc.model.bean.Usuario;
import padraomvc.view.ManterCompra;
import padraomvc.view.ManterProduto;
import padraomvc.view.ManterUsuario;

public class PadraoMVC {
    static Usuario user;
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        boolean sair = false;

        while (!sair) {
            int opcao = exibirMenuPrincipal();

            switch (opcao) {
                case 1 ->
                    cadastro();
                case 2 ->
                    entrar();
                case 0 ->
                    sair = true;
                default ->
                    JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        }
    }

    public static int exibirMenuPrincipal() {
        String msg = " 1 - Cadastrar \n 2 - Entrar \n 0 - Sair";
        return Integer.parseInt(JOptionPane.showInputDialog(msg));
    }

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
                case 0 -> {
                    int confirmarSair = JOptionPane.showConfirmDialog(null, "Deseja Sair?");
                    if (confirmarSair == JOptionPane.YES_OPTION) {
                        sair = true;
                    }
                }
                case 1 -> {
                    ManterUsuario mu = new ManterUsuario();
                    mu.menu();
                }
                case 2 -> {
                    ManterProduto mp = new ManterProduto();
                    mp.setVendedorEntrada(user);
                    mp.menu();
                }
                default ->
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
                case 0 -> {
                    int confirmarSair = JOptionPane.showConfirmDialog(null, "Deseja Sair?");
                    if (confirmarSair == JOptionPane.YES_OPTION) {
                        sair = true;
                    }
                }
                case 1 -> {
                    ManterUsuario mu = new ManterUsuario();
                    mu.menu();
                }
                case 2 -> {
                    ManterCompra mc = new ManterCompra();
                    mc.setCompradorEntrada(user);
                    mc.menu();
                }
                default ->
                    JOptionPane.showMessageDialog(null, "Opção inválida");
            }

        }
    }

}
