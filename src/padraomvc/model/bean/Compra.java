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
public class Compra implements Serializable{
   private int id;
   private int idU;
   private int idV;
   private int idP;
   private String nomeP;
   private float valorP;
   private String metodoPagamento;

   public Compra(int id, int idU, int idV, int idP, String nomeP, float valorP, String metodoPagamento) {
        this.id = id;
        this.idU = idU;
        this.idV = idV;
        this.idP = idP;
        this.nomeP = nomeP;
        this.valorP = valorP;
        this.metodoPagamento = metodoPagamento;
   }
   
    public Compra(int id){
        this.id = id;
    }
    
    public Compra(int idP, String metodoPagamento){
        this.idP = idP;
        this.metodoPagamento = metodoPagamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }
    
    public int getIdV() {
        return idV;
    }

    public void setIdV(int idV) {
        this.idV = idV;
    }
    
    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }
    
    public String getNomeP() {
        return nomeP;
    }

    public void setNomeP(String nomeP) {
        this.nomeP = nomeP;
    }
   
    public float getValorP() {
        return valorP;
    }

    public void setValorP(float valorP) {
        this.valorP = valorP;
    }
    
    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }
      
    @Override
    public String toString() {
        return "Nome produto= " + nomeP + ", Valor= " + valorP + "," + "Metodo de Pagamento= " + metodoPagamento;
    }
    
}
