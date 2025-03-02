package es.santander.ascender.ejerc006.service;

public class CrudSecurityException extends RuntimeException{
    private final CrudOperation operation;
    private final Long id;
    
    public CrudSecurityException(String message, CrudOperation operation, Long id) {
        super(message);
        this.operation = operation;
        this.id = id;
    }
    public CrudSecurityException(Throwable cause, CrudOperation operation, Long id) {
        super(cause);
        this.operation = operation;
        this.id = id;
    }
    public CrudSecurityException(String message, Throwable cause, CrudOperation operation, Long id) {
        super(message, cause);
        this.operation = operation;
        this.id = id;
    }
    public CrudOperation getOperation() {
        return operation;
    }
    public Long getId() {
        return id;
    }

}