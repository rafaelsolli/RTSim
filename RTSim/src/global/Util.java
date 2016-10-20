package global;
import static global.Constants.InfiniteInt;

public class Util{
    public static String printInt(int temp, int leftZeros){
        if(leftZeros <= 0) leftZeros = 1;
        if(temp == InfiniteInt) return "INF";
        return String.format("%0" + leftZeros + "d", temp);
    }
    
    public static void printString(String temp){
        System.out.println(temp);
    }
}
