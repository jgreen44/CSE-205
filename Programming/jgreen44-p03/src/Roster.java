import java.util.ArrayList;

public class Roster {
    ArrayList<Student> mStudentList;

    public Roster(){

    }

    public void addStudent(Student pStudent){

    }

    public Student getStudent(String pLastName){

    }

    public ArrayList<Student> getStudentList(){
        return this.mStudentList;
    }

    private void setStudentList(ArrayList<Student> pStudentList){
        this.mStudentList = pStudentList;
    }

    public void sortRoster(){

    }

    public String toString(){
        String result = "";
        for(Student student : getStudentList()){
            result += student + "\n";
        }

        return result;
    }

}
