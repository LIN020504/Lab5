package Lab;

import CSV.CSVReader;
import collection.*;
import command.History;
import command.ParaInapproException;
import tools.tools;
import command.CommandManager;
import command.AbstractCommand;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Lab {
    public static void main(String[] args) throws IOException {

        /*CommandManager commandManager = new CommandManager();

        Iterator<AbstractCommand> iterator;
        while (true) {
            AbstractCommand abstractCommand;
            iterator = commandManager.getCommands().iterator();
            boolean comExist = false;

            tools.MessageL("Program:Input your command:");
            String[] command = tools.Input().split(" ");
            try {
                while ((iterator.hasNext())){
                    abstractCommand = iterator.next();
                    if (abstractCommand.getName().equals(command [0])){
                        comExist = true;
                        try {
                            abstractCommand.execute(commandManager,command,"Ticket.csv");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        tools.Message("\n");
                    }
                }
                if ( ! comExist){
                    throw new NoSuchException("Error: Command [" +command[0] + "] not found!\n");
                }*/

    try{
        if((args.length!=1)){
            throw new ParaInapproException("this system only accept input of one file name\n");
        }
    }catch (ParaInapproException e){
        System.out.print(e.getMessage());
    }
    int idset = 0;
    CommandManager commandManager=new CommandManager();
        new collectionofTicket().doInitialization();
    File file=new File("Ticket.csv");
        if(!file.exists()){
        file.createNewFile();
    }else{
        LinkedHashSet<Ticket> linkedHashSet = new LinkedHashSet<>();
        new CSVReader().ReadFile(linkedHashSet, "Ticket.csv");
        Iterator<Ticket> iteratorP = linkedHashSet.iterator();
        Ticket P;
        while (iteratorP.hasNext()) {
            if (idset < (P = iteratorP.next()).getId()) {
                idset = Math.toIntExact(P.getId());
            }
        }
    }
    Ticket.idcode=idset;
        while(true) {
        boolean exist=false;//make sure command exists
        AbstractCommand abstractCommand;
        Iterator<AbstractCommand> iterator = commandManager.getCommands().iterator();
        System.out.print("input your command:\n");
        String[] command = tools.Input().split(" ");
        try {
            while (iterator.hasNext()) {
                if ((abstractCommand = iterator.next()).getName().equalsIgnoreCase(command[0])) {
                    abstractCommand.execute(commandManager, command,"Ticket.csv");
                    new History().getHistory().add(abstractCommand.getName()+"\n");
                    exist=true;//set true when command exists
                }
            }
            if(!exist){
                throw new NoSuchException("No such command, please enter another one\n");
            }
            } catch (NoSuchException noSuch){
                tools.MessageL(noSuch.getMessage());
            } catch (NullException Null){
                tools.MessageL(Null.getMessage());
            } catch (BooleanException BooleanE){
                tools.MessageL(BooleanE.getMessage());
            } catch (NotInitializationException Not){
                tools.MessageL(Not.getMessage());
            } catch (ValueTooSmallException ValueS){
                tools.MessageL(ValueS.getMessage());
            } catch (ValueTooBigException ValueB){
                tools.MessageL(ValueB.getMessage());
            } catch (ParaInapproException Para){
                tools.MessageL(Para.getMessage());
            }
        }

    }
}
