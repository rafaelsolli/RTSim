package classes;
import enumerators.ElementType;
import enumerators.StreetDirection;

public class Street extends Element{
    // Properties
    private final Intersection begin;
    private final Intersection end;
    private final int speed;
    private final StreetDirection direction;
    
    // Constructors
    public Street(){
        super(ElementType.StreetElement, 0, 0);
        this.begin = new Intersection();
        this.end = new Intersection();
        this.speed = 0;
        this.direction = StreetDirection.UnknownDirection;
    }
    
    public Street(Intersection begin, Intersection end, int speed){
        super(ElementType.StreetElement, begin.getLocationX(), begin.getLocationY());
        this.begin = begin;
        this.end = end;
        this.speed = speed;
        if(begin.getLocationX() == end.getLocationX()){
            if(begin.getLocationY() < end.getLocationY()){
                this.direction = StreetDirection.ToEastStreet;
            }
            else{
                this.direction = StreetDirection.ToWestStreet;
            }
        }
        else{
            if(begin.getLocationX() < end.getLocationX()){
                this.direction = StreetDirection.ToSouthStreet;
            }
            else{
                this.direction = StreetDirection.ToNorthStreet;
            }
        }
    }
    
    // Methods
    @Override
    public String ToString(){
        String temp;
        
        switch(this.direction){
            case ToNorthStreet:
                temp = "^ST";
                break;
            case ToEastStreet:
                temp = ">ST";
                break;
            case ToSouthStreet:
                temp = "vST";
                break;
            case ToWestStreet:
                temp = "<ST";
                break;
            default:
                temp = "<?>";
                break;
        }
        
        return temp + "(" + this.locationX + "," + this.locationY + ")";
    }
    
    @Override
    public String FullToString(){
        String temp;
        
        switch(this.direction){
            case ToNorthStreet:
                temp = "north";
                break;
            case ToEastStreet:
                temp = "east";
                break;
            case ToSouthStreet:
                temp = "south";
                break;
            case ToWestStreet:
                temp = "west";
                break;
            default:
                temp = "somewhere";
                break;
        }
        
        return "Street going " + temp + " to the intersection at (" + end.getLocationX() + "," + end.getLocationY() + "), with a length of " + this.getLength() + "km and a speed limit of " + this.speed + "km/h";
    }
    
    // Getters and setters
    public int getSpeed(){
        return speed;
    }

    public StreetDirection getDirection(){
        return direction;
    }
    
    public int getLength(){
        switch(this.direction){
            case ToNorthStreet:
                return begin.getLocationX() - end.getLocationX() - 1;
            case ToEastStreet:
                return end.getLocationY() - begin.getLocationY() - 1;
            case ToSouthStreet:
                return end.getLocationX() - begin.getLocationX() - 1;
            case ToWestStreet:
                return begin.getLocationY() - end.getLocationY() - 1;
            default:
                return 666;
        }
    }
}
