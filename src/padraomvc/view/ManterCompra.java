/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import padraomvc.controller.ControllerComprador;
import padraomvc.controller.ControllerVendedor;
import padraomvc.model.bean.Compra;
import padraomvc.model.bean.Produto;
import padraomvc.model.bean.Usuario;


/**
 *
 * @author Aluno
 */
public class ManterCompra {
    private Usuario compradorEntrada;
    
    public void menu() throws SQLException, ClassNotFoundException {
 String msg = " \n 1 - Compre seu Produto \n 2 - Liste os Produtos \n 3 - Liste suas Compras";
        int num = Integer.parseInt(JOptionPane.showInputDialog(" " + compradorEntrada.getLogin() + msg));
        System.out.println(compradorEntrada);
        switch (num) {
            case 1 ->
                inserir();
            case 2 ->
                listar();
            case 3 ->
                listarCompras();
            default ->
                System.out.println("Opcao inválida");
        }    }

    
    public void inserir() throws SQLException, ClassNotFoundException {
        Produto produto;
        Object[] metodoO = {"boleto", "pix"};
        int idP = Integer.parseInt(JOptionPane.showInputDialog("ID do Produto"));  
        String metodo = JOptionPane.showInputDialog(
  null,
            "Escolha o metodo de pagamento.",
            "Opções", 
            JOptionPane.INFORMATION_MESSAGE, 
            null,
            metodoO, 
            metodoO[0]
        ).toString();
        ControllerVendedor contPro = new ControllerVendedor();
        produto = (Produto) contPro.buscarProduto(idP);
        ControllerComprador contComp = new ControllerComprador();
        Compra compraSaida = (Compra) contComp.insert(produto, compradorEntrada.getId(), metodo);
        JOptionPane.showMessageDialog(null, compraSaida.toString());
    }

    public void listar() throws SQLException, ClassNotFoundException {
        ControllerComprador contComp = new ControllerComprador();
        List<Object> listaProdutos = contComp.listar();
        
        for(Object proObj : listaProdutos)
        {
            Produto proSaida = (Produto) proObj;
            JOptionPane.showMessageDialog(null, proSaida.toString());
        }
                
    }
    
    public void listarCompras() throws SQLException, ClassNotFoundException {
        ControllerComprador contComprador = new ControllerComprador();
        List<Object> listaCompras = contComprador.listarCompras(compradorEntrada);
        for (Object compraObject : listaCompras) {
            Compra compraSaida = (Compra) compraObject;
            JOptionPane.showMessageDialog(null, compraSaida.toString());
        }
    }

    public void setCompradorEntrada(Usuario compradorEntrada) {
        this.compradorEntrada = compradorEntrada;
    }
    
}
