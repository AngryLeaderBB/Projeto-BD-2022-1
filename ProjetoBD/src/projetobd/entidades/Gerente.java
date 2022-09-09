/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetobd.entidades;

/**
 *
 * @author fogol
 */
public class Gerente extends Pessoa{
    
    private int idade;
    private float salario;
 
    public int getIdade(){
	return idade;
    }

    public void setIdade(int val){
	idade = val;
    }

    public float getSalario(){
	return salario;
    }

    public void setSalario(float val){
	salario = val;
    }

}
