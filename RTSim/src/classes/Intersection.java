package classes;
import global.Enumerators;

public final class Intersection extends Element{
    // Properties
    private final int index;
    private final int locationX;
    private final int locationY;
    
    // Constructors
    public Intersection(int index){
        this(index, 0, 0);
    }
    
    public Intersection(int index, int locationX, int locationY){
        super(Enumerators.ElementTypeIntersection);
        this.index = index;
        this.locationX = locationX;
        this.locationY = locationY;
    }
    
    // Methods
    @Override
    public String printSmall(){
        return "XXX";
    }
    
    // Getters and setters
    // TODO
    
}
