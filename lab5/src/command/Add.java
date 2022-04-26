package command;

import collection.NullException;
import collection.Ticket;
import collection.ValueTooBigException;
import collection.ValueTooSmallException;

import java.io.IOException;

public class Add extends AbstractCommand {
    public Add(){
        this.name="Add";
        this.help="add a new element to collection";
    }

    @Override
    public void execute(CommandManager commandManager, String[] args, String Saver) throws IOException, ParaInapproException, NullException, ValueTooSmallException, ValueTooSmallException {
        if(args.length>1){
            throw new ParaInapproException("command add don't accept any parameter.\n");
        }else {
            commandManager.executeAdd(Ticket.Creat());
        }
    }
}
