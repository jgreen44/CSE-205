//*********************************************************************************************
// CLASS: classname (Searcher.java)
//
// CSE205 Object Oriented Programming and Data Structures, Spring 2020
// Project Number: 3
//
// AUTHOR: Jason Green, jgreen44, jgreen44@asu.edu
//*********************************************************************************************
import java.util.ArrayList;

public class Searcher {
    public static int search(ArrayList<Student> pList, String pKey){
        int pLow = 0, pHigh = pList.size() - 1;

        if(pLow > pHigh){
            return -1;
        }
        int middle = (pLow + pHigh) / 2;
        int result = pList.get(middle).getLastName().compareToIgnoreCase(pKey);

        if(pList.get(middle).getLastName().compareToIgnoreCase(pKey) == 0){
            return middle;
        }else if(pList.get(middle).getLastName().compareToIgnoreCase(pKey) > 0){
            return search(pList, pKey);
        }else{
            return search(pList, pKey);
        }

    }
}
