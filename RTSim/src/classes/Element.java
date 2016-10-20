package classes;
import global.Enumerators;

public class Element{
    // Properties
    protected final Enumerators elementType;
    protected int timer;
    
    // Constructors
    public Element(){
        this(Enumerators.ElementTypeUnknown);
    }
    
    public Element(Enumerators elementType){
        this.elementType = elementType;
        this.timer = 0;
    }
    
    // Methods
    public void passTime(int temp){
        this.timer += temp;
    }
    
    public String printSmall(){
        switch(this.elementType){
            case ElementTypeSign:
                return "(?)";
            case ElementTypeIntersection:
                return "XXX";
            case ElementTypeStreet:
                return "<?>";
            default:
                return "   ";
        }
    }
    
    // Getters and setters
    // TODO
    
}
