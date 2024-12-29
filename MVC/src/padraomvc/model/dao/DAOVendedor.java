/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import padraomvc.model.bean.Compra;
import padraomvc.model.bean.Produto;
import padraomvc.model.bean.Usuario;
import padraomvc.util.ConexaoDb;
import padraomvc.util.DaoBasico;

/**
 *
 * @author gusta
 */
public class DAOVendedor implements DaoBasico{

    private final Connection c;

    public DAOVendedor() throws SQLException, ClassNotFoundException {
        this.c = ConexaoDb.getConexaoMySQL();
    }
    // inserir Produto
    @Override
    public Object inserir(Object obj) throws SQLException {
        Produto proEnt = (Produto) obj;
        String sql = "insert into produtos" + " (id_usuario, nome_produto, valor, tipo_produto)" + " values (?,?,?,?)";

        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt(1, proEnt.getIdV());
        stmt.setString(2, proEnt.getNomeP());
        stmt.setFloat(3, proEnt.getValor());
        stmt.setString(4, proEnt.getTipoP());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            proEnt.setId(id);
        }
        stmt.close();
        System.out.println(proEnt);

        return proEnt;
    }
    // listar Produtos
    @Override
    public List<Object> listar(Object obj) throws SQLException {
        Usuario usuEnt = (Usuario) obj;
        
        List<Object> produtos = new ArrayList<>();
        String sql = "select * from produtos where id_usuario = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setInt(1, usuEnt.getId());
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()){
            Produto produto = new Produto(
                    rs.getInt(1), 
                    rs.getInt(2), 
                    rs.getString(3),
                    rs.getFloat(4), 
                    rs.getString(5)
            );
                
            produtos.add(produto);
        }
        rs.close();
        stmt.close();
        return produtos;
    }
    // listar vendas
    public List<Object> listarVendas(Object obj) throws SQLException{
        Usuario usuEnt = (Usuario) obj;
        
        List<Object> compras = new ArrayList<>();
        String sql = "select * from compras where id_usuario_vendedor = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setInt(1, usuEnt.getId());
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()){
            Compra compra = new Compra(
                    rs.getInt(1),
                    rs.getInt(2), 
                    rs.getInt(3), 
                    rs.getInt(4), 
                    rs.getString(5), 
                    rs.getFloat(6), 
                    rs.getString(7)
            );
            compras.add(compra);
        }
        rs.close();
        stmt.close();
        return compras;
    }
    
    // excluir produto
    @Override
    public Object excluir(Object obj) throws SQLException {
        Produto proEnt = (Produto) obj;
        String  sql = "delete from produtos where id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1,proEnt.getId());
        stmt.execute();
        stmt.close();
        c.close();
        return proEnt;
    }
    // alterar produto
    @Override
    public Object alterar(Object obj) throws SQLException {
        Produto proEnt = (Produto) obj;
        String sql = "UPDATE produtos SET nome_produto = ?, valor = ?, tipo_produto = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1, proEnt.getNomeP());
        stmt.setFloat(2, proEnt.getValor());
        stmt.setString(3, proEnt.getTipoP());        
        stmt.setInt(4, proEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return proEnt;
    }

    @Override
    public Object buscar(Object obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Object buscarProduto(int id) throws SQLException {
        String sql = "select * from produtos WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1, id);
        // executa
        ResultSet rs = stmt.executeQuery();
        Produto prodSaida = null;
        while (rs.next()) {
            // criando o objeto Usuario
            prodSaida = new  Produto(
                    rs.getInt(1), 
                    rs.getInt(2), 
                    rs.getString(3), 
                    rs.getFloat(4), 
                    rs.getString(5)
            );
                  
        }
        stmt.close();
        return prodSaida;
    }
    
}
