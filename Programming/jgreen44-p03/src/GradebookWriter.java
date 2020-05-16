//*********************************************************************************************
// CLASS: classname (GradebookWriter.java)
//
// CSE205 Object Oriented Programming and Data Structures, Spring 2020
// Project Number: 3
//
// AUTHOR: Jason Green, jgreen44, jgreen44@asu.edu
//*********************************************************************************************
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class GradebookWriter extends PrintWriter {

    public GradebookWriter(String pFname) throws FileNotFoundException{
        super(pFname);

    }

    public void writeGradebook(Roster pRoster){
        for(Student student: pRoster.getStudentList()){
            println(student);
        }


    }
}
