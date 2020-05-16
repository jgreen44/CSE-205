//*********************************************************************************************
// CLASS: classname (View.java)
//
// CSE205 Object Oriented Programming and Data Structures, Spring 2020
// Project Number: 3
//
// AUTHOR: Jason Green, jgreen44, jgreen44@asu.edu
//*********************************************************************************************
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {

    public static final int FRAME_WIDTH = 525;
    public static final int FRAME_HEIGHT = 225;

    private Main mMain;
    private JButton mClearButton;
    private JButton mExitButton;
    private JButton mSaveButton;
    private JButton mSearchButton;

    private JTextField mExamText;
    private JTextField mHomeworkText;
    private JTextField mStudentName;



    public View(Main pMain){
        setMain(pMain);

        JPanel panelSearch = new JPanel(new FlowLayout());
        panelSearch.add(new JLabel("Student Name: "));
        mStudentName = new JTextField(25);
        panelSearch.add(mStudentName);
        mSearchButton = new JButton("Search:");
        mSearchButton.addActionListener(this);
        panelSearch.add(mSearchButton);

        JPanel panelHomework = new JPanel(new FlowLayout());
        panelHomework.add(new JLabel("Homework: "));
        JTextField[] mHomeworkText = new JTextField[Main.getNumHomeworks()];

        for (int i = 0; i < Main.getNumHomeworks(); i++){
            mHomeworkText[i] = new JTextField(5);
            panelHomework.add(mHomeworkText[i]);
        }

        JPanel panelExam = new JPanel(new FlowLayout());
        panelExam.add(new JLabel("Exam: "));
        JTextField[] mExamText = new JTextField[Main.getNumExams()];

        for (int i = 0; i < Main.getNumExams(); i ++){
            mExamText[i] = new JTextField(5);
            panelExam.add(mExamText[i]);
        }


        JPanel panelButtons = new JPanel(new FlowLayout());
        // CLEAR button
        mClearButton = new JButton("Clear");
        mClearButton.addActionListener(this);
        panelButtons.add(mClearButton);

        // SAVE button
        mSaveButton = new JButton("Save");
        mSaveButton.addActionListener(this);
        panelButtons.add(mSaveButton);

        // EXIT button
        mExitButton = new JButton("Exit");
        mExitButton.addActionListener(this);
        panelButtons.add(mExitButton);

        // Main Panel
        JPanel panelMain = new JPanel();
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        panelMain.add(panelSearch);
        panelMain.add(panelHomework);
        panelMain.add(panelExam);
        panelMain.add(panelButtons);

        setTitle("Grade Book Editor");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        add(panelMain);

        // Mac users
        pack();

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent pEvent){
        if (pEvent.getSource() == mSaveButton){
            JTextField[] mHomeworkText = new JTextField[Main.getNumHomeworks()];
            for (int i = 0; i < Main.getNumHomeworks(); i++){
                mHomeworkText[i].setText("");
            }
            JTextField[] mExamText = new JTextField[Main.getNumExams()];

            for (int i = 0; i < Main.getNumExams(); i ++){
                mExamText[i].setText("");
            }

            String lastName = mStudentName.getText();

            if(lastName.isEmpty()){
                messageBox("Please enter the student's last name");
            }else{
                Student.setCurrStudent(getMain().search(lastName));
                if(Student.getCurrStudent() == null){
                    messageBox("Student not found. Try again.");
                }else{
                    displayStudent(Student.getCurrStudent());
                }
            }
        }else if(pEvent.getSource() == mSaveButton){
            if(Student.getCurrStudent() != null){
                saveStudent(Student.getCurrStudent());
            }
        }else if(pEvent.getSource() == mClearButton){
            clear();
        }else if(pEvent.getSource() == mExitButton){
            if(Student.getCurrStudent() != null){
                saveStudent(Student.getCurrStudent());
                getMain().exit();
            }
        }
    }

    private void clear(){
        mStudentName.setText("");
        clearNumbers();
        Student.mCurrStudent = null;
    }

    private void clearNumbers(){
        JTextField[] mHomeworkText = new JTextField[Main.getNumHomeworks()];
        JTextField[] mExamText = new JTextField[Main.getNumExams()];

        for(int i = 0; i < Main.getNumHomeworks(); i++){
            mHomeworkText[i].setText("");
        }

        for(int i = 0; i < Main.getNumExams(); i++){
            mExamText[i].setText("");
        }


    }

    private void displayStudent(Student pStudent){
        JTextField[] mHomeworkText = new JTextField[Main.getNumHomeworks()];
        JTextField[] mExamText = new JTextField[Main.getNumExams()];

        for(int i =0; i < Main.getNumHomeworks() - 1; i++){
            int hw = pStudent.getHomework(i);
            String hwstr  = Integer.toString(hw);
            mHomeworkText[i].setText(hwstr);
        }

        for(int i = 0; i < Main.getNumExams() - 1; i++){
            int ex = pStudent.getExam(i);
            String exstr = Integer.toString(ex);
            mExamText[i].setText(exstr);
        }
    }

    private Main getMain(){
        return this.mMain;
    }

    public void messageBox(String pMessage){
        JOptionPane.showMessageDialog(this, pMessage, "Message", JOptionPane.PLAIN_MESSAGE);

    }

    private void saveStudent(Student pStudent){
        JTextField[] mHomeworkText = new JTextField[Main.getNumHomeworks()];
        JTextField[] mExamText = new JTextField[Main.getNumExams()];
        for(int i = 0; i< Main.getNumHomeworks() - 1; i++){
            String hwstr = mHomeworkText[i].getText();
            int hw = Integer.parseInt(hwstr);
            pStudent.setHomework(i, hw);
        }

        for(int i = 0; i< Main.getNumExams() - 1; i++){
            String exstr = mExamText[i].getText();
            int ex = Integer.parseInt(exstr);
            pStudent.setHomework(i, ex);
        }
    }

    private void setMain(Main pMain){
        this.mMain = pMain;
    }
}
