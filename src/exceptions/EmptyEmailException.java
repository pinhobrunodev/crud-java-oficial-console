package exceptions;

public class EmptyEmailException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public EmptyEmailException(String msg) {
        super(msg);
    }
    
}
