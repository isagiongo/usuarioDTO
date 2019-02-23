package com.isagiongo.usuariodto.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorObject {

	private final String message;
    private final String field;
    private final Object parameter;
}
