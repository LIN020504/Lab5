package command;

import collection.NullException;
import collection.Ticket;
import collection.ValueTooSmallException;

import java.io.IOException;

public class Addifmax extends AbstractCommand {
        public Addifmax() {
            this.name = "Addifmax";
            this.help = "add a new element to the collection if its value is bigger than the biggest element in this collection";
        }

    @Override
    public void execute(CommandManager commandManager, String[] args, String Saver) throws IOException, ParaInapproException, NullException, ValueTooSmallException, ValueTooSmallException {
        if(args.length>1){
            throw new ParaInapproException("this command don't accept any parameter\n");
        }else {
            commandManager.executeAddifmax(Ticket.Creat());
        }
    }
}

