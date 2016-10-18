package classes;
import enumerators.ElementType;

public class Map{
    // Properties
    private final int sizeX;
    private final int sizeY;
    private final int sizeZ;
    private final Element[][] elements;
    private final Street[][] streets;
    private final Intersection[] intersections;
    
    // Constructors
    public Map(int sizeX, int sizeY, int sizeZ){
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.sizeZ = sizeZ;
        this.elements = new Element[sizeX][sizeY];
        this.streets = new Street[sizeZ][sizeZ];
        this.intersections = new Intersection[sizeZ];
        
        for (int i = 0; i < sizeX; i++){
            for (int j = 0; j < sizeY; j++){
                this.elements[i][j] = new Element(ElementType.UnknownElement, i, j);
            }
        }
        
        for (int i = 0; i < sizeZ; i++){
            for (int j = 0; j < sizeZ; j++){
                this.streets[i][j] = new Street();
            }
        }
        
        for (int i = 0; i < sizeZ; i++) {
            this.intersections[i] = new Intersection();
        }
    }
    
    // Methods
    public void InsertIntersection(int locationX, int locationY){
        Intersection temp = new Intersection(locationX, locationY);
        this.intersections[temp.getCount()] = temp;
        this.elements[locationX][locationY] = temp;
    }
    
    public void InsertStreet(Intersection begin, Intersection end, int speed){
        Street temp = new Street(begin, end, speed);
        
        this.streets[begin.getCount()][end.getCount()] = temp;
        switch(temp.getDirection()){
            case ToNorthStreet:
                begin.setNorth(temp);
                for (int i = begin.getLocationX() - 1; i > end.getLocationX(); i--){
                    this.elements[i][begin.getLocationY()] = temp;
                }
                break;
            case ToEastStreet:
                begin.setEast(temp);
                for (int i = begin.getLocationY() + 1; i < end.getLocationY(); i++){
                    this.elements[begin.getLocationX()][i] = temp;
                }
                break;
            case ToSouthStreet:
                begin.setSouth(temp);
                for (int i = begin.getLocationX() + 1; i < end.getLocationX(); i++){
                    this.elements[i][begin.getLocationY()] = temp;
                }
                break;
            case ToWestStreet:
                begin.setWest(temp);
                for (int i = begin.getLocationY() - 1; i > end.getLocationY(); i--){
                    this.elements[begin.getLocationX()][i] = temp;
                }
                break;
            default:
                break;
        }
    }
    
    public String ToString(){
        String temp;
        
        temp = "Map (" + this.sizeX + "," + this.sizeY + ") with " + Intersection.IntersectionCount + "/" + this.sizeZ + " intersections\n";
        for (int i = 0; i < this.sizeX; i++){
            for (int j = 0; j < this.sizeY; j++){
                temp += this.elements[i][j].ToString() + " ";
            }
            temp += "\n";
        }
        temp += "\n";
        
        for (int i = 0; i < this.sizeZ; i++){
            for (int j = 0; j < this.sizeZ; j++){
                temp += "[" + String.format("%03d", this.streets[i][j].getLength()) + "] ";
            }
            temp += "\n";
        }
        temp += "\n";
        
        for (int i = 0; i < this.sizeZ; i++) {
            temp += this.intersections[i].FullToString() + "\n";
        }
        
        return temp;
    }
    
    // Getters and setters
    public Element getElement(int locationX, int locationY){
        return this.elements[locationX][locationY];
    }
}
