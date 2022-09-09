/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetobd.entidades;

/**
 *
 * @author fogol
 */
public class Fornecedor {
    
    private String cnpj, telefone, nome;
    
    public String getCnpj(){
	return cnpj;
    }

    public void setCnpj(String val){
	cnpj = val;
    }

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
    
}
