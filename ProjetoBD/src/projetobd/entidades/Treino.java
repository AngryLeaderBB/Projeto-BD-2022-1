/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetobd.entidades;

/**
 *
 * @author fogol
 */
public class Treino {
    
    private int duracao, matriculaAluno;
    private String dataInicio, profCref;

    public int getDuracao(){
	return duracao;
    }

    public void setDuracao(int val){
	duracao = val;
    }

    public int getMatriculaaluno(){
	return matriculaAluno;
    }

    public void setMatriculaaluno(int val){
	matriculaAluno = val;
    }


    public String getDatainicio(){
	return dataInicio;
    }

    public void setDatainicio(String val){
	dataInicio = val;
    }

    public String getProfcref(){
	return profCref;
    }

    public void setProfcref(String val){
	profCref = val;
    }
    
}
