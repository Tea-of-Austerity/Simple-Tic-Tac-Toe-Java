//import com.jogamp.common.util.ArrayHashMap;
import java.util.Arrays;
class ArrayOperations {
    public static void printCorners(int[][] twoDimArray) {
        // write your code here
        int[][] newTwoDimArray = new int[2][2];
        newTwoDimArray[0][0]= twoDimArray[0][0];
        newTwoDimArray[0][1]= twoDimArray[0][twoDimArray[0].length-1];
        newTwoDimArray[1][0]= twoDimArray[twoDimArray.length-1][0];
        newTwoDimArray[1][1]= twoDimArray[twoDimArray.length-1][twoDimArray[twoDimArray.length-1].length-1];
        for (int i =0; i<=newTwoDimArray.length-1;i++){
            System.out.println(newTwoDimArray[i][0] + " " + newTwoDimArray[i][1]);
        }
    }
}