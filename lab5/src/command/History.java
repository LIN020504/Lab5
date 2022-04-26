package command;

import collection.NullException;
import collection.ValueTooSmallException;

import java.io.IOException;
import java.util.ArrayList;

public class History extends AbstractCommand {
    public History(){
        this.name="History";
        this.help="print the last 7 commands (without their arguments)";
    }

    public static ArrayList<String> history=new ArrayList<>();

    @Override
    public void execute(CommandManager commandManager, String[] args, String Saver) throws IOException, ParaInapproException, NullException, ValueTooSmallException, ValueTooSmallException {
            if(args.length>1){
                throw new ParaInapproException("this command don't accept any parameter\n");
            }else {
                commandManager.executeHistory();
            }
        }

        public ArrayList<String> getHistory(){
            return history;
    }
}
