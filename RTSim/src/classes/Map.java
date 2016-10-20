package classes;
import global.Enumerators;
import static global.Util.printInt;
import static global.Constants.InfiniteInt;
import static global.Constants.LineBreak;
import static global.Constants.SingleLine;
import static global.Constants.DoubleLine;

public class Map{
    // Properties
    private int timer;
    private final int sizeX;
    private final int sizeY;
    private final int intersectionTotal;
    private final int streetTotal;
    private int intersectionCount;
    private int streetCount;
    private final Element[][] map;
    private final Intersection[] intersections;
    private final Street[] streets;
    private final int[][] dijkstra;
    
    // Constructors
    public Map(){
        this(0, 0, 0, 0);
    }
    
    public Map(int sizeX, int sizeY, int intersectionTotal, int streetTotal){
        this.timer = 0;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.intersectionTotal = intersectionTotal;
        this.streetTotal = streetTotal;
        this.intersectionCount = 0;
        this.streetCount = 0;
        this.map = new Element[sizeX][sizeY];
        this.intersections = new Intersection[intersectionTotal];
        this.streets = new Street[streetTotal];
        this.dijkstra = new int[intersectionTotal][intersectionTotal];
        
        for(int i = 0; i < sizeX; i++){
            for(int j = 0; j < sizeY; j++){
                this.map[i][j] = new Element(Enumerators.ElementTypeUnknown);
            }
        }
        
        for(int i = 0; i < intersectionTotal; i++){
            this.intersections[i] = new Intersection(i);
        }
        
        for(int i = 0; i < streetTotal; i++){
            this.streets[i] = new Street(i);
        }
        
        for(int i = 0; i < intersectionTotal; i++){
            for(int j = 0; j < intersectionTotal; j++){
                this.dijkstra[i][j] = InfiniteInt;
            }
        }
    }
    
    // Methods
    public void passTime(int temp){
        this.timer += temp;
        for(int i = 0; i < sizeX; i++){
            for(int j = 0; j < sizeY; j++){
                this.map[i][j].passTime(temp);
            }
        }
    }
    
    public String printSmall(){
        String temp = "";
        
        temp += "Map (" + this.timer + " seg):" + LineBreak;
        temp += "x\\y ";
        for(int j = 0; j < sizeY; j++){
            temp += printInt(j, 3) + " ";
        }
        temp += LineBreak;
        for(int i = 0; i < sizeX; i++){
            temp += printInt(i, 3) + " ";
            for(int j = 0; j < sizeY; j++){
                temp += this.map[i][j].printSmall()+ " ";
            }
            temp += LineBreak;
        }
        temp += DoubleLine;
        
        return temp;
    }
    
    public String printMedium(){
        String temp = "";
        
        temp += "Map (" + this.timer + " seg):" + LineBreak;
        temp += "x\\y ";
        for(int j = 0; j < sizeY; j++){
            temp += printInt(j, 3) + " ";
        }
        temp += LineBreak;
        for(int i = 0; i < sizeX; i++){
            temp += printInt(i, 3) + " ";
            for(int j = 0; j < sizeY; j++){
                temp += this.map[i][j].printSmall()+ " ";
            }
            temp += LineBreak;
        }
        temp += SingleLine;
        
        temp += "Intersections:" + LineBreak;
        for(int i = 0; i < intersectionTotal; i++){
            temp += printInt(i, 3) + " ";
        }
        temp += LineBreak;
        for(int i = 0; i < intersectionTotal; i++){
            temp += this.intersections[i].printSmall() + " ";
        }
        temp += SingleLine;
        
        temp += "Streets:" + LineBreak;
        for(int i = 0; i < streetTotal; i++){
            temp += printInt(i, 3) + " ";
        }
        temp += LineBreak;
        for(int i = 0; i < streetTotal; i++){
            temp += this.streets[i].printSmall() + " ";
        }
        temp += SingleLine;
        
        temp += "Dijkstra:" + LineBreak;
        temp += "b\\e ";
        for(int j = 0; j < intersectionTotal; j++){
            temp += printInt(j, 3) + " ";
        }
        temp += LineBreak;
        for(int i = 0; i < intersectionTotal; i++){
            temp += printInt(i, 3) + " ";
            for(int j = 0; j < intersectionTotal; j++){
                temp += printInt(this.dijkstra[i][j], 3) + " ";
            }
            temp += LineBreak;
        }
        temp += DoubleLine;
        
        return temp;
    }
    
    public boolean insertIntersection(){
        // TODO - implementar a inserção de interseções
        return false;
    }
    
    public boolean insertStreet(){
        // TODO - imlplementar a inserção de ruas
        return false;
    }
    
    public boolean validateMap(){
        if(this.sizeX <= 0) return false;
        if(this.sizeY <= 0) return false;
        if(this.intersectionTotal <= 0) return false;
        if(this.streetTotal <= 0) return false;
        if(this.intersectionCount > this.intersectionTotal) return false;
        if(this.streetCount > this.streetTotal) return false;
        // TODO - adicionar mais validações
        return true;
    }
    
    private boolean validateIntersection(Intersection temp){
        if(this.intersectionCount > this.intersectionTotal) return false;
        // TODO - adicionar mais validações
        return true;
    }
    
    private boolean validateStreet(Street temp){
        if(this.streetCount > this.streetTotal) return false;
        // TODO - adicionar mais validações
        return true;
    }
    
    // Getters and setters
    public Element getMapElement(int locationX, int locationY){
        return map[locationX][locationY];
    }
    
    public void setMapElement(int locationX, int locationY, Element temp){
        map[locationX][locationY] = temp;
    }
    
    public int[][] getDijkstra(){
        return dijkstra;
    }
    
}
