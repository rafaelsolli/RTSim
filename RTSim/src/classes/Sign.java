package classes;
import global.Enumerators;

public class Sign extends Element{
    // Properties
    protected final Enumerators signType;
    
    // Constructors
    public Sign(){
        this(Enumerators.SignTypeUnknown);
    }
    
    public Sign(Enumerators signType){
        super(Enumerators.ElementTypeSign);
        this.signType = signType;
    }
    
    // Methods
    @Override
    public String printSmall(){
        switch(this.signType){
            case SignTypeStopSign:
                return "(S)";
            case SignTypeTrafficLight:
                return "(T)";
            default:
                return "(?)";
        }
    }
    
    // Getters and setters
    // TODO
    
}
