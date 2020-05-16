//*********************************************************************************************
// CLASS: classname (Main.java)
//
// CSE205 Object Oriented Programming and Data Structures, Spring 2020
// Project Number: 3
//
// AUTHOR: Jason Green, jgreen44, jgreen44@asu.edu
//*********************************************************************************************

import javax.swing.*;
import java.io.FileNotFoundException;

public class Main {
    private static final int NUM_EXAMS = 3;
    private static final int NUM_HOMEWORKS = 5;
    private Roster mRoster;
    private View mView;

    public static void main(String[] args) {
        Main main = new Main();
        new Main().run();
    }

    public void exit(){
        try{
                GradebookWriter gbWriter = new GradebookWriter("gradebook.dat");
            gbWriter.writeGradebook(getRoster());
            System.exit(0);
            gbWriter.close();
        } catch (FileNotFoundException e) {
            getView().messageBox("Could not open gradebook.dat for writing. Exiting without saving.");
            System.exit(-1);
        }
    }

    public static int getNumExams(){
        return NUM_EXAMS;
    }

    public static int getNumHomeworks(){
        return NUM_HOMEWORKS;
    }

    private Roster getRoster(){
        return this.mRoster;
    }

    private View getView(){
        return this.mView;
    }

    private void run(){
        JFrame.setDefaultLookAndFeelDecorated(false);
        setView(new View(this));

        try{
            GradebookReader gbReader = new GradebookReader("gradebook.dat");
            setRoster(gbReader.readGradebook());

        }catch (FileNotFoundException e) {
            getView().messageBox("Could not open gradebook.dat for reading. Exiting");
            System.exit(-1);
        }
    }

    public Student search(String pLastName){
        return getRoster().getStudent(pLastName);
    }

    private void setRoster(Roster pRoster){
        this.mRoster = pRoster;
    }

    private void setView(View pView){
        this.mView = pView;
    }


}
