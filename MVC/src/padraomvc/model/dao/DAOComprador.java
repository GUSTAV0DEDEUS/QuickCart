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

/**
 *
 * @author gusta
 */
public class DAOComprador {
    private final Connection c;
    
     public DAOComprador() throws SQLException, ClassNotFoundException {
        this.c = ConexaoDb.getConexaoMySQL();
    }
    // Comprar produto
    public Compra insert(Object obj, int idComprador, String metodo) throws SQLException{
        Produto produtoEnt = (Produto) obj;
        Compra compra = null;
        String sql = "insert into compras" + " (id_usuario_comprador, id_usuario_vendedor, id_produto, nome, valor, metodo_pagamento)" + " values (?,?,?,?,?,?)";

        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt(1, idComprador);
        stmt.setInt(2, produtoEnt.getIdV());        
        stmt.setInt(3, produtoEnt.getId());
        stmt.setString(4, produtoEnt.getNomeP());
        stmt.setFloat(5, produtoEnt.getValor());        
        stmt.setString(6, metodo);

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            compra = new Compra(
                    id,
                    idComprador, 
                    produtoEnt.getIdV(), 
                    produtoEnt.getId(), 
                    produtoEnt.getNomeP(), 
                    produtoEnt.getValor(),
                    metodo
            );
        }
        stmt.close();
        return compra;
    }
    // Listar Compras
    public List<Object> listarCompras(Object obj)  throws SQLException{
        Usuario usuEnt = (Usuario) obj;
        
        List<Object> compras = new ArrayList<>();
        String sql = "select * from compras where id_usuario_comprador = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setInt(1, usuEnt.getId());
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()){
            Compra compra;
            compra = new Compra(
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
    // Listar Produtos
    public List<Object> listar() throws SQLException {
        List<Object> produtos = new ArrayList<>();
        String sql = "select * from produtos";
        PreparedStatement stmt = this.c.prepareStatement(sql);        
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
}
