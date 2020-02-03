//********************************************************************************************************
// CLASS: Main (Main.java)
//
// DESCRIPTION
// Main Class for Project 02.
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Sprint and 2020
// Project Number: 02
//
// AUTHOR: Jason Green, jgreen44, jgreen44@asu.edu
//********************************************************************************************************

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }


    private void calcTuition(ArrayList<Student> pStudentList) {
        for (Student student : pStudentList) {
            student.calcTuition();
        }
    }

    private ArrayList<Student> readFile() throws FileNotFoundException {
        ArrayList<Student> studentList = new ArrayList<>();
        Scanner in = new Scanner(new File("p02-students.txt"));

        while (in.hasNext()) {
            String studentType = in.next();
            if (studentType.equalsIgnoreCase("C")) {
                studentList.add(readOnCampusStudent(in));
            } else {
                studentList.add((readOnlineStudent(in)));
            }
        }

        in.close();
        return studentList;
    }

    private OnCampusStudent readOnCampusStudent(Scanner pIn){
        String id = pIn.next();
        String lname = pIn.next();
        String fname = pIn.next();
        String res = pIn.next();
        double fee = pIn.nextDouble();
        int credits = pIn.nextInt();
        OnCampusStudent onCampusStudent = new OnCampusStudent(id, fname, lname);

        if (res.equalsIgnoreCase("R")){
            onCampusStudent.setResidency(OnCampusStudent.RESIDENT);
        }else{
            onCampusStudent.setResidency(OnCampusStudent.NON_RESIDENT);
        }
        onCampusStudent.setProgramFee(fee);
        onCampusStudent.setCredits(credits);

        return onCampusStudent;
    }

    private OnlineStudent readOnlineStudent (Scanner pIn){
        String id = pIn.next();
        String lname = pIn.next();
        String fname = pIn.next();
        String fee = pIn.next();
        int credits = pIn.nextInt();

        OnlineStudent onlineStudent = new OnlineStudent(id, fname, lname);

        if (fee.equalsIgnoreCase("T")){
            onlineStudent.setTechFee(true);
        }else{
            onlineStudent.setTechFee(false);
        }

        onlineStudent.setCredits(credits);
        return onlineStudent;

    }

    private void run(){
    ArrayList<Student> studentList = new ArrayList<>();

    try{
        studentList = readFile();
    }catch (FileNotFoundException e){
        System.out.println("Sorry, could not open 'p02-students.txt' for reading. Stopping.");
        System.exit(-1);
    }

    calcTuition(studentList);
    Sorter.insertionSort(studentList, Sorter.SORT_ASCENDING);

    try{
        writeFile(studentList);
    }catch (FileNotFoundException e){
        System.out.println("Sorry, could not open 'p02-tuition.txt' for writing. Stopping.");
        System.exit(-1);
    }

    }

    private void writeFile(ArrayList<Student> pStudentList) throws FileNotFoundException{
        PrintWriter out = new PrintWriter(new File("p02-tuition.txt"));
        for(Student student : pStudentList){

            out.printf("%-16s %-20s %-15s %8s %n",
                    student.mId,
                    student.getLastName(),
                    student.getFirstName(),
                    student.getTuition());
        }
        out.close();

    }
}
