package CSV;

import collection.Coordinates;
import collection.Person;
import collection.Ticket;
import collection.TicketType;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.*;
import java.util.LinkedHashSet;

/**
 * read a csv file
*/
public class CSVReader {
    /**
     * read a csv file and write it to a linkedhashset
     * @param peoplelinkedhashset
     * @param path
     * @throws IOException
     */
    public void ReadFile(LinkedHashSet<Ticket> peoplelinkedhashset, String path) throws IOException{
        FileReader fileReader=new FileReader(path);
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        String first=bufferedReader.readLine();
        String s;
        while((s = bufferedReader.readLine())!=null) {
            String[] information = s.split(",");
            Coordinates coordinates = new Coordinates(Long.valueOf(information[4]),Long.valueOf(information[5]));
            Person person = new Person(coordinates, information[7], Long.valueOf(information[8]));
            Ticket t = new Ticket();
            Ticket.balaceicode();
            t.setType(TicketType.valueOf(information[3]));
            t.setName(information[1]);
            t.setPrice(Double.valueOf(information[2]));
            t.setRefundable(Boolean.valueOf(information[6]));
            t.changeId(Long.valueOf(information[0]));
            t.setCreationDate(LocalDate.parse(information[9]));
            peoplelinkedhashset.add(t);
        }
    }
}
