import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {

    public static final int FRAME_WIDTH = 525;
    public static final int FRAME_HEIGHT = 225;

    private Main mMain;
    private JButton mClearButton;
    private JTextField mExamText;
    private JButton mExitButton;
    private JTextField mHomeworkText;
    private JButton mSaveButton;
    private JButton mSearchButton;
    private JTextField mStudentName;

    public View(Main pMain){
        setMain(pMain);


        setTitle("Gred : : Gradebook Editor");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);

        add(panelMain);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent pEvent){

    }

    private void clear(){

    }

    private void clearNumbers(){

    }

    private void displayStudent(Student pStudent){

    }

    private Main getMain(){

        return this.mMain;

    }

    public void messageBox(String pMessage){
        JOptionPane.showMessageDialog(this, pMessage, "Message", JOptionPane.PLAIN_MESSAGE);

    }

    private void saveStudent(Student pStudent){

    }

    private void setMain(Main pMain){
        this.mMain = pMain;
    }
}
