// CLASS: H01_43
// AUTHOR: Jason Green, jgreen44, jgreen44@asu.edu

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class H01_43 {

    public static void main(String[] args) throws IOException {
        int num, square;


        // Scanner for user input
        Scanner scan = new Scanner( System.in );

        // prepare the input file
        System.out.print("What is the filename? ");
        String filename = scan.nextLine();
        System.out.println("Opening " + filename);

        Scanner file_input = new Scanner(new File(filename));

        PrintWriter out = new PrintWriter(new File(filename + ".txt"));
        int number = 0;
        while( file_input.hasNext() )
        {
            String file = file_input.nextLine();
            number ++;
            System.out.println("[00" + number + "] " + file);
            out.println("[00" + number + "] " + file );
        }

        // close the input & output file
        scan.close();
        out.close();

    }
}
