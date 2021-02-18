package exceptions;

public class RepeatedEmailException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;


    public RepeatedEmailException(String message){
        super(message);
    }
    
    
}
