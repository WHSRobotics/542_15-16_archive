package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by jian on 4/29/2016.
 */
public class ScoringMechanism {
    public static final double ENCODERTICKS = ;
    DcMotor motor;
    public ScoringMechanism(HardwareMap hardwareMap) {
        motor = hardwareMap.dcMotor.get("motor");
    }
    public void run(){
        if (motor.getCurrentPosition()< ENCODERTICKS/3) {
            motor.setPower(.5);
        }
    }
}
