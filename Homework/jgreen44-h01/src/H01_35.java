// CLASS: H01_35
// AUTHOR: Jason Green, jgreen44, jgreen44@asu.edu
import java.util.ArrayList;

public class H01_35 {

    public H01_35(){
        // default ctor
    }

    public ArrayList<Integer> arrayListCreate(int pLen, int pInitValue){
        ArrayList<Integer> list = new  ArrayList<>();

        for (int i = 0; i < pLen ; i++) {
            list.add(pInitValue);
        }
        return list;
    }
}
