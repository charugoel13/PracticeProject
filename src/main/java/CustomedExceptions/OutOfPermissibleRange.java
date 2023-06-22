package CustomedExceptions;

/**
 * Custom exception
 */
public class OutOfPermissibleRange extends Exception{
    public OutOfPermissibleRange(String errorMessage){
        super(errorMessage);
    }
}
