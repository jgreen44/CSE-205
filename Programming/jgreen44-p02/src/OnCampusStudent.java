//********************************************************************************************************
// CLASS: OnCampusStudent
//
// DESCRIPTION
// Calculates the tuition for the on-campus student. Also gets and sets:
//  1. Program Fee
//  2. Residency Status
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Sprint and 2020
// Project Number: 02
//
// AUTHOR: Jason Green, jgreen44, jgreen44@asu.edu
//********************************************************************************************************
public class OnCampusStudent extends Student {


    public static final int RESIDENT = 1;
    public static final int NON_RESIDENT = 2;

    private int mResident = 0;
    private double mProgramFee = 0;

    public OnCampusStudent(String pId, String pFirstName, String pLastName){
        super(pId, pFirstName, pLastName);
    }


    public void calcTuition(){
        double t;
        if (getResidency() == 1){
            t = TuitionConstants.ONCAMP_RES_BASE;
        }else{
            t = TuitionConstants.ONCAMP_NONRES_BASE;
        }

        t += getProgramFee();

        if (getCredits() > TuitionConstants.ONCAMP_MAX_CREDITS){
            t += (getCredits() - TuitionConstants.ONCAMP_MAX_CREDITS)
                    * TuitionConstants.ONCAMP_ADD_CREDITS;
        }

        setTuition(t);

    }

    public double getProgramFee(){
        return mProgramFee;
    }

    public double getResidency(){
        return mResident;
    }

    public void setProgramFee(double pProgramFee){
        this.mProgramFee = pProgramFee;
    }

    public void setResidency(int pResident){
        this.mResident = pResident;
    }




}
