package com.whs542.ftc2016Practice.susbsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Joyce on 4/29/2016.
 */
public class ScoringMechanism {

    static final double ENCODER_TICKS = 1120 ;
    public DcMotor scoringMotor;

    public ScoringMechanism(HardwareMap scoringMap) {
        scoringMotor = scoringMap.dcMotor.get("scoringMechanism");
    }

    public void useScoring(boolean forwards, boolean backwards){
        if (scoringMotor.getCurrentPosition()< ENCODER_TICKS/3 && forwards) {
            scoringMotor.setPower(0.5);
        }else if(scoringMotor.getCurrentPosition()>0 && backwards){
            scoringMotor.setPower(-0.5);
        }else{
            scoringMotor.setPower(0.0);
        }
    }


}
