package command;

import collection.NullException;
import collection.ValueTooSmallException;

import java.io.IOException;

public class Help extends AbstractCommand{
    public Help(){
        this.name="Help";
        this.help="display help for available commands";
    }

    @Override
    public void execute(CommandManager commandManager, String[] args, String Saver) throws IOException, ParaInapproException, NullException, ValueTooSmallException, ValueTooSmallException {
        if(args.length>1){
            throw new ParaInapproException("this command don't accept any parameter\n");
        }else {
            commandManager.executeHelp();
        }
    }
}
