package command;

import Lab.CommandPackage;
import collection.NullException;
import collection.ValueTooSmallException;
import java.io.IOException;

public abstract class AbstractCommand{
    protected String name;
    protected String help;

    public String getName(){
        return name;
    }

    public String getHelp(){
        return help;
    }

    abstract public void execute(CommandManager commandManager, CommandPackage commandPackage) throws IOException,ParaInapproException, NullException, ValueTooSmallException;
}

