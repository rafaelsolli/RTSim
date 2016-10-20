package classes;
import global.Enumerators;

public final class StopSign extends Sign{
    // Properties
    // TODO
    
    // Constructors
    public StopSign(){
        super(Enumerators.SignTypeStopSign);
    }
    
    // Methods
    @Override
    public String printSmall(){
        return "(S)";
    }
    
    // Getters and setters
    // TODO
    
}
