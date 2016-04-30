package com.whs542.ftc2016Practice.susbsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Joyce on 4/29/2016.
 */
public class ScoringMechanism {
    public static final double ENCODER_TICKS = ;
    DcMotor motor;
    public ScoringMechanism(HardwareMap scoringMap) {
        motor = scoringMap.dcMotor.get("motor");
    }
    public void run(boolean forwards, boolean backwards){
        if (motor.getCurrentPosition()< ENCODER_TICKS/3) {
            if(forwards){
                motor.setPower(0.5);
            }else if(backwards){
                motor.setPower(-0.5);
            }else{
                motor.setPower(0.0);
            }

        }else{
            motor.setPower(0.0);
        }
    }
}
