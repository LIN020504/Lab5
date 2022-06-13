package CSV;

import collection.Person;
import collection.Ticket;
import tools.tools;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * write in format csv
 */
public class CSVWriter {

    /**
     *
     * @param linkedHashSet
     * @param path
     * @throws IOException
     */
    public void WriterToFile(LinkedHashSet<Ticket> linkedHashSet, String path) throws IOException{
        File file=new File(path);
        if (!file.exists()) {
            file.createNewFile();
        } else{
            tools.Message("Program: File Already exist, Would you like to replace it? Y/N:");
            switch (tools.Input()){
                case "Y" :{
                    file.delete();
                    file.createNewFile();
                    break;
                }
                case "N" :{
                    throw new FileAlreadyExistsException("Program: command return because file exist");
                }
                default: {
                    tools.MessageL("Program: command return because input error!");
                    break;
                }
            }
        }
        String firstline="";
        BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
        String addfirstline="id,name,price,type,passport,height,creationdate\n";
        BufferedOutputStream BOS=new BufferedOutputStream(new FileOutputStream(file,true));
        firstline=bufferedReader.readLine();
        if(firstline==null||!(firstline.equals("id,name,price,type,passport,height,creationdate\n"))){
            BOS.write(addfirstline.getBytes());
        }
        Iterator<Ticket> iterator=linkedHashSet.iterator();
        while (iterator.hasNext()){
            BOS.write(iterator.next().toString().getBytes());
        }
        bufferedReader.close();
        BOS.close();
    }
}