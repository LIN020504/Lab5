package collection;

public enum TicketType {
    VIP, USUAL, BUDGETARY, CHEAP,NULL;

    public static String List(){
        String list = "";
        for(TicketType type:TicketType.values()){
            list = list + type.name()+"\n";
        }return list;
    }

    public static boolean findType(String string){
        for (TicketType type : TicketType.values()){
            if (type.toString().equals(string)){
                return true;
            }
        }
        return false;
    }
}
