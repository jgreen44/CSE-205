// CLASS: H01_34
// AUTHOR: Jason Green, jgreen44, jgreen44@asu.edu

import java.util.ArrayList;

public class H01_34 {

    public H01_34(){
        // default constructor
    }

    public Integer arrayListSum(ArrayList<Integer> pList){
        int sum = 0;
        if (pList != null){
            for (int i = 0; i < pList.size(); i++) {
                sum = sum + i;
            }
        }
        return sum;
    }


}
