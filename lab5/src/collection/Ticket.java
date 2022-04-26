package collection;

import java.time.LocalDate;
import java.util.Objects;


import tools.tools;

public class Ticket implements Comparable<Ticket> {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Double price; //Поле не может быть null, Значение поля должно быть больше 0
    private Boolean refundable; //Поле не может быть null
    private TicketType type; //Поле может быть null
    private Person person; //Поле не может быть null
    public static long idcode = 0;

    public Ticket() {

    }

    public static Ticket Creat() throws NullException,ValueTooBigException,ValueTooSmallException {
        Ticket ticket = new Ticket();

        tools.Message("Input name of Ticket:");
        String name = tools.Input();
        if(name.equals("")){
            name = null;
        }
        ticket.setName(name);

        Coordinates coordinates = new Coordinates();
        tools.Message("Input coordinate x(x<404): ");
        Long x;
        String sx = tools.Input();
        if(sx.equals("")){
            x = null;
        } else  {
            x = Long.valueOf(sx);
        }
        coordinates.setX(x);

        tools.Message("Input coordinates y :");
        Long y;
        String sy = tools.Input();
        if(sy.equals("")){
            y = null;
        } else {
            y = Long.valueOf(sy);
        }
        coordinates.setY(y);
        ticket.setCoordinates(coordinates);

        tools.Message("Input price a :");
        Double a;
        String sa = tools.Input();
        if(sa.equals("")){
            a = null;
        } else {
            a = Double.valueOf(sa);
        }
        ticket.setPrice(a);

        TicketType Type;
        tools.MessageL("Set the kinds of ticket:");
        tools.MessageL(TicketType.List());
        tools.Message(" Ticket type = ");
        String typeInput = tools.Input();
        if(typeInput.equals("")){
            throw new NullException(" Ticket type can not be null");
        } else {
            if(TicketType.findType(typeInput)){
                Type = TicketType.valueOf(typeInput);
            } else {
                throw new NoSuchException("Type [" + typeInput + "] not found\n");
            }
        }
        ticket.setType(Type);

        tools.Message(" Can it be returned or exchanged(please input true or false):");
        String refundable = tools.Input();
        switch (refundable) {
            case "true" : {
                ticket.setRefundable(true);
                break;
            }
            case "false" : {
                ticket.setRefundable(false);
                break;
            }
            default: {
                tools.MessageL("Error");
            }
        }

        tools.Message("The height of person:");
        String sHeight = tools.Input();
        Long height = Long.valueOf(sHeight);
        tools.Message("The passport id of person:");
        String passportId = tools.Input();
        Person person = new Person(height,passportId);
        ticket.setPerson(person);

        ticket.setCreationDate(LocalDate.now());
        ticket.id = setId();

        return ticket;
    }

    public static Long setId() {
        idcode = idcode + 1;
        return idcode;
    }
    public static void balaceicode(){
        idcode=idcode-1;
    }


    public void setType(TicketType type) throws NullException{
        if (type == null){
            throw new NullException("Type can not be null");
        } else {
            this.type = type;
        }
    }

    public void setPerson(Person person) {
        this.person = person;
    }


    public void setRefundable(Boolean refundable) throws NullException{
        if (refundable == null){
            throw new NullException("Refundable can not be null");
        } else {
            this.refundable = refundable;
        }
    }

    public void setPrice(Double price)throws ValueTooSmallException,NullException {
        if (price == 0) {
            throw new ValueTooSmallException("price can not be 0");
        } else if (price == null){
            throw new NullException("price can not be null");
        } else{
            this.price = price;
        }
    }

    public void setName(String name) throws NullException{
        if (name == null) {
            throw new NullException("Error: Name can not be empty!\n");
        } else {
            this.name = name;
        }
    }

    public void setCoordinates(Coordinates coordinates) throws NullException {
        if (coordinates == null) {
            throw new NullException("Error: Coordinates can't be empty!\n");
        } else {
            this.coordinates = coordinates;
        }
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }


    public String getName() {
        return name;
    }

    public Coordinates getCoordinates(){
        return coordinates;
    }

    public Double getPrice(){
        return price;
    }

    public void changeId(Long id) {
        this.id = id;
    }

    public TicketType getType(){
        return type;
    }

    public Long getId(){
        return id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }




    @Override
    public String toString() {
        return this.id   + "," + this.name + "," + this.price + "," + this.type + "," + coordinates.getX() + "," + coordinates.getY() + "," + this.refundable + "," + this.person.getPassport() + "," + this.person.getHeight() +"," + this.creationDate + "," +"\n";
    }

    public int compareTo(Ticket o) {
        if (o == null) {
            throw new NullPointerException("Null can't be compared");
        } else if (this.equals(o)) {
            return 0;
        } else if (this.hashCode() > o.hashCode()) {
            return 1;
        } else {
            return -1;
        }
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return person == ticket.person &&
                id == ticket.id &&
                name.equals(ticket.name) &&
                coordinates.equals(ticket.coordinates) &&
                creationDate.equals(ticket.creationDate) &&
                refundable.equals(ticket.refundable) &&
                Objects.equals(price, ticket.price) &&
                type.equals(ticket.type);
    }

    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, price, person, refundable, type);
    }
}