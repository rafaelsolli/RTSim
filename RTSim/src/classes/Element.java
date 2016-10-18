package classes;
import enumerators.ElementType;

public class Element{
    // Properties
    private final ElementType type;
    protected final int locationX;
    protected final int locationY;
    
    // Constructors
    public Element(){
        this.type = ElementType.UnknownElement;
        this.locationX = 0;
        this.locationY = 0;
    }
    
    public Element(ElementType type, int locationX, int locationY){
        this.type = type;
        this.locationX = locationX;
        this.locationY = locationY;
    }
    
    // Methods
    public String ToString(){
        String temp;
        
        switch(this.type){
            case IntersectionElement:
                temp = "INT";
                break;
            case StreetElement:
                temp = "STR";
                break;
            case StopSignElement:
                temp = "STP";
                break;
            case TrafficLightElement:
                temp = "TRL";
                break;
            case ObstacleElement:
                temp = "OBS";
                break;
            default:
                temp = "???";
                break;
        }
        
        return temp + "(" + this.locationX + "," + this.locationY + ")";
    }
    
    public String FullToString(){
        String temp;
        
        switch(this.type){
            case IntersectionElement:
                temp = "Intersection";
                break;
            case StreetElement:
                temp = "Street";
                break;
            case StopSignElement:
                temp = "Stop sign";
                break;
            case TrafficLightElement:
                temp = "Traffic light";
                break;
            case ObstacleElement:
                temp = "Obstacle";
                break;
            default:
                temp = "Unknown";
                break;
        }
        
        return temp + " at (" + this.locationX + "," + this.locationY + ")";
    }
    
    // Getters and setters
    public ElementType getType(){
        return type;
    }

    public int getLocationX(){
        return locationX;
    }

    public int getLocationY(){
        return locationY;
    }
}
