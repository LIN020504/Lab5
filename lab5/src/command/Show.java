package command;

import collection.NullException;
import collection.ValueTooSmallException;

import java.io.IOException;

public class Show extends AbstractCommand {
    public Show(){
        this.name="Show";
        this.help="display all elements of the collection in string representation to standard output";
    }


    @Override
    public void execute(CommandManager commandManager, String[] args, String Saver) throws IOException, ParaInapproException, NullException, ValueTooSmallException, ValueTooSmallException {
        if(args.length>1){
            throw new ParaInapproException("this command don't accept any parameter\n");
        }else {
            commandManager.executeShow();
        }
    }
}
