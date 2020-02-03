import java.util.ArrayList;

public class Student implements Comparable<Student> {
    public static Student mCurrStudent;
    private ArrayList<Integer> mExamList;
    private String mFirstName;
    private ArrayList<Integer> mHomeworkList;
    private String mLastName;


    public Student(String pFirstName, String pLastName){
        this.mFirstName = pFirstName;
        this.mLastName = pLastName;
    }

    public void addExam(int pScore){

    }

    public void addHomework(int pScore){

    }

    public int compareTo(Student pStudent){

    }

    public static Student getCurrStudent(){
        return mCurrStudent;
    }

    public int getExam(int pNum){

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

    }

    private void setExamList(ArrayList<Integer> pExamList){
        this.mExamList = pExamList;
    }

    public void setFirstName(String pFirstName){
        this.mFirstName = pFirstName;
    }

    public void setHomework(int pNum, int pScore){

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
