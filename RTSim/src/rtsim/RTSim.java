package rtsim;
import classes.Map;
import classes.TrafficLight;
import global.Enumerators;
import static global.Util.printString;

public class RTSim{        
    public static void main(String[] args) throws InterruptedException{
        Map oMap = new Map(10, 10, 4, 4);
        oMap.setMapElement(5, 5, new TrafficLight(5, Enumerators.TrafficLightStateGreen));
        
        for(int i = 0; i < 10; i++){
            printString(oMap.printSmall());
            Thread.sleep(1000); //faz o código dormir por 1 segundo
            oMap.passTime(1);
        }
    }
}
