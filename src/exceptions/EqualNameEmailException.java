package exceptions;

public class EqualNameEmailException extends RuntimeException{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public EqualNameEmailException(String message){
        super(message);
    }
    
}
