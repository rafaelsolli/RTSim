package classes;
import global.Enumerators;
import static global.Constants.InfiniteInt;
import static global.Constants.LineBreak;
import static global.Constants.SingleLine;
import static global.Constants.DoubleLine;
import static global.Util.printInt;

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
    
    public String printBig(){
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
        temp += LineBreak + LineBreak;
        for(int i = 0; i < intersectionTotal; i++){
            temp += this.intersections[i].printMedium();
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
        temp += LineBreak + LineBreak;
        for(int i = 0; i < streetTotal; i++){
            temp += this.streets[i].printMedium();
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
    
    public void insertIntersection(int locationX, int locationY){
        Intersection temp = new Intersection(this.intersectionCount, locationX, locationY);
        
        if(validateMap() && validateIntersection(temp)){
            this.intersections[temp.getIndex()] = temp;
            this.map[temp.getLocationX()][temp.getLocationY()] = temp;
            
            this.intersectionCount++;
        }
    }
    
    public void insertStreet(int speed, int beginX, int beginY, int endX, int endY, Sign sign){
        Street temp = new Street(this.streetCount, speed, beginX, beginY, endX, endY, sign);
        
        if(validateMap() && validateStreet(temp)){
            Intersection begin = (Intersection)this.map[beginX][beginY];
            Intersection end = (Intersection)this.map[endX][endY];
            
            this.dijkstra[begin.getIndex()][end.getIndex()] = temp.getLength();
            this.streets[temp.getIndex()] = temp;
            switch(temp.getDirection()){
                case StreetDirectionNorth:
                    for(int i = beginX - 1; i > endX; i--){
                        this.map[i][beginY] = temp;
                        if((i == endX + 1) && (temp.getSign().getSignType() != Enumerators.SignTypeUnknown)) this.map[i][beginY] = temp.getSign();
                    }
                    break;
                case StreetDirectionEast:
                    for(int i = beginY + 1; i < endY; i++){
                        this.map[beginX][i] = temp;
                        if((i == endY - 1) && (temp.getSign().getSignType() != Enumerators.SignTypeUnknown)) this.map[beginX][i] = temp.getSign();
                    }
                    break;
                case StreetDirectionSouth:
                    for(int i = beginX + 1; i < endX; i++){
                        this.map[i][beginY] = temp;
                        if((i == endX - 1) && (temp.getSign().getSignType() != Enumerators.SignTypeUnknown)) this.map[i][beginY] = temp.getSign();
                    }
                    break;
                case StreetDirectionWest:
                    for(int i = beginY - 1; i > endY; i--){
                        this.map[beginX][i] = temp;
                        if((i == endY + 1) && (temp.getSign().getSignType() != Enumerators.SignTypeUnknown)) this.map[beginX][i] = temp.getSign();
                    }
                    break;
                default:
                    break;
            }
            
            this.streetCount++;
        }
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
    
    public int[][] getDijkstra(){
        return dijkstra;
    }
    
}
