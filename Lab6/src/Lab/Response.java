package Lab;

import collection.Ticket;

import java.io.Serializable;
import java.util.LinkedHashSet;

public class Response implements Serializable {

    Response(LinkedHashSet<Ticket> tickets,String managerout){
        this.tickets = tickets;
        this.managerout = managerout;
        this.id = null;
    }

    Response(Integer id,String managerout){
        this.tickets = null;
        this.id = id;
        this.managerout = managerout;
    }

    public final LinkedHashSet<Ticket> tickets;
    private final String managerout;
    private final Integer id;

    public LinkedHashSet<Ticket> getTickets(){
        return tickets;
    }

    public String getManagerout(){
        return managerout;
    }

    public Integer getId() {
        return id;
    }
}
