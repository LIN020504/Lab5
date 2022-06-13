package command;

import Lab.CommandPackage;
import collection.NullException;
import collection.ValueTooSmallException;

import java.io.IOException;
import java.sql.SQLException;

public class Save extends AbstractCommand {
    public Save(){
        this.name="Save";
        this.help="save collection to file";
    }



    @Override
    public void execute(CommandManager commandManager, CommandPackage commandPackage) throws IOException, ParaInapproException, NullException, ValueTooSmallException {
        commandManager.executeSave(commandPackage.getFileName());
    }
}
