package com.isagiongo.usuariodto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String senha;
	private String email;
	private Boolean admin = false;
	
	public Usuario(String nome, String email, String senha) {
	    this.nome = nome;
	    this.email = email;
	    this.senha = senha;
	}

}