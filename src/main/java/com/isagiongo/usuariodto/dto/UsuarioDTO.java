package com.isagiongo.usuariodto.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.websocket.ClientEndpoint;

import com.isagiongo.usuariodto.model.Usuario;
import com.isagiongo.usuariodto.validation.UsuarioInsert;

import lombok.Getter;

@Getter
@UsuarioInsert
public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

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
