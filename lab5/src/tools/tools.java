package tools;

import java.util.*;
import collection.*;

public class tools {
    public static String Input(){
        return new Scanner(System.in).nextLine();
    }
    public static Boolean InputB(){
        return Boolean.valueOf(new Scanner(System.in).nextLine());
    }

    public static void Message(String message) {
        System.out.print(message);
    }

    public static void MessageL(String messageL) {
        System.out.println(messageL);
    }

    public void PrintTicketSet(LinkedHashSet<Ticket> linkedHashSet){
        Iterator<Ticket> iterator=linkedHashSet.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next().toString());
        }
    }
}
