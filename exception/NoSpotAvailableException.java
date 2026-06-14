package exception;

public class NoSpotAvailableException extends RuntimeException{

    public NoSpotAvailableException(){
        super("No Spot Available");
    }
}
