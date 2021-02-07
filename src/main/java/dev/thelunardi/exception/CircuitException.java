package dev.thelunardi.exception;

public class CircuitException extends RuntimeException{
    public CircuitException(String errorMessage) {
        super(errorMessage);
    }
}
