/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetobd.entidades;

/**
 *
 * @author fogol
 */
public class Aluno extends Pessoa{
    
    private String status, endereco;
    private int matricula, rg, planoId;
    
    
    public String getStatus(){
	return status;
    }

    public void setStatus(String val){
	status = val;
    }

    public String getEndereco(){
	return endereco;
    }

    public void setEndereco(String val){
	endereco = val;
    }

    public int getMatricula(){
	return matricula;
    }

    public void setMatricula(int val){
	matricula = val;
    }

    public int getRg(){
	return rg;
    }

    public void setRg(int val){
	rg = val;
    }
    
    public int getPlanoId(){
	return planoId;
    }

    public void setPlanoId(int val){
	planoId = val;
    }
    
}
