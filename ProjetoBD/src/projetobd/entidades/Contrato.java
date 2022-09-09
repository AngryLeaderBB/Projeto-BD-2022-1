/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetobd.entidades;

/**
 *
 * @author fogol
 */
public class Contrato {
    
    private int numero, planoId;
    private String data, gerenteCpf;

    public int getNumero(){
	return numero;
    }

    public void setNumero(int val){
	numero = val;
    }

    public int getPlanoid(){
	return planoId;
    }

    public void setPlanoid(int val){
	planoId = val;
    }

    public String getData(){
	return data;
    }

    public void setData(String val){
	data = val;
    }

    public String getGerentecpf(){
	return gerenteCpf;
    }

    public void setGerentecpf(String val){
	gerenteCpf = val;
    }
    
}
