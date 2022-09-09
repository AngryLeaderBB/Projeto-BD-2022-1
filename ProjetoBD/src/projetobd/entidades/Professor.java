/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetobd.entidades;

/**
 *
 * @author fogol
 */
public class Professor extends Pessoa{
    
    //cref not varchar
    private String cref, endereco, rg, especialidade
            , cargaHoraria, dataNascimento; 
    private float salario;
    // faltam carga_horaria e data_nascimento
    
    public String getCref(){
	return cref;
    }

    public void setCref(String val){
	cref = val;
    }

    public String getEndereco(){
	return endereco;
    }

    public void setEndereco(String val){
	endereco = val;
    }

    public String getRg(){
	return rg;
    }

    public void setRg(String val){
	rg = val;
    }

    public String getEspecialidade(){
	return especialidade;
    }

    public void setEspecialidade(String val){
	especialidade = val;
    }

    public float getSalario(){
	return salario;
    }

    public void setSalario(float val){
	salario = val;
    }

    public String getCargahoraria(){
	return cargaHoraria;
    }

    public void setCargahoraria(String val){
	cargaHoraria = val;
    }

    public String getDatanascimento(){
	return dataNascimento;
    }

    public void setDatanascimento(String val){
	dataNascimento = val;
    }
    
}
