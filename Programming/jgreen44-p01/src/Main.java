//********************************************************************************************************
// CLASS: classname (main.java)
//
// DESCRIPTION
// Programming Assignment #1
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Spring 2020
// Project Number: project-number
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

    public void run()  {

        // DO NOT FORGET TO CHANGE THE HARD CODING OF THE FILE!
        String file_input = "p01-in.txt";
        String file_output = "p01-runs.txt";
        ArrayList<Integer> list = new ArrayList<>();

        final int RUNS_UP = 1;
        final int RUNS_DN = 0;

        // Read in the file
        try {
            readInputFile(file_input, list);
        } catch (FileNotFoundException e) {
            // Print friendly error message
            System.exit(-100);
        }

        ArrayList<Integer> listRunsUpCount = findRuns(list, RUNS_UP);
        ArrayList<Integer> listRunsDnCount = findRuns(list, RUNS_DN);
        ArrayList<Integer> listRunsCount = mergeLists(listRunsUpCount, listRunsDnCount );
        // Output the file
        try {
            writeOutputFile(file_output, listRunsCount);
        } catch (FileNotFoundException e) {
            // Print friendly error message
            System.exit(-100);
        }

    }

    public ArrayList<Integer> findRuns(ArrayList<Integer> pList, int pDir) {
        int i = 0;
        int k = 0;
        ArrayList<Integer> listRunsCount = arrayListCreate(pList.size(), 0);
        while (i < pList.size() - 1) {
            if (pDir == 1 && pList.get(i) <= pList.get(i + 1)) {
                k++;
            } else if (pDir == 0 && pList.get(i) >= pList.get(i + 1)) {
                k++;
            } else {
                if (k != 0) {
                    int increment = listRunsCount.get(k);
                    listRunsCount.set(k, increment + 1);
                    k = 0;
                }
            }
            i++;
        }

        if (k != 0){
            int increment = listRunsCount.get(k);
            listRunsCount.set(k, increment + 1);
        }
        return listRunsCount;
    }

    public ArrayList<Integer> mergeLists(ArrayList<Integer> pListRunsUpCount, ArrayList<Integer> pListRunsDnCount) {
        ArrayList<Integer> listRunsCount = arrayListCreate(pListRunsUpCount.size(), 0);
        for (int i = 0; i < pListRunsUpCount.size() - 1; i++) {
            int sum = pListRunsUpCount.get(i) + pListRunsDnCount.get(i);
            listRunsCount.set(i, sum);
        }
        return listRunsCount;

    }

    public ArrayList<Integer> arrayListCreate(int pSize, int pInitValue) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < pSize; i++) {
            list.add(pInitValue);
        }
        return list;
    }

    public void writeOutputFile(String pFilename, ArrayList<Integer> pListruns) throws FileNotFoundException {
        PrintWriter scan_out = new PrintWriter(new File(pFilename));
        int sum = 0;
        for (int i = 0; i < pListruns.size() - 1; i++){
            sum = sum + pListruns.get(i);
        }

        scan_out.println("runs_total: " + sum);
        for (int i = 1; i < pListruns.size() - 1 ; i++) {
            scan_out.println("runs_" + i + ": " + pListruns.get(i));
        }
        scan_out.close();
    }

    public ArrayList<Integer> readInputFile(String pFilename, ArrayList<Integer> pListRuns) throws FileNotFoundException {
        Scanner scan_in = new Scanner(new File(pFilename));
        ArrayList<Integer> list = new ArrayList<Integer>();
        do {
            pListRuns.add(scan_in.nextInt());
        } while (scan_in.hasNext());

        scan_in.close();

        return pListRuns;
    }
}
