/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.controller;

import java.sql.SQLException;
import java.util.List;
import padraomvc.model.bean.Compra;
import padraomvc.model.dao.DAOComprador;

/**
 *
 * @author gusta
 */
public class ControllerComprador {
    DAOComprador dao;
    public List<Object> listarCompras(Object comprador) throws SQLException, ClassNotFoundException {
        dao = new DAOComprador();
        return dao.listarCompras(comprador);
    }
    
    public Compra insert(Object obj, int idComprador, String metodo) throws SQLException, ClassNotFoundException {
        dao = new DAOComprador();
        return dao.insert(obj, idComprador, metodo);
    }
    
    public List<Object> listar() throws SQLException, ClassNotFoundException {
        dao = new DAOComprador();
        return dao.listar();
    }
    
}
