/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetobd.entidades;

/**
 *
 * @author fogol
 */
public class Pessoa {

    private String telefone, nome, cpf;
    private char sexo;
    
    public String getTelefone(){
	return telefone;
    }

    public void setTelefone(String val){
	telefone = val;
    }

    public String getNome(){
	return nome;
    }

    public void setNome(String val){
	nome = val;
    }

    public String getCpf(){
	return cpf;
    }

    public void setCpf(String val){
	cpf = val;
    }

    public char getSexo(){
	return sexo;
    }

    public void setSexo(char val){
	sexo = val;
    }
    
}
