package command;

import collection.NullException;
import collection.ValueTooSmallException;

import java.io.IOException;

public class RemoveById extends AbstractCommand {
    public RemoveById() {
        this.name = "RemoveById";
        this.help = "remove element from collection by its id";
    }

    @Override
    public void execute(CommandManager commandManager, String[] args, String Saver) throws IOException, ParaInapproException, NullException, ValueTooSmallException {
        if(args.length>2||args.length==1){
            throw new ParaInapproException("this command only and must accept one parameter\n");
        }else {
            if(Long.valueOf(args[1])<=0){
                throw new ParaInapproException("parameter should bigger than 0\n");
            }else {
                commandManager.executeRemoveById(Long.valueOf(args[1]));
            }
        }
    }
}
