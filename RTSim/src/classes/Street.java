package classes;
import global.Enumerators;

public final class Street extends Element{
    // Properties
    private final int index;
    private final int speed;
    private final int beginX;
    private final int beginY;
    private final int endX;
    private final int endY;
    private final Enumerators direction;
    
    // Constructors
    public Street(int index){
        this(index, 0, 0, 0, 0, 0);
    }
    
    public Street(int index, int speed, int beginX, int beginY, int endX, int endY){
        super(Enumerators.ElementTypeStreet);
        this.index = index;
        this.speed = speed;
        this.beginX = beginX;
        this.beginY = beginY;
        this.endX = endX;
        this.endY = endY;
        
        if((this.beginX == this.endX && this.beginY == this.endY) || (this.beginX != this.endX && this.beginY != this.endY)){
            this.direction = Enumerators.StreetDirectionUnknown;
        }
        else{
            if(this.beginX == this.endX){
                if(this.beginY < this.endY){
                    this.direction = Enumerators.StreetDirectionEast;
                }
                else{ //rua indo para o oeste
                    this.direction = Enumerators.StreetDirectionWest;
                }
            }
            else{ //rua vertical
                if(this.beginX < this.endX){
                    this.direction = Enumerators.StreetDirectionSouth;
                }
                else{
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
    
    // Getters and setters
    // TODO
    
}
