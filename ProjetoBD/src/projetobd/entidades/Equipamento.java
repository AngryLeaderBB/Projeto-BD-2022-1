/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetobd.entidades;

/**
 *
 * @author fogol
 */
public class Equipamento {
    
    private int id;
    private String marca, fornecedorCnpj;
    
    public int getId(){
	return id;
    }

    public void setId(int val){
	id = val;
    }

    public String getMarca(){
	return marca;
    }

    public void setMarca(String val){
	marca = val;
    }

    public String getFornecedorcnpj(){
	return fornecedorCnpj;
    }

    public void setFornecedorcnpj(String val){
	fornecedorCnpj = val;
    }
    
}
