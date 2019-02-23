package com.isagiongo.usuariodto.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.isagiongo.usuariodto.model.Usuario;
import com.isagiongo.usuariodto.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario insert(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public Optional<Usuario> find(Long id) {
		return usuarioRepository.findById(id);
	}

	public Optional<Usuario> find(String email) {
		return usuarioRepository.findByEmail(email);
	}

	public Iterable<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	public void delete(Long id) {
		find(id);
		try {
			usuarioRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultDataAccessException("Id não encontrado", 1);
		}
	}

}
