package command;

import Lab.CommandPackage;
import collection.NullException;
import collection.ValueTooSmallException;

import java.io.IOException;

public class Exit extends AbstractCommand {
    public Exit(){
        this.name="Exit";
        this.help="end the program(won't save)";
    }

    @Override
    public void execute(CommandManager commandManager, CommandPackage commandPackage) throws ParaInapproException {
        commandManager.executeExit(commandPackage.getTicket(), commandManager);
    }
}
