package command;

import Lab.CommandPackage;
import collection.NullException;
import collection.ValueTooSmallException;

import java.io.IOException;

public class Clear extends AbstractCommand {
    public Clear(){
        this.name="Clear";
        this.help="clear collections";
    }


    @Override
    public void execute(CommandManager commandManager, CommandPackage commandPackage) throws ParaInapproException {
        commandManager.executeClear();
    }
}

