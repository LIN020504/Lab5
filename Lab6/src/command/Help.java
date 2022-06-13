package command;

import Lab.CommandPackage;
import collection.NullException;
import collection.ValueTooSmallException;

import java.io.IOException;
import java.io.Serializable;

public class Help extends AbstractCommand implements Serializable {
    public Help(){
        this.name="Help";
        this.help="display help for available commands";
    }
    /**
     * print helps of all commands.Don't accept any parameter
     * {@link CommandManager#executeHelp()}
     *
     * @param cm CommandManager
     * @throws ParaInapproException thrown by executeHelp
     */

    public void execute(CommandManager cm, CommandPackage commandPackage) throws ParaInapproException {
        cm.executeHelp();
    }
}
