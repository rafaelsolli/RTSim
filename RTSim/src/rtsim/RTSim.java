package rtsim;
import classes.Intersection;
import classes.Map;

public class RTSim{
    public static void main(String[] args){
        Map mapa = new Map(10, 15, 10);
        
        mapa.InsertIntersection(0, 0);
        mapa.InsertIntersection(0, 12);
        mapa.InsertIntersection(9, 12);
        mapa.InsertIntersection(9, 0);
        
        Intersection begin = (Intersection) mapa.getElement(0, 0);
        Intersection end = (Intersection) mapa.getElement(0, 12);
        mapa.InsertStreet(begin, end, 90);
        
        begin = (Intersection) mapa.getElement(0, 12);
        end = (Intersection) mapa.getElement(9, 12);
        mapa.InsertStreet(begin, end, 60);
        
        System.out.println(mapa.ToString());
    }
}
