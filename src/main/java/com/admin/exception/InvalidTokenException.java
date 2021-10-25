package com.admin.exception;

public class InvalidTokenException  extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param msg
     */
    public InvalidTokenException(String msg) {        
        super(msg);
    }
    
    /**
     * @param mensaje
     * @param exception
     */
    public InvalidTokenException(String mensaje, Throwable exception) {
        super(mensaje);
    }


}
