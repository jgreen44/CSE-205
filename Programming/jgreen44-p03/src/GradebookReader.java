//*********************************************************************************************
// CLASS: classname (GradebookReader.java)
//
// CSE205 Object Oriented Programming and Data Structures, Spring 2020
// Project Number: 3
//
// AUTHOR: Jason Green, jgreen44, jgreen44@asu.edu
//*********************************************************************************************
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GradebookReader {

    private Scanner mIn;

    public GradebookReader (String pFname) throws FileNotFoundException{
        mIn = new Scanner(new File(pFname));
    }

    private void readExam(Student pStudent){
        for(int i = 0; i < Main.getNumExams(); ++i){
            pStudent.addExam(mIn.nextInt());
        }
    }

    public Roster readGradebook(){
        Roster roster = readRoster();
        roster.sortRoster();
        return roster;
    }

    private void readHomework(Student pStudent){
        for(int i = 0; i < Main.getNumHomeworks(); ++i){
            pStudent.addHomework(mIn.nextInt());
        }
    }

    private Roster readRoster(){
        Roster roster = new Roster();
        while(mIn.hasNext()){
            String lastName = mIn.next();
            String firstName = mIn.next();
            Student student = new Student(firstName, lastName);
            readExam(student);
            readHomework(student);
            roster.addStudent(student);
        }

        return roster;
    }

}
