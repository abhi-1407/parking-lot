package exception;

public class InvalidTicketException extends RuntimeException{
    public InvalidTicketException(){
        super("Ticket is not valid");
    }
}
