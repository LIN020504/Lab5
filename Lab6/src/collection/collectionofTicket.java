package collection;



import java.time.LocalDate;
import java.util.LinkedHashSet;

public class collectionofTicket {
    private static LocalDate InitializationTime;
    private static LinkedHashSet<Ticket> tickets;
    public static boolean Initialization=false;

    public static LinkedHashSet<Ticket> getTickets() throws NotInitializationException {
        if(!Initialization){
            throw new NotInitializationException("collections wasn't initialized\n");
        }else {
            return tickets;
        }
    }

    public void doInitialization(){
        if(!Initialization) {
            tickets = new LinkedHashSet<>();
            Initialization = true;
        }
    }
    public LocalDate getInitializationTime(){
        return InitializationTime;
    }

    public static void setTickets(LinkedHashSet<Ticket> newone) {
        tickets= newone;
    }
}
