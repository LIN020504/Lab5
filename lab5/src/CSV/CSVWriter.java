package CSV;

import collection.Person;
import collection.Ticket;

import java.io.*;
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