package rtsim;
import classes.Map;
import classes.Sign;
import classes.TrafficLight;
import global.Enumerators;
import static global.Util.printString;

public class RTSim{        
    public static void main(String[] args) throws InterruptedException{
        Map oMap = new Map(10, 20, 8, 10);
        oMap.insertIntersection(2, 2);
        oMap.insertIntersection(2, 7);
        oMap.insertIntersection(2, 12);
        oMap.insertIntersection(7, 2);
        oMap.insertIntersection(7, 7);
        oMap.insertIntersection(7, 12);
        oMap.insertIntersection(2, 13);
        oMap.insertIntersection(7, 13);
        oMap.insertStreet(60, 2, 2, 2, 7, new TrafficLight(5, Enumerators.TrafficLightStateGreen));
        oMap.insertStreet(60, 2, 7, 7, 7, new Sign());
        oMap.insertStreet(60, 7, 7, 7, 2, new Sign());
        oMap.insertStreet(60, 7, 2, 2, 2, new Sign());
        oMap.insertStreet(60, 7, 7, 7, 12, new Sign());
        oMap.insertStreet(60, 7, 12, 2, 12, new Sign());
        oMap.insertStreet(60, 2, 12, 2, 7, new TrafficLight(5, Enumerators.TrafficLightStateRed));
        oMap.insertStreet(60, 2, 12, 2, 13, new Sign());
        oMap.insertStreet(60, 7, 13, 7, 12, new Sign());
        oMap.insertStreet(60, 2, 13, 7, 13, new Sign());

        
        printString(oMap.printBig());
        for(int i = 0; i < 20; i++){
            printString(oMap.printSmall());
            Thread.sleep(1000); //faz o código dormir por 1 segundo
            oMap.passTime(1);
        }
    }
}
