package command;

import Lab.CommandPackage;
import collection.NullException;
import collection.ValueTooSmallException;

import java.io.IOException;

public class RemoveGreater extends AbstractCommand {
    public RemoveGreater(){
        this.name="RemoveGreater";
        this.help="remove all elements greater than the specified one from the collection";
    }


    @Override
    public void execute(CommandManager commandManager, CommandPackage commandPackage) {
        commandManager.executeRemoveGreater(commandPackage.getTicket().getId());
    }
}
