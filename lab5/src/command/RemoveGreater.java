package command;

import collection.NullException;
import collection.ValueTooSmallException;

import java.io.IOException;

public class RemoveGreater extends AbstractCommand {
    public RemoveGreater(){
        this.name="RemoveGreater";
        this.help="remove all elements greater than the specified one from the collection";
    }


    @Override
    public void execute(CommandManager commandManager, String[] args, String Saver) throws IOException, ParaInapproException, NullException, ValueTooSmallException, ValueTooSmallException {
        if(args.length>2){
            throw new ParaInapproException("this command only and must accept one number parameter\n");
        }else {
            commandManager.executeRemoveGreater(Long.valueOf(args[1]));
        }
    }
}
