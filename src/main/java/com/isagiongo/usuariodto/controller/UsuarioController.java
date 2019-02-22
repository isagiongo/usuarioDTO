package com.isagiongo.usuariodto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isagiongo.usuariodto.dto.UsuarioDTO;
import com.isagiongo.usuariodto.dto.UsuarioRespostaDTO;
import com.isagiongo.usuariodto.model.Usuario;
import com.isagiongo.usuariodto.service.UsuarioService;


@RequestMapping("/usuarios")
@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	@PostMapping
	public ResponseEntity<UsuarioRespostaDTO> salvar(@RequestBody UsuarioDTO usuarioDTO){
		Usuario usuario = usuarioService.salvar(usuarioDTO.transformaParaObjeto());
		return new ResponseEntity<>(UsuarioRespostaDTO.transformaEmDTO(usuario), HttpStatus.CREATED);
	}
}
