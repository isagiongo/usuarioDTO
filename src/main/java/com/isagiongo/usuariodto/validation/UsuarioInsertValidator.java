package com.isagiongo.usuariodto.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.isagiongo.usuariodto.dto.UsuarioDTO;
import com.isagiongo.usuariodto.exception.FieldMessage;
import com.isagiongo.usuariodto.model.Usuario;
import com.isagiongo.usuariodto.repository.UsuarioRepository;

public class UsuarioInsertValidator implements ConstraintValidator<UsuarioInsert, UsuarioDTO> {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void initialize(UsuarioInsert ann) {
	}

	public boolean isValid(UsuarioDTO usuarioDTO, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		Optional<Usuario> usuarioExiste = usuarioRepository.findByEmail(usuarioDTO.getEmail());
		if(usuarioExiste.isPresent()) {
			list.add(new FieldMessage("email", "Email já cadastrado."));
		}
		
		for (FieldMessage error : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(error.getMessage()).addPropertyNode(error.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
