package command;

import collection.NullException;
import collection.ValueTooSmallException;

import java.io.IOException;

public class UpdateID extends AbstractCommand {
    public UpdateID(){
        this.name="UpdateID";
        this.help="update the value of the collection item whose id is equal to the given";
    }

    @Override
    public void execute(CommandManager commandManager, String[] args, String Saver) throws IOException, ParaInapproException, NullException,ValueTooSmallException {
        if(args.length>2||args.length==1){
            throw new ParaInapproException("this command only accepts one number parameter\n");
        }else {
            commandManager.executeUpdateID((args[1]));
        }
    }
}
