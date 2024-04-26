/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.SQLException;
import java.util.List;
import model.bean.Usuario;
import model.dao.DAOVendedor;
import util.ControllerBasico;

/**
 *
 * @author gusta
 */
public class ControllerVendedor implements ControllerBasico{
    DAOVendedor dao;
    
    @Override
    public Object inserir(Object obj) throws SQLException, ClassNotFoundException {
       dao = new DAOVendedor();
       return dao.inserir(obj);
    }

    @Override
    public Object alterar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DAOVendedor();
        return dao.alterar(obj);
    }

    @Override
    public Object excluir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DAOVendedor();
        return dao.excluir(obj);
    }
    

    @Override
    public List<Object> listar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DAOVendedor();
        return dao.listar(obj);
    }
    
        
    public List<Object> listarVendas(Usuario obj) throws SQLException, ClassNotFoundException {
        dao = new DAOVendedor();
        return dao.listarVendas(obj);
    }
    
    
    public Object buscarProduto(int id) throws SQLException, ClassNotFoundException {
        dao = new DAOVendedor();
        return dao.buscarProduto(id);            
    }

    @Override
    public Object buscar(Object obj) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
