package org.uade.exceptions;

// Excepción para cuando no se encuentra algo que estás buscando.
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
