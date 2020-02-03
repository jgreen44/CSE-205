//**************************************************************************************************
// CLASS: Main
//
// Main simply instantiates a View object so the GUI will be displayed when the program runs.
//**************************************************************************************************
public class Main {

    public static void main(String[] pArgs) {
        new Main().run();
    }

    public void run() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        View view = new View();
    }

}
