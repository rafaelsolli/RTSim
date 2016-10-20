package classes;
import global.Enumerators;
import static global.Constants.YellowLightTime;

public final class TrafficLight extends Sign{
    // Properties
    private final int greenLighTime;
    private final int yellowLighTime;
    private final int redLighTime;
    private Enumerators state;
    
    // Constructors
    public TrafficLight(){
        this(0, Enumerators.TrafficLightStateUnknown);
    }
    
    public TrafficLight(int greenLighTime, Enumerators state){
        super(Enumerators.SignTypeTrafficLight);
        this.greenLighTime = greenLighTime;
        this.yellowLighTime = YellowLightTime;
        this.redLighTime = this.greenLighTime + this.yellowLighTime;
        this.state = state;
    }
    
    // Methods
    private void checkState(){
        if(((this.state == Enumerators.TrafficLightStateGreen)  && (this.timer == this.greenLighTime))  ||
           ((this.state == Enumerators.TrafficLightStateYellow) && (this.timer == this.yellowLighTime)) ||
           ((this.state == Enumerators.TrafficLightStateRed)    && (this.timer == this.redLighTime))){
            switch(this.state){
                case TrafficLightStateGreen:
                    this.state = Enumerators.TrafficLightStateYellow;
                    break;
                case TrafficLightStateYellow:
                    this.state = Enumerators.TrafficLightStateRed;
                    break;
                case TrafficLightStateRed:
                    this.state = Enumerators.TrafficLightStateGreen;
                    break;
                default:
                    this.state = Enumerators.TrafficLightStateUnknown;
                    break;
            }
            this.timer = 0;
        }
    }
    
    @Override
    public void passTime(int temp){
        super.passTime(temp);
        this.checkState();
    }
    
    @Override
    public String printSmall(){
        switch(this.state){
            case TrafficLightStateGreen:
                return "(G)";
            case TrafficLightStateYellow:
                return "(Y)";
            case TrafficLightStateRed:
                return "(R)";
            default:
                return "(T)";
        }
    }
    
    // Getters and setters
    // TODO
    
}
