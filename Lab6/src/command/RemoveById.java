package command;

import Lab.CommandPackage;
import collection.NullException;
import collection.Ticket;
import collection.ValueTooSmallException;
import collection.collectionofTicket;

import java.io.IOException;
import java.util.LinkedHashSet;

public class RemoveById extends AbstractCommand {
    public RemoveById() {
        this.name = "RemoveById";
        this.help = "remove element from collection by its id";
    }

    @Override
    public void execute(CommandManager manager, CommandPackage commandPackage) throws NullException {
        if (new collectionofTicket().getTickets().size() != 0) {
            LinkedHashSet<Ticket> newone = new LinkedHashSet<>();
            new collectionofTicket().getTickets().stream().filter(Tickts -> !Tickts.getId().equals(commandPackage.getTicket().getId())).forEach(newone::add);
            new collectionofTicket().setTickets(newone);
            manager.setOut("You removed:\n" + commandPackage.getTicket().toString(), false);
        } else {
            throw new NullException("Collection is empty\n");
        }
    }
}
