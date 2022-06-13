package Lab;

import java.io.Serializable;
import java.util.LinkedHashSet;
import collection.Ticket;

import java.util.List;
import command.AbstractCommand;

public class CommandPackage implements Serializable {
    CommandPackage() {
        this.arg = null;
        this.abstractCommand = null;
        this.FileName = null;
        this.T = null;
        this.linkedHashSet = null;
        this.list = null;
        this.Set = false;
    }

    CommandPackage(String[] arg,AbstractCommand command,String FileName){
        this.FileName = FileName;
        this.T = null;
        this.arg = arg;
        this.abstractCommand = command;
        this.linkedHashSet = null;
        this.list = null;
        this.Set = false;
    }

    CommandPackage(AbstractCommand command,LinkedHashSet<Ticket> linkedHashSet,String FileName){
        this.FileName = FileName;
        this.T = null;
        this.arg = null;
        this.abstractCommand = command;
        this.linkedHashSet = linkedHashSet;
        this.list = null;
        this.Set = false;
    }

    CommandPackage(String[] S,AbstractCommand command , Ticket T ,String FileName){
        this.FileName = FileName;
        this.T = T;
        this.arg = S;
        this.abstractCommand = command;
        this.linkedHashSet = null;
        this.list = null;
        this.Set = false;
    }

    CommandPackage(AbstractCommand command, Ticket ticket, String FileName) {
        this.FileName = FileName;
        this.T = ticket;
        this.arg = null;
        this.abstractCommand = command;
        this.linkedHashSet = null;
        this.list = null;
        this.Set = false;
    }

    CommandPackage(String name,boolean Set){
        this.FileName = name;
        this.T = null;
        this.arg = null;
        this.abstractCommand = null;
        this.linkedHashSet = null;
        this.list = null;
        this.Set = Set;
    }

    CommandPackage(List<CommandPackage> list){
        this.FileName = null;
        this.T = null;
        this.arg = null;
        this.abstractCommand = null;
        this.linkedHashSet = null;
        this.list = list;
        this.Set = false;
    }

    private final AbstractCommand abstractCommand;
    private final String[] arg;
    private final Ticket T;
    private final LinkedHashSet<Ticket> linkedHashSet;
    private static final long serialVersionUID = 1L;
    private final String FileName;
    private final List<CommandPackage> list;
    private final boolean Set;


    public String getFileName(){
        return this.FileName;
    }

    public AbstractCommand getAbstractCommand() {
        return abstractCommand;
    }

    public String[] getArg(){
        return this.arg;
    }

    public LinkedHashSet<Ticket> getLinkedHashSet() {
        return linkedHashSet;
    }

    public Ticket getTicket() {
        return T;
    }

    public List<CommandPackage> getList() {
        return list;
    }

    public boolean isSet() {
        return Set;
    }

    public boolean connect(){
        if(FileName == null|abstractCommand == null| list == null){
            return true;
        }
        else {
            return false;
        }
    }


}
