//**************************************************************************************************
// CLASS: Student
//
// DESCRIPTION
// Student is an abstract class and is the superclass for the OnCampusStudent and OnlineStudent
// classes. Remember that in a class hierarchy, the superclass declares data and methods that are
// common to all types of students.
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Sprint and 2020
// Project Number: 02
//
// AUTHOR: Jason Green, jgreen44, jgreen44@asu.edu
//**************************************************************************************************
public abstract class Student implements Comparable<Student> {


    public int mCredits = 0;
    public String mFirstName = "";
    public String mId = "";
    public String mLastName = "";
    public double mTuition = 0;

    public Student(String pId, String pFirstName, String pLastName){
        this.mId = pId;
        this.mFirstName = pFirstName;
        this.mLastName = pLastName;
    }

    public void calcTuition(){

    }

    @Override
    public int compareTo(Student pStudent) {
        return getId().compareTo(pStudent.getId());
    }

    public int getCredits() {
        return mCredits;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getId() {
        return mId;
    }

    public String getLastName() {
        return mLastName;
    }

    public double getTuition() {
        return mTuition;
    }

    public void setCredits(int pCredits) {
        this.mCredits = pCredits;
    }

    public void setFirstName(String pFirstName) {
        this.mFirstName = pFirstName;
    }

    public void setId(String pId) {
        this.mId = pId;
    }

    public void setLastName(String pLastName) {
        this.mLastName = pLastName;
    }

    protected void setTuition(double pTuition){
        this.mTuition = pTuition;
    }




}
