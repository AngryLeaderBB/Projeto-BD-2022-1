/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetobd.entidades;

/**
 *
 * @author fogol
 */
public class Plano {
 
    private int valor, id;
    private String duracao;
    private float multa;

    public int getValor(){
	return valor;
    }

    public void setValor(int val){
	valor = val;
    }

    public int getId(){
	return id;
    }

    public void setId(int val){
	id = val;
    }

    public String getDuracao(){
	return duracao;
    }

    public void setDuracao(String val){
	duracao = val;
    }

    public float getMulta(){
	return multa;
    }

    public void setMulta(float val){
	multa = val;
    }
    
}
