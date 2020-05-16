//*********************************************************************************************
// CLASS: classname (Roster.java)
//
// CSE205 Object Oriented Programming and Data Structures, Spring 2020
// Project Number: 3
//
// AUTHOR: Jason Green, jgreen44, jgreen44@asu.edu
//*********************************************************************************************
import java.util.ArrayList;

public class Roster {
    ArrayList<Student> mStudentList;

    public Roster(){
        mStudentList = new ArrayList<>();
        setStudentList(mStudentList);
    }

    public void addStudent(Student pStudent){
        mStudentList.add(pStudent);
    }

    public Student getStudent(String pLastName){
        int index = Searcher.search(getStudentList(), pLastName);
        if (index == -1){
            return null;
        }else{
            return mStudentList.get(index);
        }
    }

    public ArrayList<Student> getStudentList(){
        return this.mStudentList;
    }

    private void setStudentList(ArrayList<Student> pStudentList){
        this.mStudentList = pStudentList;
    }

    public void sortRoster(){
        Sorter.sort(getStudentList());
    }

    public String toString(){
        String result = "";
        for(Student student : getStudentList()){
            result += student + "\n";
        }

        return result;
    }

}
