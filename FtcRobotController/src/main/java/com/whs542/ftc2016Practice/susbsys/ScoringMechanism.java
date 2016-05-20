package com.whs542.ftc2016Practice.susbsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import com.whs542.lib.sensors.EncoderTicks;
/**
 * Created by Joyce on 4/29/2016.
 */
public class ScoringMechanism {

    public DcMotor scoringMotor;

    public ScoringMechanism(HardwareMap scoringMap) {
        scoringMotor = scoringMap.dcMotor.get("scoringMechanism");
    }

    public void useScoring(boolean forwards, boolean backwards){
        if(forwards){
            for(boolean i = false; i==false;){
                if(scoringMotor.getCurrentPosition() < (EncoderTicks.SCORING_MECHANISM/3)-100){
                    scoringMotor.setPower(0.5);
                }
                else{
                    scoringMotor.setPower(0.0);
                    i = true;
                }
            }

        }
        if (backwards){
            for(boolean i = false; i==false;) {
                if (scoringMotor.getCurrentPosition() >= 100) {
                    scoringMotor.setPower(-0.5);
                }
                else {
                    scoringMotor.setPower(0.0);
                    i = true;
                }
            }
        }
    }

    public void scoringAuto(int ){
        while (scoringMotor.getCurrentPosition() < (EncoderTicks.SCORING_MECHANISM/3)-100)
            scoringMotor.setPower(0.5);
    }

}
