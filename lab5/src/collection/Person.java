package collection;



import java.time.LocalDate;

public class Person {
        private Long height;
        private String passportID;//自动填充
        private LocalDate creationDate = LocalDate.now();

    public Person(Long height,String passportID) throws NullException,ValueTooSmallException{
        setHeight(height);
        setPassport(passportID);
    }

    public Person(Coordinates coordinates, String information, Long height)throws NullException {
            setHeight(height);
        }

        public Person(String passportID)throws ValueTooBigException {
            setPassport(passportID);
        }

        public void setPassport(String passportID)throws ValueTooBigException{
            if(passportID.length()<5){
                throw new ValueTooBigException("Length can not less than 5"+"\n");
            }else{
                this.passportID=passportID;
            }
        }

        public void setHeight(Long height) throws NullException{
            if (height==null){
                throw new NullPointerException();
            }else{
                this.height=height;
            }
        }

        public Long getHeight() {
            return height;
        }

        public String getPassport(){
            return passportID;
        }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public String toString(){
            return "Person{"+"height="+height+'/'
                    +"passportID="+passportID+
                    "creationdata="+creationDate+"}";
        }
    }


