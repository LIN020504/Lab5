package command;
import collection.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import tools.tools;
import CSV.CSVWriter;

public class CommandManager {
    public CommandManager(){
        commands.add(new Add());
        commands.add(new Addifmax());
        commands.add(new Clear());
        commands.add(new ExecuteScript());
        commands.add(new Exit());
        commands.add(new Help());
        commands.add(new History());
        commands.add(new Info());
        commands.add(new RemoveById());
        commands.add(new RemoveGreater());
        commands.add(new Save());
        commands.add(new Show());
        commands.add(new UpdateID());
    }

    private static LinkedHashSet<AbstractCommand> commands = new LinkedHashSet<>();
    private boolean findid=false;


    /**
     * get static LinkedHashSet<AbstrcteCommand> commands
     * @return LinkedHashSet
     */
    public LinkedHashSet<AbstractCommand> getCommands() {
        return commands;
}
    public void executeHelp(){
        Iterator<AbstractCommand> iterator = commands.iterator();
        while(iterator.hasNext()){
            AbstractCommand A = iterator.next();
            System.out.println(A.getName()+":"+A.getHelp()+"/n");
        }
    }

    public void executeAdd(Ticket tickets)throws NullException,ValueTooBigException,ValueTooSmallException{
        new collectionofTicket().doInitialization();
        new collectionofTicket().getTickets().add(tickets);
    }

    public static void executeAddifmax(Ticket t) {
        boolean judge=true;
        Iterator<Ticket> iterator=new collectionofTicket().getTickets().iterator();
        while(iterator.hasNext()){
            if(t.compareTo(iterator.next())>0){
                judge=false;
            }
        }
        if(judge==true){
            new collectionofTicket().getTickets().add(t);
        }
    }
    public void executeClear() {
        new collectionofTicket().getTickets().clear();
    }
    public void executeExit() {
        System.exit(2);
    }

    public void executeInfo() {
        if(!collectionofTicket.Initialization){
            throw new NotInitializationException("collections was initialized");
        }else {
            System.out.print("the date of initialization is "+new collectionofTicket().getInitializationTime()+"\n");
        }
        System.out.print("the amount of elements is "+ new collectionofTicket().getTickets().size()+"\n");
        System.out.print("the type of collection is "+ new collectionofTicket().getTickets().getClass() +"\n");
    }

    public void executeRemoveById(Long id) {
        Ticket t=findByid(id);
        if(findid==false){
            throw new ParaInapproException("no such a person with this id\n");
        }
        findid=false;
        new collectionofTicket().getTickets().remove(t);
    }

    private Ticket findByid(Long id){
        Ticket t =null;
        Ticket m;
        Iterator<Ticket> iterator=new collectionofTicket().getTickets().iterator();
        out:while(iterator.hasNext()){
            if((m = iterator.next()).getId().equals(id)){
                t=m;
                findid=true;
                break out;
            }
        }
        return t;
    }

    public void executeRemoveGreater(Long in) throws NullException{
        Ticket B=findByid(Long.valueOf(in));
        if(B==null){
            throw new NullException("No element is available");
        }else {
            Ticket t;
            Iterator<Ticket> iterator=new collectionofTicket().getTickets().iterator();
            while(iterator.hasNext()){
                if((t=iterator.next()).compareTo(B)==1){
                    new collectionofTicket().getTickets().remove(t);
                }
            }
        }
    }

    public void executeSave(String path) throws IOException {
        LinkedHashSet<Ticket> linkedHashSet=new collectionofTicket().getTickets();
        new CSVWriter().WriterToFile(linkedHashSet,path);
    }

    public void executeShow() {
        if(new collectionofTicket().getTickets().size()==0){
            System.out.print("collections of people still empty\n");
        }else{
            new tools().PrintTicketSet(new collectionofTicket().getTickets());
        }
    }

    public void executeUpdateID(String in) throws ParaInapproException{
        Long id = Long.valueOf(in);
        Ticket p;
        Iterator<Ticket> iterator=new collectionofTicket().getTickets().iterator();
        out:while(iterator.hasNext()){
            if(findByid(id)==null){
                throw new ParaInapproException("no such a id\n");
            }
            if((p=iterator.next()).getId().equals(id)){
                new collectionofTicket().getTickets().remove(p);
                Ticket insert=Ticket.Creat();
                insert.changeId(id);
                Ticket.balaceicode();
                new collectionofTicket().getTickets().add(insert);
                break out;
            }
        }
    }

        public void executeHistory() {
        int size=new History().getHistory().size();
        Iterator<String> iterator=new History().getHistory().iterator();
        if(new History().getHistory().size()<=7){
            while(iterator.hasNext()){
                System.out.print(iterator.next());
            }
        }else{
            while(size>7){
                iterator.next();
                size--;
            }
            while(iterator.hasNext()){
                System.out.print(iterator.next());
            }
        }
    }

    public void executeExecuteScript(String name,CommandManager commandManager,String Saver) throws IOException,ParaInapproException{
        FileReader f=new FileReader(new File(name));
        BufferedReader bufferedReader=new BufferedReader(f);
        String commandtext="";
        while((commandtext=bufferedReader.readLine())!=null){
            String []split=commandtext.split(" ");
            AbstractCommand command=findCommand(split[0]);
            if(command!=null&&!(command.getName().equals("ExecuteScript")&&split[1].equals(name))) {
                command.execute(commandManager, split,Saver);
                new History().getHistory().add(command.getName() + "\n");
            }
        }
        bufferedReader.close();
    }

    public AbstractCommand findCommand(String name){
        AbstractCommand A=null;
        AbstractCommand B;
        Iterator<AbstractCommand> iterator=commands.iterator();
        while(iterator.hasNext()){
            if((B=iterator.next()).getName().equalsIgnoreCase(name)) {
                A = B;
            }
        }
        return A;
    }
}
