package collection;

import java.io.Serializable;

public class Coordinates implements Serializable {

        private Long x; //Максимальное значение поля: 404, Поле не может быть null
        private Long y;

        public Coordinates(){}

        public Coordinates(Long a,Long b)throws NullException, ValueTooBigException {
            setX(x);
            setY(y);
        }

        public void setX(Long x) throws NullException,ValueTooBigException{
            if(x >404){
                throw new ValueTooBigException("x can not bigger than 404"+"\n");
            }else if(x ==null){
                throw new NullException();
            }else{
                this.x = x;
            }
        }


        public void setY(Long y){
            this.y = y;
        }

        public Long getX(){
            return x;
        }

        public Long getY(){
            return y;
        }

        public String toString(){
            return "Coordinates {"+
                    "a="+ x +
                    ",b="+ y +"creationdate=" +
            '}';
        }
    }
