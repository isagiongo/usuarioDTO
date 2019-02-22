package com.isagiongo.usuariodto.dto;

import com.isagiongo.usuariodto.model.Usuario;

import lombok.Getter;

@Getter
public class UsuarioDTO {

	private String nome;
    private String email;
    private String senha;
    
	public Usuario transformaParaObjeto() {
    	return new Usuario(nome, email, senha);
    }
}
