package command;

import collection.NullException;
import collection.ValueTooSmallException;

import java.io.IOException;

public class Save extends AbstractCommand {
    Save(){
        this.name="Save";
        this.help="save collection to file";
    }


    @Override
    public void execute(CommandManager commandManager, String[] args, String Saver) throws IOException, ParaInapproException, NullException, ValueTooSmallException, ValueTooSmallException {
        if(args.length>1){
            throw new ParaInapproException("this command don't accept parameter\n");
        }else {
            commandManager.executeSave(Saver);
        }
    }
}
