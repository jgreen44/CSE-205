import java.util.ArrayList;

public class Question_36 {
    public Question_36(){
        // default ctor
    }

    public void insertName(ArrayList<String> pList, String pName){
        int i = 0;
        while(i < pList.size() - 1){
            String name = pList.get(i);
            char character = name.charAt(i);
            // Compare if names are the same
            if (pName.compareToIgnoreCase(String.valueOf(character)) == 0){
                System.out.println("pName is equals zero");
                break;
                // compare if name is lexicographically greater
            }else if (pName.compareToIgnoreCase(name) > 0 ){
                System.out.println("name is greater");
            }
            i++;
        }
    }
}
