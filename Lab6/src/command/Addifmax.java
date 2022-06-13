package command;

import Lab.CommandPackage;
import collection.NullException;
import collection.Ticket;
import collection.ValueTooSmallException;

import java.io.IOException;

public class Addifmax extends AbstractCommand {
        public Addifmax() {
            this.name = "Addifmax";
            this.help = "add a new element to the collection if its value is bigger than the biggest element in this collection";
        }

    public void execute(CommandManager commandManager, CommandPackage commandPackage) throws ParaInapproException {
        commandManager.executeAddifmax(commandPackage.getTicket(), commandManager);
    }
}

