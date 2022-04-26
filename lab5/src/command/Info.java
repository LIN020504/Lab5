package command;

import collection.NullException;
import collection.ValueTooSmallException;

import java.io.IOException;

public  class Info extends AbstractCommand {
    public Info() {
        this.name = "Info";
        this.help = "print information about the collection (type, date of initialization, number of elements, etc.) to standard output";
    }

    @Override
    public void execute(CommandManager commandManager, String[] args, String Saver) throws IOException, ParaInapproException, NullException, ValueTooSmallException, ValueTooSmallException {
        if(args.length>1){
            throw new ParaInapproException("this command don't accept any parameter\n");
        }else {
            commandManager.executeInfo();
        }
    }
}