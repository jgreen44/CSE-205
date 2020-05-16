//*********************************************************************************************
// CLASS: classname (Student.java)
//
// CSE205 Object Oriented Programming and Data Structures, Spring 2020
// Project Number: 3
//
// AUTHOR: Jason Green, jgreen44, jgreen44@asu.edu
//*********************************************************************************************
import java.util.ArrayList;

public class Student implements Comparable<Student> {
    public static Student mCurrStudent;
    private ArrayList<Integer> mExamList;
    private String mFirstName;
    private ArrayList<Integer> mHomeworkList;
    private String mLastName;


    public Student(String pFirstName, String pLastName){
        setFirstName(pFirstName);
        setLastName(pLastName);

        ArrayList<Integer> examList = new ArrayList<>();
        setExamList(examList);

        ArrayList<Integer> homeworkList = new ArrayList<>();
        setHomeworkList(homeworkList);
    }

    public void addExam(int pScore){
        getExamList().add(pScore);
    }

    public void addHomework(int pScore){
        getHomeworkList().add(pScore);
    }

    @Override
    public int compareTo(Student pStudent){
        int returnVal = 0;
        if(this.getLastName().length() < pStudent.getLastName().length()){
           returnVal = -1;
        }

        if(this.getLastName().length() == pStudent.getLastName().length()){
            returnVal = 0;
        }

        if(this.getLastName().length() > pStudent.getLastName().length()){
            returnVal = 1;
        }

        return  returnVal;
    }

    public static Student getCurrStudent(){
        return mCurrStudent;
    }

    public int getExam(int pNum){
        return getExamList().get(pNum);
    }

    private ArrayList<Integer> getExamList(){
        return this.mExamList;
    }

    public String getFirstName(){
        return this.mFirstName;
    }

    public String getFullName(){
        return this.mLastName + ", " +
                this.mFirstName;
    }

    public int getHomework(int pNum){
        return getHomeworkList().get(pNum);
    }

    private ArrayList<Integer> getHomeworkList(){
        return this.mHomeworkList;
    }

    public String getLastName(){
        return this.mLastName;
    }

    public static void setCurrStudent(Student pCurrStudent){
        mCurrStudent = pCurrStudent;
    }

    public void setExam(int pNum, int pScore){
        getExamList().set(pNum, pScore);
    }

    private void setExamList(ArrayList<Integer> pExamList){
        this.mExamList = pExamList;
    }

    public void setFirstName(String pFirstName){
        this.mFirstName = pFirstName;
    }

    public void setHomework(int pNum, int pScore){
        getHomeworkList().set(pNum, pScore);
    }

    private void setHomeworkList(ArrayList<Integer> pHomeworkList){
        this.mHomeworkList = pHomeworkList;
    }

    public void setLastName(String pLastName){
        this.mLastName = pLastName;
    }

    public String toString(){
        String result = getLastName() + " " + getFirstName() + " ";
        for(Integer exam : getExamList()){
            result += exam + " ";
        }

        for(Integer hw : getHomeworkList()){
            result += hw + " ";
        }

        return result.trim();
    }

}
