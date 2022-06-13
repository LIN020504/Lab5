package command;

import Lab.CommandPackage;
import collection.NullException;
import collection.ValueTooSmallException;

import java.io.IOException;

public class ExecuteScript extends AbstractCommand {
    private int time=0;
    public ExecuteScript(){
        this.name="ExecuteScript";
        this.help=" read and execute a script from the specified file. The script contains commands in the same form in which the user enters them interactively.";
    }

    public void execute(CommandManager commandManager, CommandPackage commandPackage) {
        commandManager.executeScript(commandPackage.getArg());
    }
}
