package classes;
import global.Enumerators;
import static global.Constants.LineBreak;

public final class Street extends Element{
    // Properties
    private final Sign sign;
    private final int index;
    private final int speed;
    private final int length;
    private final int beginX;
    private final int beginY;
    private final int endX;
    private final int endY;
    private final Enumerators direction;
    
    // Constructors
    public Street(int index){
        this(index, 0, 0, 0, 0, 0, new Sign());
    }
    
    public Street(int index, int speed, int beginX, int beginY, int endX, int endY, Sign sign){
        super(Enumerators.ElementTypeStreet);
        this.index = index;
        this.speed = speed;
        this.beginX = beginX;
        this.beginY = beginY;
        this.endX = endX;
        this.endY = endY;
        this.sign = sign;
        
        if((this.beginX == this.endX && this.beginY == this.endY) || (this.beginX != this.endX && this.beginY != this.endY)){
            this.length = 0;
            this.direction = Enumerators.StreetDirectionUnknown;
        }
        else{
            if(this.beginX == this.endX){
                if(this.beginY < this.endY){
                    this.length = this.endY - this.beginY - 1;
                    this.direction = Enumerators.StreetDirectionEast;
                }
                else{ //rua indo para o oeste
                    this.length = this.beginY - this.endY - 1;
                    this.direction = Enumerators.StreetDirectionWest;
                }
            }
            else{ //rua vertical
                if(this.beginX < this.endX){
                    this.length = this.endX - this.beginX - 1;
                    this.direction = Enumerators.StreetDirectionSouth;
                }
                else{
                    this.length = this.beginX - this.endX - 1;
                    this.direction = Enumerators.StreetDirectionNorth;
                }
            }
        }
    }
    
    // Methods
    @Override
    public String printSmall(){
        switch(this.direction){
            case StreetDirectionNorth:
                return "^^^";
            case StreetDirectionEast:
                return ">>>";
            case StreetDirectionSouth:
                return "vvv";
            case StreetDirectionWest:
                return "<<<";
            default:
                return "<?>";
        }
    }
    
    public String printMedium(){
        String temp1, temp2;
        switch(this.direction){
            case StreetDirectionNorth:
                temp1 = "north";
                break;
            case StreetDirectionEast:
                temp1 = "east";
                break;
            case StreetDirectionSouth:
                temp1 = "south";
                break;
            case StreetDirectionWest:
                temp1 = "west";
                break;
            default:
                temp1 = "somewhere";
                break;
        }
        switch(this.sign.getSignType()){
            case SignTypeStopSign:
                temp2 = "stop sign";
                break;
            case SignTypeTrafficLight:
                temp2 = "traffic light";
                break;
            default:
                temp2 = "nothing";
                break;
        }
        return "Street [" + this.index + "], with length " + this.length + ", going " + temp1 + " from (" + this.beginX + "," + this.beginY + ") to (" + this.endX + "," + this.endY + ") with a speed limit of " + this.speed + "km/h and " + temp2 + " at it's end" + LineBreak;
    }
    
    // Getters and setters
    public int getIndex(){
        return index;
    }
    public int getLength(){
        return length;
    }
    
    public Enumerators getDirection(){
        return direction;
    }
    
    public Sign getSign(){
        return sign;
    }
    
}
