package command;

import Lab.CommandPackage;
import collection.NullException;
import collection.ValueTooSmallException;

import java.io.IOException;

public  class Info extends AbstractCommand {
    public Info() {
        this.name = "Info";
        this.help = "print information about the collection (type, date of initialization, number of elements, etc.) to standard output";
    }

    public void execute(CommandManager commandManager, CommandPackage commandPackage) throws ParaInapproException {
        commandManager.executeInfo();
    }
}