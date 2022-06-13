package command;

import Lab.CommandPackage;
import collection.NullException;
import collection.ValueTooSmallException;

import java.io.IOException;

public class UpdateID extends AbstractCommand {
    public UpdateID(){
        this.name="UpdateID";
        this.help="update the value of the collection item whose id is equal to the given";
    }

    @Override
    public void execute(CommandManager commandManager, CommandPackage commandPackage) throws ParaInapproException, NumberFormatException {
        commandManager.executeUpdateID(commandPackage.getArg()[0], commandPackage.getTicket());
    }
}
