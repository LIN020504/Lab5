package command;

import Lab.CommandPackage;
import collection.*;

import java.io.IOException;

public class Add extends AbstractCommand {
    public Add() {
        this.name = "add";
        this.help = "add a new element to collection";
    }

    /**
     * when length of command line argument bigger than 1,throw ParaInapproException
     * {@link command.CommandManager#executeAdd(Ticket)}
     *
     * @param manager        CommandManager
     * @param commandPackage CommandPackage
     */
    public void execute(CommandManager manager, CommandPackage commandPackage) {
        Long a = commandPackage.getTicket().getId();
        Long b = Ticket.getId();
       Ticket ticket = commandPackage.getTicket();
        if(a<=b){
            long newcode = Ticket.getId()+1;
            ticket.resetid(newcode);
        }
        new collectionofTicket().getTickets().add(ticket);
        Ticket.setId(Ticket.getId());
        manager.setOut("You add ticket:\n" + ticket.toString() + "to collection\n", false);
    }
}