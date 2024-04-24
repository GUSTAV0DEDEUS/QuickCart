/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.model.bean;

import java.io.Serializable;

/**
 *
 * @author gusta
 */
public class Produto implements Serializable {

    public int id;
    public int idV;
    public String nomeP;
    public float valor;
    public String tipoP;

    public Produto(int id, int idV, String nomeP, float valor, String tipoP) {
        this.id = id;
        this.idV = idV;
        this.nomeP = nomeP;
        this.valor = valor;
        this.tipoP = tipoP;
    }
    
     public Produto(int idV, String nomeP, float valor, String tipoP) {
        this.idV = idV;
        this.nomeP = nomeP;
        this.valor = valor;
        this.tipoP = tipoP;
    }

    public Produto(int id) {
        this.id = id;
    }

    public Produto(String nomeP, float valor, String tipoP) {
        this.nomeP = nomeP;
        this.valor = valor;
        this.tipoP = tipoP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdV() {
        return idV;
    }

    public void setIdV(int idV) {
        this.idV = idV;
    }

    public String getNomeP() {
        return nomeP;
    }

    public void setNomeP(String nomeP) {
        this.nomeP = nomeP;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getTipoP() {
        return tipoP;
    }

    public void setTipoP(String tipoP) {
        this.tipoP = tipoP;
    }

    @Override
    public String toString() {
        return "id=" + id + ", Nome Produto=" + nomeP + ", Valor=" + valor + ", tipo=" + tipoP;
    }

}
