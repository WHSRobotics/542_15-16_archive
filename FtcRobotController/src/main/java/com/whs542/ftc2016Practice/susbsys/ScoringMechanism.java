package com.whs542.ftc2016Practice.susbsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import com.whs542.lib.sensors.EncoderTicks;
/**
 * Created by Joyce on 4/29/2016.
 */
public class ScoringMechanism {

    public DcMotor scoringMotor;
    int state = 1;
    boolean flipState = false;

    public ScoringMechanism(HardwareMap scoringMap)
    {
        scoringMotor = scoringMap.dcMotor.get("scoringMechanism");
    }

    public void flip(boolean forwards, boolean backwards)
    {
        if(forwards)
        {
            for(boolean i = false; i==false;)
            {
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

//<<<<<<< HEAD
    public void scoringAuto(boolean direction) {
        if (direction) {
            while (scoringMotor.getCurrentPosition() < (EncoderTicks.SCORING_MECHANISM / 3) - 100) {
                scoringMotor.setPower(0.5);
            }
        }
        else {
            while (scoringMotor.getCurrentPosition() >= 100){
                scoringMotor.setPower(-0.5);
            }
        }
    }

//=======
    public void flip2 (boolean flip){
        if(flip){
            while (!flipState){
                switch (state){
                    case (1):
                        if (scoringMotor.getCurrentPosition() < (EncoderTicks.SCORING_MECHANISM/3)-100) {
                            scoringMotor.setPower(0.5);
                        }
                        else {
                            scoringMotor.setPower(0.0);
                            state = 2;
                        }
                    case (2):
                        if (scoringMotor.getCurrentPosition() >= 100 ){
                            scoringMotor.setPower(-0.5);
                        }
                        else {
                            scoringMotor.setPower(0.0);
                            flipState = true;
                        }
                }

            }
        }
//>>>>>>> origin/Subsys
    }

}
