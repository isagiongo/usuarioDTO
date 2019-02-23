package com.isagiongo.usuariodto.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public ResponseEntity<UsuarioRespostaDTO> insert(@RequestBody @Valid UsuarioDTO usuarioDTO) {
		Usuario usuario = usuarioService.insert(usuarioDTO.transformaParaObjeto());
		return new ResponseEntity<>(UsuarioRespostaDTO.transformaEmDTO(usuario), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<Iterable<Usuario>> findAll() {
		Iterable<Usuario> lista = usuarioService.findAll();
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping(value = "/busca-id/{id}")
	public ResponseEntity<Optional<Usuario>> find(@PathVariable Long id) {
		Optional<Usuario> obj = usuarioService.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "/busca-email/{email}")
	public ResponseEntity<Optional<Usuario>> find(@PathVariable String email) {
		Optional<Usuario> obj = usuarioService.find(email);
		return ResponseEntity.ok().body(obj);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> update(@RequestBody UsuarioDTO usuarioDTO, @PathVariable Long id) {
		Usuario userObj = usuarioDTO.transformaParaObjeto();
		userObj.setId(id);
		userObj = usuarioService.update(userObj);
		return ResponseEntity.ok().body(userObj);
	}

	@DeleteMapping(value = "/deleta-id/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		usuarioService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
