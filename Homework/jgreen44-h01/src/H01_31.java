// CLASS: H01_31
// AUTHOR: Jason Green, jgreen44, jgreen44@asu.edu
import java.util.ArrayList;

public class H01_31 {
    public H01_31() {
        // Provide a default constructor. Some exercises may require other ctors.
    }
    // This is the method you are asked to write for Ex. 3.1. Name it exactly as requested.
    public ArrayList<Integer> arrayListInit() {
        // 1. Declare and instantiate an ArrayList<Integer> object named list.
        ArrayList<Integer> list = new ArrayList<>();
        int counter = 0;
        // 2. Write single for/while loops or a pair of for/while loops to fill list with the specified values.
        while (counter < 2) {
            for (int i = 0; i < 5; i++) {
                list.add(i);
            }
            counter ++;
        }
        // 3. Return list.
        return list;
    }

}
