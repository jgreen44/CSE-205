import javax.swing.text.View;

public class Main {
    private static final int NUM_EXAMS = 3;
    private static final int NUM_HOMEWORKS = 5;
    private Roster mRoster;
    private View mView;

    public static void main(String[] args) {
        new Main().run();
    }

    public void exit(){

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



    }

    public Student search(String pLastName){

    }

    private void setRoster(Roster pRoster){
        this.mRoster = pRoster;
    }

    private void setView(View pView){
        this.mView = pView;
    }


}
