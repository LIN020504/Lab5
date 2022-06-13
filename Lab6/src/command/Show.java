package command;

import Lab.CommandPackage;
import collection.NullException;
import collection.ValueTooSmallException;

import java.io.IOException;

public class Show extends AbstractCommand {
    public Show(){
        this.name="Show";
        this.help="display all elements of the collection in string representation to standard output";
    }


    @Override
    public void execute(CommandManager commandManager, CommandPackage commandPackage) throws ParaInapproException, NullException {
        commandManager.executeShow();
    }
}
