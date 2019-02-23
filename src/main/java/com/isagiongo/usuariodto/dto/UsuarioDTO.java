package com.isagiongo.usuariodto.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.isagiongo.usuariodto.model.Usuario;

import lombok.Getter;

@Getter
public class UsuarioDTO {

	@NotBlank(message = "{nome.not.blank}")
	private String nome;
	
	@NotBlank(message = "{email.not.blank}") @Email(message = "{email.not.valid}")
    private String email;
	
	@NotBlank(message = "{senha.not.blank}")
    private String senha;
    
	public Usuario transformaParaObjeto() {
    	return new Usuario(nome, email, senha);
    }
}
