/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import padraomvc.controller.ControllerVendedor;
import padraomvc.model.bean.Compra;
import padraomvc.model.bean.Produto;
import padraomvc.model.bean.Usuario;
import padraomvc.util.ViewBasico;

/**
 *
 * @author gusta
 */
public class ManterProduto implements ViewBasico {

    private Usuario vendedorEntrada;

    @Override
    public void menu() throws SQLException, ClassNotFoundException {
        String msg = " \n 1 - Cadastre seu Produto \n 2 - Alterar Seu Produto \n 3 - Listar seus Produtos \n 4 - Excluir Produto \n 5 - Listar Suas Vendas ";
        int num = Integer.parseInt(JOptionPane.showInputDialog(" " + vendedorEntrada.getLogin() + msg));
        System.out.println(vendedorEntrada);
        switch (num) {
            case 1 ->
                alterar();
            case 2 ->
                alterar();
            case 3 ->
                listar();
            case 4 ->
                excluir();
            case 5 ->
                listarVendas();
            default ->
                System.out.println("Opcao inválida");
        }
    }

    @Override
    public void inserir() throws SQLException, ClassNotFoundException {
        String nomeP = JOptionPane.showInputDialog("NOME DO PRODUTO");
        float valor = Float.parseFloat(JOptionPane.showInputDialog("VALOR DO PRODUTO"));
        String tipoP = JOptionPane.showInputDialog("TIPO DO PRODUTO");
        Produto produto = new Produto(vendedorEntrada.getId(), nomeP, valor, tipoP);
        ControllerVendedor contPro = new ControllerVendedor();
        Produto proSaida = (Produto) contPro.alterar(produto);
        JOptionPane.showMessageDialog(null, proSaida.toString());
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));

        String nomeP = JOptionPane.showInputDialog("NOME DO PRODUTO");
        float valor = Float.parseFloat(JOptionPane.showInputDialog("VALOR"));
        String tipoP = JOptionPane.showInputDialog("TIPO DO PRODUTO");
        Produto produto = new Produto(id,vendedorEntrada.getId(), nomeP, valor, tipoP);
        ControllerVendedor contPro = new ControllerVendedor();
        Produto proSaida = (Produto) contPro.alterar(produto);
        JOptionPane.showMessageDialog(null, proSaida.toString());
    }

    @Override
    public void excluir() throws SQLException, ClassNotFoundException {
        int idP = Integer.parseInt(JOptionPane.showInputDialog("ID DO PRODUTO"));
        Produto produto = new Produto(idP);
        ControllerVendedor contPro = new ControllerVendedor();
        Produto proSaida = (Produto) contPro.excluir(produto);
        JOptionPane.showMessageDialog(null, proSaida.toString());
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void listar() throws SQLException, ClassNotFoundException {
        ControllerVendedor contVen = new ControllerVendedor();
        List<Object> listaUsuario = contVen.listar(vendedorEntrada);
        for (Object proObj : listaUsuario) {
            Produto proSaida = (Produto) proObj;
            JOptionPane.showMessageDialog(null, proSaida.toString());
        }
    }

    public void listarVendas() throws SQLException, ClassNotFoundException {
        ControllerVendedor contVen = new ControllerVendedor();
        List<Object> listaCompras = (List<Object>) contVen.listarVendas(vendedorEntrada);
        for (Object compraObject : listaCompras) {
            Compra compraSaida = (Compra) compraObject;
            JOptionPane.showMessageDialog(null, compraSaida.toString());
        }
    }

    public void setVendedorEntrada(Usuario vendedorEntrada) {
        this.vendedorEntrada = vendedorEntrada;
    }

}
