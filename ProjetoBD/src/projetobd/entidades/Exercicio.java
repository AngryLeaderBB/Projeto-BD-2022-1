/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetobd.entidades;

/**
 *
 * @author fogol
 */
public class Exercicio {
    
    private int id, series, repeticoes, peso;
    private String treinoProf;
    
    public int getId(){
	return id;
    }

    public void setId(int val){
	id = val;
    }

    public int getSeries(){
	return series;
    }

    public void setSeries(int val){
	series = val;
    }

    public int getRepeticoes(){
	return repeticoes;
    }

    public void setRepeticoes(int val){
	repeticoes = val;
    }

    public int getPeso(){
	return peso;
    }

    public void setPeso(int val){
	peso = val;
    }

    public String getTreinoprof(){
	return treinoProf;
    }

    public void setTreinoprof(String val){
	treinoProf = val;
    }
    
}
