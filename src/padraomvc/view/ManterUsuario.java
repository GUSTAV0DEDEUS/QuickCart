/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import padraomvc.controller.ControllerUsuario;
import padraomvc.model.bean.Usuario;
import padraomvc.util.ViewBasico;

/**
 *
 * @author LAB 211
 */
public class ManterUsuario implements ViewBasico {

    @Override
    public void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - Alterar \n 2 - buscar \n 3- excluir \n 4 - Listar ";
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 1 ->
                alterar();
            case 2 ->
                buscar();
            case 3 ->
                excluir();
            case 4 ->
                listar();
            default ->
                System.out.println("Opcao inválida");
        }
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        Object[] tiposO = {"vendedor", "comprador"};
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String login = JOptionPane.showInputDialog("LOGIN");
        String status = "ATIVO";
        String senha = JOptionPane.showInputDialog("SENHA");
         String tipo = JOptionPane.showInputDialog(
  null,
            "Escolha usar uma conta de consumidor ou comercial.",
            "Opções", 
            JOptionPane.INFORMATION_MESSAGE, 
            null,
            tiposO, 
            tiposO[0]
        ).toString();
        Usuario usuEnt = new Usuario(id, login, senha, status, tipo);
        ControllerUsuario contUsu = new ControllerUsuario();
        Usuario usuSaida = (Usuario) contUsu.alterar(usuEnt);
        JOptionPane.showMessageDialog(null, usuSaida.toString());
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Usuario usuEnt = new Usuario(id);
        ControllerUsuario contUsu = new ControllerUsuario();
        Usuario usuSaida = (Usuario) contUsu.buscar(usuEnt);
        JOptionPane.showMessageDialog(null, usuSaida.toString());
    }

    @Override
    public void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Usuario usuEnt = new Usuario(id);
        ControllerUsuario contUsu = new ControllerUsuario();
        Usuario usuSaida = (Usuario) contUsu.excluir(usuEnt);
        JOptionPane.showMessageDialog(null, usuSaida.toString());
    }

    @Override
    public void listar() throws SQLException, ClassNotFoundException {
        String login = JOptionPane.showInputDialog("LOGIN");
        Usuario usuEnt = new Usuario(login);
        ControllerUsuario contUsu = new ControllerUsuario();
        List<Object> listaUsuario = contUsu.listar(usuEnt);
        for (Object usuObj : listaUsuario) {
            Usuario usuSaida = (Usuario) usuObj;
            JOptionPane.showMessageDialog(null, usuSaida.toString());
        }
    }

    @Override
    public void inserir() throws SQLException, ClassNotFoundException {
         Object[] tiposO = {"vendedor", "comprador"};

        String login = JOptionPane.showInputDialog("LOGIN");
        String senha = JOptionPane.showInputDialog("SENHA");
        String status = "ATIVO";
        String tipo = JOptionPane.showInputDialog(
  null,
            "Escolha usar uma conta de consumidor ou comercial.",
            "Opções", 
            JOptionPane.INFORMATION_MESSAGE, 
            null,
            tiposO, 
            tiposO[0]
        ).toString();

        Usuario usuEnt = new Usuario(login, senha, status, tipo);
        ControllerUsuario contUsu = new ControllerUsuario();
        Usuario usuSaida = (Usuario) contUsu.inserir(usuEnt);
        JOptionPane.showMessageDialog(null, usuSaida.toString());
    }
    
    public static Usuario persist() throws SQLException, ClassNotFoundException {
        String login = JOptionPane.showInputDialog("LOGIN");
        String senha = JOptionPane.showInputDialog("SENHA");
        Usuario usuEnt = new Usuario(login, senha);
        ControllerUsuario contUsu = new ControllerUsuario();
        return contUsu.persist(usuEnt);
    }
    
    public static boolean validar(String login, String senha) throws SQLException, ClassNotFoundException {
        Usuario usuEnt = new Usuario(login, senha);
        ControllerUsuario contUsu = new ControllerUsuario();
        return contUsu.validar(usuEnt);
    }

   

}
