package command;

import collection.NullException;
import collection.ValueTooSmallException;

import java.io.IOException;

public class Clear extends AbstractCommand {
    public Clear(){
        this.name="Clear";
        this.help="clear collections";
    }


    @Override
    public void execute(CommandManager commandManager, String[] args, String Saver) throws IOException, ParaInapproException, NullException, ValueTooSmallException, ValueTooSmallException {
        if(args.length>1){
            throw new ParaInapproException("this command don't accept any parameter\n");
        }else if(args.length==0){
            throw new NullException("please input the name of command");
        }else {
            commandManager.executeClear();
        }
    }
}
