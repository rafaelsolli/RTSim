package classes;
import enumerators.ElementType;

public class Intersection extends Element{
    // Properties
    static int IntersectionCount = 0;
    private final int count;
    private boolean goesNorth;
    private boolean goesEast;
    private boolean goesSouth;
    private boolean roesWest;
    private Street north;
    private Street east;
    private Street south;
    private Street west;
    
    // Constructors
    public Intersection(){
        super(ElementType.IntersectionElement, 0, 0);
        this.count = 0;
        this.goesNorth = false;
        this.goesEast = false;
        this.goesSouth = false;
        this.roesWest = false;
    }
    
    public Intersection(int locationX, int locationY){
        super(ElementType.IntersectionElement, locationX, locationY);
        this.count = Intersection.IntersectionCount;
        this.goesNorth = false;
        this.goesEast = false;
        this.goesSouth = false;
        this.roesWest = false;
        
        Intersection.IntersectionCount++;
    }
    
    // Methods
    @Override
    public String FullToString(){
        String temp;
        
        temp = "Intersection " + this.count + ", at (" + this.locationX + "," + this.locationY + ")\n";
        if(this.goesNorth) temp += "-> North: " + this.north.FullToString() + " \n";
        if(this.goesEast) temp += "-> East: " + this.east.FullToString() + " \n";
        if(this.goesSouth) temp += "-> South: " + this.south.FullToString() + " \n";
        if(this.roesWest) temp += "-> West: " + this.west.FullToString() + " \n";
        
        return temp;
    }
    
    // Getters and setters
    public int getCount(){
        return count;
    }
    
    public void setNorth(Street north){
        this.north = north;
        this.goesNorth = true;
    }

    public void setEast(Street east){
        this.east = east;
        this.goesEast = true;
    }

    public void setSouth(Street south){
        this.south = south;
        this.goesSouth = true;
    }

    public void setWest(Street west){
        this.west = west;
        this.roesWest = true;
    }

    public boolean itGoesNorth(){
        return goesNorth;
    }

    public boolean itGoesEast(){
        return goesEast;
    }

    public boolean itGoesSouth(){
        return goesSouth;
    }

    public boolean itGoesWest(){
        return roesWest;
    }
}
