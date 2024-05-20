package ar.utn.ba.dds.easytech.models.entities.exceptions;

public class NoSePuedeEnviarException extends RuntimeException {

    public NoSePuedeEnviarException() {
    }

    public NoSePuedeEnviarException(String message) {
        super(message);
    }
}
