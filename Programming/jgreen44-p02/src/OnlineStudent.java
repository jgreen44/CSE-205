//********************************************************************************************************
// CLASS: OnlineStudent
//
// DESCRIPTION
// Calculates the tuition for the online student. Also gets and sets:
//  1. Tech Fee
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Sprint and 2020
// Project Number: 02
//
// AUTHOR: Jason Green, jgreen44, jgreen44@asu.edu
//********************************************************************************************************
public class OnlineStudent extends Student {

    private boolean mTechFee;

    public OnlineStudent(String pID, String pFirstName, String pLastName){
        super(pID, pFirstName, pLastName);

    }

    @Override
    public void calcTuition(){
        double t = getCredits() * TuitionConstants.ONLINE_CREDIT_RATE;

        if (getTechFee()){
            t += TuitionConstants.ONLINE_TECH_FEE;
        }

        setTuition(t);

    }

    public boolean getTechFee(){
        return mTechFee;
    }

    public void setTechFee(boolean pTechFee){
        this.mTechFee = pTechFee;
    }

}
