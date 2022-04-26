package command;

import collection.NullException;
import collection.ValueTooSmallException;

import java.io.IOException;

public class Exit extends AbstractCommand {
    public Exit(){
        this.name="Exit";
        this.help="end the program(won't save)";
    }

    @Override
    public void execute(CommandManager commandManager, String[] args, String Saver) throws IOException, ParaInapproException, NullException, ValueTooSmallException, ValueTooSmallException {
        if(args.length>1){
            throw new ParaInapproException("this command don't accept any parameter\n");
        }else {
            commandManager.executeExit();
        }
    }
}
